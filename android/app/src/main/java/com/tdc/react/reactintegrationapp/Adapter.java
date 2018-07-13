package com.tdc.react.reactintegrationapp;

import android.support.v7.widget.RecyclerView;
import java.util.List;

public abstract class Adapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    protected List<T> list;
    protected AdapterClickListener listener;

    Adapter(List<T> list, AdapterClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    protected T getItem(int position) {
        return list.get(position);
    }

    public void updateDataSource(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}
