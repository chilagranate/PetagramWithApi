package com.chila.mascotas.fragment;

import com.chila.mascotas.adapter.FotoAdaptador;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public void inicializarAdaptador(FotoAdaptador adaptador);

    public void generarGridLayout();

    public FotoAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void ponerFotoPerfil(String urlFotoPerfil);

    }
