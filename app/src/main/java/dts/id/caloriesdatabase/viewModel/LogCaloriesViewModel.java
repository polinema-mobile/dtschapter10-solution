package dts.id.caloriesdatabase.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

import dts.id.caloriesdatabase.CaloriesRepository;
import dts.id.caloriesdatabase.db.entity.LogCaloriesEntity;

public class LogCaloriesViewModel extends AndroidViewModel {
    private CaloriesRepository mCaloriesRepository;
    private LiveData<List<LogCaloriesEntity>> listLogCalories;

    public LogCaloriesViewModel(@NonNull Application application) {
        super(application);
        mCaloriesRepository = new CaloriesRepository(application);
    }

    public LiveData<List<LogCaloriesEntity>> GetListLogCalories(String date) {
        return listLogCalories = mCaloriesRepository.GetAllCaloriesByDate(date);
    }
}
