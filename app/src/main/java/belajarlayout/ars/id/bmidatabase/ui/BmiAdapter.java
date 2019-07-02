package belajarlayout.ars.id.bmidatabase.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import belajarlayout.ars.id.bmidatabase.R;
import belajarlayout.ars.id.bmidatabase.db.entity.BmiEntity;

public class BmiAdapter extends RecyclerView.Adapter<BmiAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<BmiEntity> listBmiEntities; // Cached copy of words

    public BmiAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

    }
    void setBMI(List<BmiEntity> listBmi){
        listBmiEntities = listBmi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BmiEntity bmi = listBmiEntities.get(position);
        holder.bmiItemView.setText(String.valueOf(bmi.getBmiResult()));
    }

    @Override
    public int getItemCount() {
        return listBmiEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bmiItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bmiItemView = itemView.findViewById(R.id.tvBmiResult);
        }
    }
}
