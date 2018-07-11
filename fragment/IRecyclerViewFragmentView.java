package com.chila.mascotas.fragment;

import com.chila.mascotas.adapter.MascotaAdaptador;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
