package com.vishalecho.android.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vishalecho.android.R;
import com.vishalecho.android.data.network.model.Jock;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomJocksAdapter extends RecyclerView.Adapter<RandomJocksAdapter.JockViewHolder> {

    private List<Jock> items;

    public RandomJocksAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(List<Jock> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jock, parent, false);
        return new JockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JockViewHolder holder, int position) {
        holder.bind(position);
    }

    public List<Jock> getItems() {
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private Jock getItem(int position) {
        return items.get(position);
    }

    public class JockViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recent_jock_text_view)
        TextView jockTextView;

        JockViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(int position) {
            Jock jock = getItem(position);
            setJock(jock.getJoke());
        }

        private void setJock(String jock) {
            this.jockTextView.setText(jock);
        }
    }
}
