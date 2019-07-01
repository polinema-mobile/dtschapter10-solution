package belajarlayout.ars.id.bmidatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import belajarlayout.ars.id.bmidatabase.db.BmiRoomDatabase;
import belajarlayout.ars.id.bmidatabase.db.dao.BmiDao;
import belajarlayout.ars.id.bmidatabase.db.entity.BmiEntity;

//Todo 9
public class BmiRepository {
    //Todo 10
    private BmiDao bmiDao;
    private LiveData<List<BmiEntity>> allBmi;

    public BmiRepository(Application application) {
        BmiRoomDatabase db = BmiRoomDatabase.getDatabase(application);
        bmiDao = db.bmiDao();
        allBmi = bmiDao.getAllBmiData();
    }

    public LiveData<List<BmiEntity>> getAllBmi(){
        return allBmi;
    }

    public void insert(BmiEntity bmiEntity) {
        new insertBmiAsyncTask(bmiDao).execute(bmiEntity);
    }

    private static class insertBmiAsyncTask extends AsyncTask<BmiEntity,Void,Void >{

        private BmiDao asyncTaskDao;

        public insertBmiAsyncTask(BmiDao asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected Void doInBackground(BmiEntity... bmiEntities) {
            this.asyncTaskDao.insert(bmiEntities[0]);
            return null;
        }
    }


}
