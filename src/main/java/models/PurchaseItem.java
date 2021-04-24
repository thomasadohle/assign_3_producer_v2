package models;

public class PurchaseItem {
    private int itemID;
    private int numberOfItems;

    public void setItemID(int itemID){
        this.itemID = itemID;
    }

    public void setNumberOfItems(int numberOfItems){
        this.numberOfItems = numberOfItems;
    }

    public int getItemID(){return this.itemID;}
    public int getNumberOfItems(){return this.numberOfItems;}
}
