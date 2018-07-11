package com.chila.mascotas;

import com.chila.mascotas.adapter.MascotaAdaptador;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IFavsActivity {

    public void generarLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);


}
