package itesm.mx.mindset;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jibril on 11/21/17.
 */

public class UsersOperations {
    private SQLiteDatabase db;
    private UserDBHelper dbHelper;
    private User user;

    private static final String DEBUG_TAG = "USERS_OPERATIONS";

    public UsersOperations (Context context) {
        dbHelper = new UserDBHelper(context);
    }

    public void open() throws SQLException {
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            Log.e("SQLOPEN", e.toString());
        }
    }

    public void close() {
        db.close();
    }

    public long addUser(User user) {
        long newRowId = 0;

        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseSchema.UsersTable.COLUMN_USERNAME, user.getUsername());
            values.put(DataBaseSchema.UsersTable.COLUMN_PASSWORD, user.getPassword());

            newRowId = db.insert(DataBaseSchema.UsersTable.TABLE_NAME, null, values);
        } catch (SQLException e) {
            Log.e("SQLADD", e.toString());
        }

        return newRowId;

    }

    public User findUser(String username) {

        String query = "Select * FROM " +
                DataBaseSchema.UsersTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.UsersTable.COLUMN_USERNAME +
                " = \"" + username + "\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            user = null;
            if (cursor.moveToFirst()) {
                user = new User (
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2)
                );
            }
            cursor.close();

        }catch (SQLException e) {
            Log.e("SQLFIND", e.toString());
        }

        return user;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> listUsers = new ArrayList<User>();

        String selectQuery = "SELECT * FROM " + DataBaseSchema.UsersTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    user = new User(
                            Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2)
                    );

                    listUsers.add(user);
                } while (cursor.moveToNext());
            }
            cursor.close();

        } catch (SQLException e) {
            Log.e("SQLLIST", e.toString());
        }
        return listUsers;
    }

    public void deleteUsers(){
        db.execSQL("delete from " + DataBaseSchema.UsersTable.TABLE_NAME);
    }
}