package belajarlayout.ars.id.bmidatabase.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import belajarlayout.ars.id.bmidatabase.BmiRepository;
import belajarlayout.ars.id.bmidatabase.db.entity.BmiEntity;

//Todo 11
public class BmiViewModel extends AndroidViewModel {

    private BmiRepository repository;
    private LiveData<List<BmiEntity>> allBmi;
    //Todo 12
    public BmiViewModel(Application application) {
        super(application);
        repository = new BmiRepository(application);
        allBmi = repository.getAllBmi();
    }
    public LiveData<List<BmiEntity>> getAllBmi() {
        return allBmi;
    };
    public void insertBmi(BmiEntity bmiEntity){
        repository.insert(bmiEntity);
    }
}
