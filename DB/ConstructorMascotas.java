package com.chila.mascotas.DB;

import android.content.ContentValues;
import android.content.Context;

import com.chila.mascotas.R;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = BaseDatos.getInstance(context);
        insertarTresMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){


        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bobby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito);
        db.insertarMascota(contentValues);

        ContentValues contentValues1= new ContentValues();
        contentValues1.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Manuelita");
        contentValues1.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.tortuga);
        db.insertarMascota(contentValues1);

        ContentValues contentValues2= new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Birdy");
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pajaro);
        db.insertarMascota(contentValues2);

        ContentValues contentValues3= new ContentValues();
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Nemo");
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.red_nemo);
        db.insertarMascota(contentValues3);

        ContentValues contentValues4= new ContentValues();
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Firulais");
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato);
        db.insertarMascota(contentValues4);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = BaseDatos.getInstance(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public String obtenerLikesMascota(Mascota mascota){


        BaseDatos db = BaseDatos.getInstance(context);

        int likes = db.obtenerLikeMascota(mascota);

        return Integer.toString(likes);


    }





}
