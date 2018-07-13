package com.tdc.react.reactintegrationapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tdc.react.reactintegrationapp.data.model.Event;

import java.util.List;

public class EventAdapter extends Adapter<Event, EventAdapter.EventHolder> {

    EventAdapter(List<Event> list, AdapterClickListener listener) {
        super(list, listener);
    }

    public class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView description, date, target;
        private AdapterClickListener listener;

        public EventHolder(View view, AdapterClickListener listener) {
            super(view);
            this.listener = listener;
            description = view.findViewById(R.id.description);
            date = view.findViewById(R.id.date);
            target = view.findViewById(R.id.target);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                Event item = getItem(this.getAdapterPosition());
                listener.onItemClicked(item.getId());
            }
        }
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_adapter, parent, false);

        return new EventHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        Event event = list.get(position);
        holder.description.setText(event.getDescricao());
        holder.target.setText(event.getPublicoAlvo());
        holder.date.setText(event.getData());
    }
}
