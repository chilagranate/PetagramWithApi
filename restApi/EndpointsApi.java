package com.chila.mascotas.restApi;

import com.chila.mascotas.restApi.model.MascotaResponse;
import com.chila.mascotas.restApi.model.PerfilResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_GET_SELF_USER_INFO)
    Call<PerfilResponse> getSelfInfo();
}
