package com.tdc.react.reactintegrationapp.data;

import com.tdc.react.reactintegrationapp.Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchCallback<T> implements Callback<T> {

    Adapter adapter;

    public FetchCallback(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T obj = response.body();
        adapter.updateDataSource((List) obj);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
