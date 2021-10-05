package umn.ac.id.andhikanugrahawp_41732_uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SFXAdapter extends RecyclerView.Adapter<SFXAdapter.MyViewHolder> {

    private ArrayList<DataSFX> dataSFXs;
    private RecyclerViewClickListener listener;

    public SFXAdapter(ArrayList<DataSFX> dataSFXs, RecyclerViewClickListener listener) {
        this.dataSFXs = dataSFXs;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView sfxName, sfxType;
        private ImageButton deleteSfx;

        public MyViewHolder(final View view) {
            super(view);

            sfxName = view.findViewById(R.id.sfxName);
            sfxType = view.findViewById(R.id.sfxType);
            deleteSfx = view.findViewById(R.id.deleteSfx);
            view.setOnClickListener(this);

            deleteSfx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public SFXAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_sfx, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SFXAdapter.MyViewHolder holder, int position) {
        String name = dataSFXs.get(position).getsfxName();
        String type = dataSFXs.get(position).getsfxType();
        holder.sfxName.setText(name);
        holder.sfxType.setText(type);
    }

    @Override
    public int getItemCount() {
        return dataSFXs.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int Position);
        void onDeleteClick(int Position);

    }
}
