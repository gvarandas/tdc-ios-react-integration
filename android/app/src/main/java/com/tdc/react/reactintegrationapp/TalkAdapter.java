package com.tdc.react.reactintegrationapp;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tdc.react.reactintegrationapp.data.model.Talk;

import java.util.List;

public class TalkAdapter extends Adapter<Talk, TalkAdapter.TalkHolder> {

    TalkAdapter(List<Talk> talks) {
        super(talks, null);
    }

    public class TalkHolder extends RecyclerView.ViewHolder {
        public TextView description, date, title;

        public TalkHolder(View view) {
            super(view);
            title = view.findViewById(R.id.description);
            date = view.findViewById(R.id.date);
            description = view.findViewById(R.id.target);
        }
    }

    public void updateDataSource(List<Talk> talks) {
        this.list = talks;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TalkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_adapter, parent, false);

        return new TalkHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TalkHolder holder, int position) {
        Talk talk = list.get(position);
        holder.description.setText(Html.fromHtml(talk.getDescricao()));
        holder.title.setText(talk.getTitulo());
        holder.date.setText(talk.getHorario());
    }
}
