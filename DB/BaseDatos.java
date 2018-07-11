package com.chila.mascotas.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chila.mascotas.R;
import com.chila.mascotas.pojo.Mascota;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;
    private static BaseDatos instance = null;
    private static final int MAX_FAVS = 5;



    public BaseDatos(Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    public static synchronized BaseDatos getInstance(Context context) {
        if (instance == null) {
            instance = new BaseDatos(context);
        }
        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota =         "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                                                ")";

        String queryCrearTablaLikesMascota =    "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA + "("+
                                                ConstantesBaseDatos.TABLE_RAITING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                ConstantesBaseDatos.TABLE_RAITING_ID_CONTACTO + " INTEGER, " +
                                                ConstantesBaseDatos.TABLE_RAITING_NUMERO_LIKES + " INTEGER, " +
                                                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RAITING_ID_CONTACTO + ") " +
                                                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")"+
                                                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMascotas (){

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        /*while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getString(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getString(2));
            mascotas.add(mascotaActual);

        }*/

        db.close();

        return mascotas;
    }
    public void borrarDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);
        db.close();


    }

    public void insertarMascota(ContentValues contentValues){
         SQLiteDatabase db = this.getWritableDatabase();
         db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
         db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikeMascota(Mascota mascota){
        int likes = 0;
        String query =  "SELECT COUNT(" + ConstantesBaseDatos.TABLE_RAITING_NUMERO_LIKES + ")"+
                        " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_RAITING_ID_CONTACTO + "="+ mascota.getId();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public Mascota obtenerMascota(int id){

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " WHERE " +ConstantesBaseDatos.TABLE_MASCOTAS_ID +"="+id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Mascota mascotaActual = new Mascota();
        while(registros.moveToNext()){

            mascotaActual.setId(registros.getString(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getString(2));


        }

        db.close();
        return mascotaActual;

    }

    public ArrayList<Mascota> obtenerMascotasLike() {
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        int i = 0;
        while(registros.moveToNext()&&i<MAX_FAVS){
            Mascota mascota = obtenerMascota(registros.getInt(1));
            if(!MascotaRepetida(mascotas, mascota.getId()))
            mascotas.add(mascota);
            i++;

        }
        db.close();


        return mascotas;


    }

    public boolean MascotaRepetida(ArrayList<Mascota>mascotas, String id){
        boolean repetida = false;

        for(int i = 0; i<mascotas.size() && repetida==false;i++){
            if (mascotas.get(i).getId() == id)
                    repetida = true;

        }
        return repetida;
    }
}
