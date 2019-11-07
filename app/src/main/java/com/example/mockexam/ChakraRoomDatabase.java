package com.example.mockexam;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ChakraEntity.class}, version = 1, exportSchema = false)
public abstract class ChakraRoomDatabase extends RoomDatabase {
    public abstract ChakraDao chakraDao();
    private static ChakraRoomDatabase INSTANCE;

    static ChakraRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ChakraRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ChakraRoomDatabase.class, "chakra_info")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final ChakraDao mDao;
        PopulateDbAsync(ChakraRoomDatabase db) {
            mDao = db.chakraDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created

            return null;
        }
    }


}
