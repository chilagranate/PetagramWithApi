package com.chila.mascotas.restApi.model;

import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {

    private ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
