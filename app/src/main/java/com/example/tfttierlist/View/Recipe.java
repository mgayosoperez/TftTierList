package com.example.tfttierlist.View;

public class Recipe {
    private Item finalItem;
    private Item item1;
    private Item item2;

    public Recipe(Item finalItem, Item item1, Item item2) {
        this.finalItem = finalItem;
        this.item1 = item1;
        this.item2 = item2;
    }
    //Nombre del item que da como resultado
    public Item getFinalItem() { return finalItem; }

    public void setFinalItem(Item finalItem) { this.finalItem = finalItem; }

    public Item getItem1() { return item1; }

    public void setItem1(Item item1) { this.item1 = item1; }

    public Item getItem2() { return item2; }

    public void setItem2(Item item2) { this.item2 = item2; }
}
