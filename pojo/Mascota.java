package com.chila.mascotas.pojo;

public class Mascota {
    private String id;
    private String urlFoto;
    private String nombre;
    private int raiting;

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mascota(String foto, String nombre, int raiting) {
        this.urlFoto = foto;
        this.nombre = nombre;
        this.raiting = raiting;
    }

    public String getFoto() {
        return urlFoto;
    }

    public void setFoto(String foto) {
        this.urlFoto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void like (){
        this.raiting += 1;
    }
}
