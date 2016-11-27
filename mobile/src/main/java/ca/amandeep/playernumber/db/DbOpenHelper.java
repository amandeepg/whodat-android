package ca.amandeep.playernumber.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ca.amandeep.playernumber.models.PlayerModel;
import ca.amandeep.playernumber.models.TeamModel;

public final class DbOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static DbOpenHelper instance;

    public DbOpenHelper(Context context) {
        super(context, "db.db", null, DATABASE_VERSION);
    }

    public static DbOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbOpenHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TeamModel.CREATE_TABLE);
        db.execSQL(PlayerModel.CREATE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}