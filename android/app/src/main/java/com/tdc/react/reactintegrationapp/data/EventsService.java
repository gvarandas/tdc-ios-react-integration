package com.tdc.react.reactintegrationapp.data;

import com.tdc.react.reactintegrationapp.data.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Class mapped to Event through JSON
 */
public interface EventsService {

    @GET("/v1/publico/evento/104/modalidades")
    Call<List<Event>> getEvents();
}
