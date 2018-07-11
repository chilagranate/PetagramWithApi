package com.chila.mascotas.restApi;

import retrofit2.http.PUT;

public class ConstantesRestApi {


    //https://api.instagram.com/v1/
    public static final String VERSION                      = "/v1/";
    public static final String ROOT_URL                     = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN                 = "8181444733.32089b1.5ed9bc09f2fd47ec9053e328468b70ec";
    public static final String KEY_ACCESS_TOKEN             = "?access_token=";
    public static final String KEY_GET_INFORMATION_USER     = "users/self/media/recent/" ;
    public static final String URL_GET_RECENT_MEDIA_USER    = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;

    public static final String KEY_GET_SELF_USER_INFO       = "users/self";
    public static final String URL_GET_SELF_USER_INFO       = KEY_GET_SELF_USER_INFO + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



    //https://api.instagram.com/v1/users/self/?access_token=8181444733.32089b1.5ed9bc09f2fd47ec9053e328468b70ec

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
}
