package com.tdc.react.reactintegrationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tdc.react.reactintegrationapp.data.FetchCallback;
import com.tdc.react.reactintegrationapp.data.RetrofitClient;
import com.tdc.react.reactintegrationapp.data.model.Talk;

import java.util.ArrayList;
import java.util.List;

public class TalksActivity extends AppCompatActivity {

    private List<Talk> talks = new ArrayList<>();
    private TalkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        adapter = new TalkAdapter(talks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);

        int selectedEvent = (int)getIntent().getExtras().getDouble("selectedEvent");
        RetrofitClient.getTalksService().getTalks(selectedEvent).enqueue(new FetchCallback<List<Talk>>(adapter));
    }
}
