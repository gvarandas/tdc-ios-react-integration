package com.tdc.react.reactintegrationapp.data;

import com.tdc.react.reactintegrationapp.data.model.Login;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OAuthInterceptor implements Interceptor {

    private static String token = null;
    private static String tokenType = null;

    @Override
    public Response intercept(Chain chain) throws IOException {

        return sendRequest(chain);
    }

    private Response sendRequest(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Response mainResponse;
        if (token != null) {
            Request newRequest = addOAuthHeader(chain.request());
            mainResponse = chain.proceed(newRequest);
        } else {
            mainResponse = chain.proceed(originalRequest);
        }

        if (mainResponse.code() == 401 || mainResponse.code() == 403) {//Token error
            token = null;
            if (performLogin()) {
                mainResponse = chain.proceed(addOAuthHeader(originalRequest));
            }
        }

        return mainResponse;
    }

    private Request addOAuthHeader(Request originalRequest) {
        return addOAuthHeader(originalRequest, false);
    }

    private Request addOAuthHeader(Request originalRequest, boolean addMethod) {
        Request.Builder builder = originalRequest.newBuilder().header("Authorization", tokenType + " " + token);
        if (addMethod) {
            builder.method(originalRequest.method(), originalRequest.body());
        }
        return builder.build();
    }

    private boolean performLogin() {
        try {
            retrofit2.Response<Login> responseLogin = RetrofitClient.loginService().login(RetrofitClient.getLoginSecret()).execute();
            if (responseLogin.isSuccessful()) {
                token = responseLogin.body().getAccessToken();
                tokenType = responseLogin.body().getTokenType();
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
