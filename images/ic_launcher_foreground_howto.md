# ic_launcher_foreground regeneration

Source image:
- `images/flat-icon.webp`
- `images/monochrome-icon.svg`

Output targets:
- `app/src/main/res/mipmap-{mdpi,hdpi,xhdpi,xxhdpi,xxxhdpi}/ic_launcher_foreground.webp`
- `app/src/main/res/mipmap-{mdpi,hdpi,xhdpi,xxhdpi,xxxhdpi}/ic_launcher_monochrome.webp`

Current sizing rules:
- Adaptive canvas size: 108/162/216/324/432 px per density.
- Foreground art size: 57% of the adaptive canvas.
- Vertical offset: +2% (move a hair down).
- Output: WebP, lossless, highest compression.

Regenerate (requires ImageMagick and cwebp):

```bash
tmpdir=$(mktemp -d)
src="images/flat-icon.webp"

densities=(mdpi hdpi xhdpi xxhdpi xxxhdpi)
adaptive_sizes=(108 162 216 324 432)

for i in "${!densities[@]}"; do
  d=${densities[$i]}
  adaptive=${adaptive_sizes[$i]}
  inner=$((adaptive * 57 / 100))
  offset=$((adaptive * 2 / 100))

  magick -size ${adaptive}x${adaptive} xc:none \
    \( "$src" -trim +repage -resize ${inner}x${inner} \) \
    -gravity center -geometry +0+${offset} -composite \
    "$tmpdir/ic_launcher_foreground_${d}.png"

  magick -size ${adaptive}x${adaptive} xc:none \
    \( "$src" -trim +repage -resize ${inner}x${inner} -alpha on -channel RGB -fill white -colorize 100 \) \
    -gravity center -geometry +0+${offset} -composite \
    "$tmpdir/ic_launcher_monochrome_${d}.png"

  cwebp -lossless -z 9 -m 6 "$tmpdir/ic_launcher_foreground_${d}.png" \
    -o "app/src/main/res/mipmap-${d}/ic_launcher_foreground.webp" >/dev/null
  cwebp -lossless -z 9 -m 6 "$tmpdir/ic_launcher_monochrome_${d}.png" \
    -o "app/src/main/res/mipmap-${d}/ic_launcher_monochrome.webp" >/dev/null
done

rm -rf "$tmpdir"
```

## Monochrome vector drawable generation

Source SVG:
- `images/monochrome-icon.svg`

Output target:
- `app/src/main/res/drawable/ic_launcher_monochrome.xml`

Steps (requires Inkscape + ImageMagick):

```bash
svg="images/monochrome-icon.svg"
out="app/src/main/res/drawable/ic_launcher_monochrome.xml"

python - <<'PY'
import xml.etree.ElementTree as ET
from pathlib import Path
import subprocess, re

ANDROID_NS = "http://schemas.android.com/apk/res/android"

def bbox_from_png(png_path: str):
    cmd = [
        "magick", png_path,
        "-alpha", "extract",
        "-threshold", "0",
        "-define", "connected-components:verbose=true",
        "-connected-components", "4",
        "-auto-level",
        "null:",
    ]
    out = subprocess.check_output(cmd, text=True)
    boxes = []
    for line in out.splitlines():
        line = line.strip()
        m = re.match(r"^(\\d+):\\s+(\\d+)x(\\d+)\\+(\\d+)\\+(\\d+)\\s+", line)
        if not m:
            continue
        obj_id = int(m.group(1))
        w, h, x, y = map(int, m.groups()[1:])
        if obj_id == 0:
            continue
        boxes.append((x, y, x + w, y + h))
    if not boxes:
        return None
    min_x = min(b[0] for b in boxes)
    min_y = min(b[1] for b in boxes)
    max_x = max(b[2] for b in boxes)
    max_y = max(b[3] for b in boxes)
    return (min_x, min_y, max_x, max_y)

svg = "images/monochrome-icon.svg"
canvas = 600
inner = canvas * 0.57

# Render original to PNG and measure bbox
orig_png = "/tmp/monochrome_icon_orig.png"
subprocess.check_call([
    "inkscape", svg,
    "--export-type=png",
    f"--export-filename={orig_png}",
    f"--export-width={canvas}",
    f"--export-height={canvas}",
], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

orig_bbox = bbox_from_png(orig_png)
if not orig_bbox:
    raise SystemExit("No bbox from source SVG render")

w0 = orig_bbox[2] - orig_bbox[0]
h0 = orig_bbox[3] - orig_bbox[1]

# Scale to 57% of adaptive canvas
s = inner / max(w0, h0)

# Center on canvas, with +2% vertical offset
tx = (canvas - w0 * s) / 2 - orig_bbox[0] * s
ty = (canvas - h0 * s) / 2 - orig_bbox[1] * s + canvas * 0.02

print(f"scale={s}")
print(f"translateX={tx}, translateY={ty}")
PY
```

Then update `app/src/main/res/drawable/ic_launcher_monochrome.xml` to wrap the paths in an outer `<group>`
with the printed `scaleX/scaleY` and `translateX/translateY` values. Keep the inner path data unchanged.
