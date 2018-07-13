package com.tdc.react.reactintegrationapp;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tdc.react.reactintegrationapp.data.FetchCallback;
import com.tdc.react.reactintegrationapp.data.RetrofitClient;
import com.tdc.react.reactintegrationapp.data.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {

    private List<Event> events = new ArrayList<>();
    private EventAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        return inflater.inflate(R.layout.activity_events, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view);

        adapter = new EventAdapter(events, new AdapterClickListener() {
            @Override
            public void onItemClicked(int id) {
                Intent intent = new Intent(getActivity(), ReactNativeActivity.class);
                intent.putExtra("eventFilter", id);
                intent.putExtra("initialScreen", "Talks");
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);

        RetrofitClient.getEventsService().getEvents().enqueue(new FetchCallback<List<Event>>(adapter));

    }
}
