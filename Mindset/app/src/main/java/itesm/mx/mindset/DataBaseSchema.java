package itesm.mx.mindset;

import android.provider.BaseColumns;

/**
 * Created by Jibril on 11/13/17.
 */

public class DataBaseSchema {

    private DataBaseSchema() {}

    public static class EventsTable implements BaseColumns {
        public static final String TABLE_NAME = "Event";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_HOUR = "hour";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DURATION = "duration"; //In hours
        public static final String COLUMN_COMPLETED = "completed";
    }

    public static class UsersTable implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }

}
