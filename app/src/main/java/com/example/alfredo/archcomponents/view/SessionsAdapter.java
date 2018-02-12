package com.example.alfredo.archcomponents.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alfredo.archcomponents.R;
import com.example.alfredo.archcomponents.pojos.DisplayItem;

import java.util.List;

/**
 * Created by alfredo on 2/11/18.
 */

class SessionsAdapter extends RecyclerView.Adapter<SessionsAdapter.ViewHolder> {
    List<DisplayItem> items;

    public void setItems(List<DisplayItem> listItems) {
        this.items = listItems;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.address.setText(items.get(position).address);
        holder.date.setText(items.get(position).date);
        holder.zone.setText(items.get(position).zone);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView address;
        TextView zone;

        public ViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            address = itemView.findViewById(R.id.address);
            zone = itemView.findViewById(R.id.zone);
        }
    }
}
