package com.chila.mascotas.adapter;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chila.mascotas.DB.ConstructorMascotas;
import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override

    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        //mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvName.setText(mascota.getNombre());
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        mascotaViewHolder.tvRate.setText(constructorMascotas.obtenerLikesMascota(mascota));
        Picasso.get()
                .load(mascota.getFoto())
                .resize(350, 350)
                .centerCrop()
                .into(mascotaViewHolder.imgFotoMascota);


        mascotaViewHolder.imgCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRate.setText(constructorMascotas.obtenerLikesMascota(mascota));


            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();

    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView imgCV;
        private TextView tvName;
        private TextView tvRate;
        private ImageView imgCVRate;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota  = itemView.findViewById(R.id.imgFotoMascota);
            imgCV           = itemView.findViewById(R.id.imgCV);
            tvName          = itemView.findViewById(R.id.tvName);
            tvRate          = itemView.findViewById(R.id.tvRate);
            imgCVRate       = itemView.findViewById(R.id.imgCVRate);

        }
    }
}
