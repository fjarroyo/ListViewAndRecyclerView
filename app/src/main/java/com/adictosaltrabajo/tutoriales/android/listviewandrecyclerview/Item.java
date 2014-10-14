package com.adictosaltrabajo.tutoriales.android.listviewandrecyclerview;

public class Item {

    public final int id;

    public int count = 0;

    public Item(int id) {
        this.id = id;
    }

    public void increment() {
        count = count + 1;
    }

    public String getText() {
        return "Id " + id + " count " + count;
    }

}
