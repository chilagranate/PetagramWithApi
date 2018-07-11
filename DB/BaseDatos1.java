package com.chila.mascotas.DB;

class BaseDatos1 {
    private static final BaseDatos1 ourInstance = new BaseDatos1();

    static BaseDatos1 getInstance() {
        return ourInstance;
    }

    private BaseDatos1() {
    }
}
