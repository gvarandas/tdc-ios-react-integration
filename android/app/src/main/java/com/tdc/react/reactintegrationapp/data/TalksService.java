package com.tdc.react.reactintegrationapp.data;

import com.tdc.react.reactintegrationapp.data.model.Talk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TalksService {

    @GET("/v1/publico/evento/104/modalidade/{modalidadeID}/palestras")
    Call<List<Talk>> getTalks(@Path("modalidadeID") int modalidadeID);
}
