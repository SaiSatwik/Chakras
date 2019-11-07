package com.example.mockexam;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RoomDatabase;

public class ChakraRepository {
    private ChakraDao mChakraDao;
    private LiveData<List<ChakraEntity>> mAllChakras;

    ChakraRepository(Application application) {
        ChakraRoomDatabase db = ChakraRoomDatabase.getDatabase(application);
        mChakraDao = db.chakraDao();
        mAllChakras = mChakraDao.getAllChakras();
    }

    LiveData<List<ChakraEntity>> getAllChakras() {
        return mAllChakras;
    }

    public void insert (ChakraEntity chakra) {
        new insertAsyncTask(mChakraDao).execute(chakra);
    }
    public void deleteAll () {
        new deleteAllAsyncTask(mChakraDao).execute();
    }

    private static class insertAsyncTask extends AsyncTask<ChakraEntity, Void, Void> {

        private ChakraDao mAsyncTaskDao;

        insertAsyncTask(ChakraDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ChakraEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private ChakraDao mAsyncTaskDao;

        deleteAllAsyncTask(ChakraDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}
