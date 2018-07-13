package com.tdc.react.reactintegrationapp.data;

import android.content.Context;
import android.util.Base64;

import com.tdc.react.reactintegrationapp.Config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static String clientID = null;
    private static String password = null;

    public static final String BASE_URL = "https://api.globalcode.com.br/";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttp())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static OkHttpClient getOkHttp() {
        return new OkHttpClient.Builder().addInterceptor(new OAuthInterceptor()).build();
    }

    public static void configureAuthenticator(Context context) {
        clientID = Config.getValue(context, "clientID");
        password = Config.getValue(context, "password");
    }

    public static String getLoginSecret() {
        String credential = clientID + ":" + password;
        return "Basic " + Base64.encodeToString(credential.getBytes(), Base64.NO_WRAP).replace('\n', ' ');
    }

    public static EventsService getEventsService() {
        return RetrofitClient.getClient().create(EventsService.class);
    }

    public static LoginService loginService() {
        return RetrofitClient.getClient().create(LoginService.class);
    }

    public static TalksService getTalksService() {
        return RetrofitClient.getClient().create(TalksService.class);
    }
}

