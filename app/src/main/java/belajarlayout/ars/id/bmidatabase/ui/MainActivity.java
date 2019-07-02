package belajarlayout.ars.id.bmidatabase.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import belajarlayout.ars.id.bmidatabase.R;
import belajarlayout.ars.id.bmidatabase.db.entity.BmiEntity;
import belajarlayout.ars.id.bmidatabase.viewModel.BmiViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BmiAdapter adapter;
    private BmiViewModel bmiViewModel;
    public static final int REQUEST_CODE = 100;

    Button btnAddBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddBMI = findViewById(R.id.btn_add_bmi);
        recyclerView = findViewById(R.id.recycler_bmi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BmiAdapter(this);

        bmiViewModel = ViewModelProviders.of(this).get(BmiViewModel.class);
        recyclerView.setAdapter(adapter);
        bmiViewModel.getAllBmi().observe(this, new Observer<List<BmiEntity>>() {

            @Override
            public void onChanged(List<BmiEntity> bmiEntities) {
                adapter.setBMI(bmiEntities);
            }
        });


        btnAddBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewBmiActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            BmiEntity bmiEntity = new BmiEntity();
            bmiEntity.setBmiResult(Float.valueOf(data.getStringExtra(NewBmiActivity.EXTRA_REPLY)));
            bmiViewModel.insertBmi(bmiEntity);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Not Save",
                    Toast.LENGTH_LONG).show();
        }
    }
}
