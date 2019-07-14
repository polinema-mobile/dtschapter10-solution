package dts.id.caloriesdatabase.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dts.id.caloriesdatabase.db.dao.LogCaloriesDao;
import dts.id.caloriesdatabase.db.entity.LogCaloriesEntity;

@Database(entities = {LogCaloriesEntity.class}, version = 1)
public abstract class CaloriesRoomDatabase extends RoomDatabase {
    private  static  CaloriesRoomDatabase Instance;
    private static final String DATABASE_NAME = "CaloriesDatabase";

    public abstract LogCaloriesDao logCaloriesDao();

    public  static CaloriesRoomDatabase GetDatabase(Context context){
        if(Instance == null){
            synchronized (CaloriesRoomDatabase.class){
                if (Instance == null) {
                    Instance = Room.databaseBuilder(context, CaloriesRoomDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return Instance;
    }


}
