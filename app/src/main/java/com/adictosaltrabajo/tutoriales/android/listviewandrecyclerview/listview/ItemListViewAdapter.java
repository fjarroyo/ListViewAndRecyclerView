package com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.listview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.Item;
import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.R;

import java.util.List;

public class ItemListViewAdapter extends BaseAdapter {

    private final List<Item> items;

    public ItemListViewAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, null);
            //Creamos viewholder
            viewHolder = new ViewHolder();
            //Referenciamos los componentes en el viewholder
            viewHolder.textView = (TextView) convertView.findViewById(android.R.id.text1);
            //Guardamos viewholder en la vista
            convertView.setTag(viewHolder);
        } else {
            //Recuperamos viewholder de la vista reusada por Android
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Usamos el TextView. En caso se que se haya pasado en convertView la vista
        //hemos evitado instanciarla y usar findViewById
        viewHolder.textView.setText(getItem(position).getText());

        setAnimation(convertView);
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }

    private void setAnimation(View view) {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(),
                R.animator.background_color_animation);
        set.setTarget(view);
        set.start();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
