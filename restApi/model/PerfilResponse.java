package com.chila.mascotas.restApi.model;

import com.chila.mascotas.pojo.Mascota;

public class PerfilResponse {

    private Mascota mascota;

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
