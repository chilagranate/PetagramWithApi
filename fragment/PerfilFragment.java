package com.chila.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chila.mascotas.adapter.FotoAdaptador;
import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.R;
import com.chila.mascotas.adapter.MascotaAdaptador;
import com.chila.mascotas.presentador.IPerfilFragmentPresenter;
import com.chila.mascotas.presentador.PerfilFragmentPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PerfilFragment extends android.support.v4.app.Fragment implements IPerfilFragmentView{
    private RecyclerView listaFotos;



    private IPerfilFragmentPresenter presenter;
    private ImageView fotoPerfil;
    ArrayList<Mascota> fotos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        listaFotos = v.findViewById(R.id.rvFotosSubidas);
        fotoPerfil = v.findViewById(R.id.fotoPerfil);
        presenter = new PerfilFragmentPresenter(this, getContext());

        return v;
    }



    @Override
    public void inicializarAdaptador(FotoAdaptador adaptador) {
        listaFotos.setAdapter(adaptador);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaFotos.setLayoutManager(llm);

    }

    @Override
    public FotoAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        FotoAdaptador adaptador = new FotoAdaptador(mascotas, getContext());
        return adaptador;

    }

    @Override
    public void ponerFotoPerfil(String urlFotoPerfil) {
        Picasso.get()
                .load(urlFotoPerfil)
                .resize(350, 350)
                .centerCrop()
                .into(fotoPerfil);

    }
}
