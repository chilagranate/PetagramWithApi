package com.chila.mascotas.DB;

import android.app.Activity;

import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotasFavs {

    private Activity activity;
    private ArrayList<Mascota> mascotas;
    public ConstructorMascotasFavs(Activity activity){
        this.activity = activity;
    }

    public ArrayList<Mascota> obtenerMascotasLike(){
        BaseDatos db = BaseDatos.getInstance(activity);
        return db.obtenerMascotasLike();
    }

}
