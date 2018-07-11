package com.chila.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.chila.mascotas.fragment.IPerfilFragmentView;
import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.restApi.EndpointsApi;
import com.chila.mascotas.restApi.adapter.RestApiAdapter;
import com.chila.mascotas.restApi.model.MascotaResponse;
import com.chila.mascotas.restApi.model.PerfilResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragmentView iPerfilFragmentView;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private Mascota perfil;
    private Context context;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.context = context;
        this.iPerfilFragmentView = iPerfilFragmentView;
        obtenerMediosRecientes();
        obtenerFotoPerfil();
    }

    private void obtenerFotoPerfil() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonUserData = restApiAdapter.construyeGsonDeserealizadorUser();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUserData);
        Call<PerfilResponse> perfilResponseCall = endpointsApi.getSelfInfo();

        perfilResponseCall.enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                PerfilResponse perfilResponse = response.body();
                perfil = perfilResponse.getMascota();
                iPerfilFragmentView.ponerFotoPerfil(perfil.getFoto());
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilFragmentView.inicializarAdaptador(iPerfilFragmentView.crearAdaptador(mascotas));
        iPerfilFragmentView.generarGridLayout();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserealizadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {

            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un error en la conexión!", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION",t.toString());

            }
        });

    }
}
