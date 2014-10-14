package com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.recyclerview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.Item;
import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.R;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Item> items;

    public ItemRecyclerViewAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder)viewHolder).text.setText(items.get(position).getText());
        setAnimation(((ViewHolder) viewHolder).view);
    }

    private void setAnimation(View view) {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(),
                R.animator.background_color_animation);
        set.setTarget(view);
        set.start();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            text = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
