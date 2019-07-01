package belajarlayout.ars.id.bmidatabase.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import belajarlayout.ars.id.bmidatabase.db.entity.BmiEntity;

//Todo 5 tambah Dao Annotation
@Dao
public interface BmiDao {

    //Todo 6 tambah query yang dapat dilakukan pada table bmi_table
    @Insert
    void insert (BmiEntity bmi);

    @Query("Delete from bmi_table")
    void deleteAllBmi();

    @Query("Select * from bmi_table Order by id ASC")
    LiveData<List<BmiEntity>> getAllBmiData();
}
