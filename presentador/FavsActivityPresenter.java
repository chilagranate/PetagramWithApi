package com.chila.mascotas.presentador;

import android.app.Activity;


import com.chila.mascotas.DB.ConstructorMascotasFavs;
import com.chila.mascotas.IFavsActivity;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class FavsActivityPresenter implements IFavsActivityPresenter {
    private IFavsActivity iFavsActivity;
    Activity activity;

    private ArrayList<Mascota> mascotas;

    public FavsActivityPresenter(IFavsActivity iFavsActivity, Activity activity){
        this.iFavsActivity =iFavsActivity;
        this.activity = activity;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        ConstructorMascotasFavs constructorMascotasFavs = new ConstructorMascotasFavs(activity);
        mascotas = constructorMascotasFavs.obtenerMascotasLike();
        mostrarMascotasRV();


    }

    @Override
    public void mostrarMascotasRV() {
        iFavsActivity.inicializarAdaptador(iFavsActivity.crearAdaptador(mascotas));
        iFavsActivity.generarLayout();



    }
}
