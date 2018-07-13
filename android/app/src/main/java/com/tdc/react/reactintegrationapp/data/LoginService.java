package com.tdc.react.reactintegrationapp.data;

import com.tdc.react.reactintegrationapp.data.model.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Class mapped to Event through JSON
 */
public interface LoginService {

    @GET("/v1/oauth2/token")
    Call<Login> login(@Header("Authorization") String authKey);
}
