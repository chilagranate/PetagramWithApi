package com.chila.mascotas.restApi.adapter;

import com.chila.mascotas.restApi.ConstantesRestApi;
import com.chila.mascotas.restApi.EndpointsApi;
import com.chila.mascotas.restApi.deserealizador.MascotaDeserealizador;
import com.chila.mascotas.restApi.deserealizador.PerfilInfoDeserealizador;
import com.chila.mascotas.restApi.model.MascotaResponse;
import com.chila.mascotas.restApi.model.PerfilResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserealizadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserealizador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserealizadorUser(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilInfoDeserealizador());
        return gsonBuilder.create();
    }
}
