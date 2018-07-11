package com.chila.mascotas.restApi.deserealizador;

import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.restApi.JsonKeys;
import com.chila.mascotas.restApi.model.PerfilResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class PerfilInfoDeserealizador implements JsonDeserializer<PerfilResponse> {
    @Override
    public PerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilResponse perfilResponse = gson.fromJson(json,PerfilResponse.class);
        JsonObject perfilData = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);
        String urlFoto = perfilData.get(JsonKeys.USER_PROFILE_FOTO).getAsString();
        Mascota mascota = new Mascota();
        mascota.setFoto(urlFoto);
        perfilResponse.setMascota(mascota);


        return perfilResponse;
    }
}
