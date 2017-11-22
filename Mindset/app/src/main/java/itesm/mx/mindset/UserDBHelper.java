package itesm.mx.mindset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jibril on 11/21/17.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UsersDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DEBUG_TAG = "USERS_DB_HELPER";

    public UserDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE " +
                DataBaseSchema.UsersTable.TABLE_NAME +
                "(" +
                DataBaseSchema.UsersTable._ID + " INTEGER PRIMARY KEY, " +
                DataBaseSchema.UsersTable.COLUMN_USERNAME + " TEXT," +//Date from calendar.
                DataBaseSchema.UsersTable.COLUMN_PASSWORD + " TEXT" +//Hour of event added.
                ")";

        Log.d(DEBUG_TAG, CREATE_USERS_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_USERS_TABLE = "DROP TABLE IF EXISTS " +
                DataBaseSchema.UsersTable.TABLE_NAME;

        Log.d(DEBUG_TAG, DELETE_USERS_TABLE);
        db.execSQL(DELETE_USERS_TABLE);
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
