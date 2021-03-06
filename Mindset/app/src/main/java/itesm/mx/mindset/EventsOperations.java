package itesm.mx.mindset;

/**
 * Created by Jibril on 11/13/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/30/17.
 */

public class EventsOperations {

    private SQLiteDatabase db;
    private EventDBHelper dbHelper;
    private Event event;

    private static final String DEBUG_TAG = "EVENTSOPERATIONS";

    public EventsOperations (Context context) {
        dbHelper = new EventDBHelper(context);
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

    public long addEvent(Event event) {
        long newRowId = 0;

        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseSchema.EventsTable.COLUMN_DATE, event.getDate());
            values.put(DataBaseSchema.EventsTable.COLUMN_HOUR, event.getHour());
            values.put(DataBaseSchema.EventsTable.COLUMN_NAME, event.getName());
            values.put(DataBaseSchema.EventsTable.COLUMN_DESCRIPTION, event.getDescription());
            values.put(DataBaseSchema.EventsTable.COLUMN_DURATION, event.getDuration());
            values.put(DataBaseSchema.EventsTable.COLUMN_COMPLETED, event.getCompleted());

            newRowId = db.insert(DataBaseSchema.EventsTable.TABLE_NAME, null, values);
        } catch (SQLException e) {
            Log.e("SQLADD", e.toString());
        }

        return newRowId;

    }

    public Event findEvent(int position) {

        String query = "Select * FROM " +
                DataBaseSchema.EventsTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.EventsTable._ID +
                " = \"" + position + "\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            event = null;
            if (cursor.moveToFirst()) {
                event = new Event(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        Integer.parseInt(cursor.getString(5)),
                        Boolean.parseBoolean(cursor.getString(6))
                );
            }
            cursor.close();

        }catch (SQLException e) {
            Log.e("SQLFIND", e.toString());
        }

        return event;
    }

    public boolean updateStatusTask(int position) {

        position++;//Column row starts at 1.
        Log.d(DEBUG_TAG, "Position: " + position);

        String query = "UPDATE  " +
                DataBaseSchema.EventsTable.TABLE_NAME +
                " SET " + DataBaseSchema.EventsTable.COLUMN_COMPLETED + "='true'" +
                " WHERE " + DataBaseSchema.EventsTable._ID +
                " = \"" + position + "\"";

        try {
            Log.d(DEBUG_TAG, "Query: " + query);
            db.execSQL(query);

        }catch (SQLException e) {
            Log.e("SQLFIND", e.toString());
        }

        return false;
    }

//    public boolean deleteEvent(String eventName) {
//
//        boolean result = false;
//
////        String query = "SELECT * FROM " + DataBaseSchema.ElectrosTable.TABLE_NAME +
////                " WHERE " + DataBaseSchema.ElectrosTable.COLUMN_NAME +
////                " = \"" + electroName + "\"";
////
////        try {
////            Cursor cursor = db.rawQuery(query, null);
////            if (cursor.moveToFirst()) {
////                int id = Integer.parseInt((cursor.getString(0)));
////                db.delete(DataBaseSchema.ElectrosTable.TABLE_NAME,
////                        DataBaseSchema.ElectrosTable._ID + " = ?",
////                        new String[]{String.valueOf(id)});
////                result = true;
////            }
////            cursor.close();
////        } catch (SQLException e) {
////            Log.e("SQLDELETE", e.toString());
////        }
//
//        return result;
//    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> listEvents = new ArrayList<Event>();

        String selectQuery = "SELECT * FROM " + DataBaseSchema.EventsTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    event = new Event(
                            Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            Integer.parseInt(cursor.getString(5)),
                            Boolean.parseBoolean(cursor.getString(6))
                    );

                    listEvents.add(event);
                } while (cursor.moveToNext());
            }
            cursor.close();

        } catch (SQLException e) {
            Log.e("SQLLIST", e.toString());
        }
        return listEvents;
    }

    public void deleteEvents(){
        db.execSQL("delete from " + DataBaseSchema.EventsTable.TABLE_NAME);
    }
}
