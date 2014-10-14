package com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.listview.ItemListViewAdapter;
import com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview.recyclerview.ItemRecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MyActivity extends Activity {

    final List<Item> items = getItems();

    @InjectView(R.id.lvItems)
    ListView lvItems;

    @InjectView(R.id.rvItems)
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.inject(this);


        lvItems.setAdapter(new ItemListViewAdapter(items));

        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new ItemRecyclerViewAdapter(items));
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setItemAnimator(new DefaultItemAnimator());

    }

    @OnClick(R.id.bt1)
    public void button1() {
        increment(0);
    }

    @OnClick(R.id.bt2)
    public void button2() {
        increment(1);
    }

    @OnClick(R.id.bt3)
    public void button3() {
        increment(2);
    }

    private void increment(int position) {
        items.get(position).increment();

        refreshListView();
        refreshRecyclerView(position);
    }

    private void refreshListView() {
        ((BaseAdapter) lvItems.getAdapter()).notifyDataSetChanged();
    }

    private void refreshRecyclerView(int position) {
        rvItems.getAdapter().notifyItemChanged(position);
    }

    private List<Item> getItems() {
        return Arrays.asList(new Item(1), new Item(2), new Item(3));
    }


}
