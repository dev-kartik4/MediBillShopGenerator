package com.wipro.medibill.bean;

public class RequestBean{

    private int itemRequested;
    private int qtyRequested;

    public RequestBean(){}

    public RequestBean(int itemRequested, int qtyRequested){
        this.itemRequested = itemRequested;
        this.qtyRequested = qtyRequested;
    }

    public int getItemRequested() {
        return itemRequested;
    }

    public void setItemRequested(int itemRequested) {
        this.itemRequested = itemRequested;
    }

    public int getQtyRequested() {
        return qtyRequested;
    }

    public void setQtyRequested(int qtyRequested) {
        this.qtyRequested = qtyRequested;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "itemRequested=" + itemRequested +
                ", qtyRequested=" + qtyRequested +
                '}';
    }
}