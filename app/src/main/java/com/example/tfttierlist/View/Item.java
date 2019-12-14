package com.example.tfttierlist.View;

public class Item {
    private String Name;
    private Item Item1;
    private Item Item2;
    private String Description;
    private String Tier;

    public Item(String name, Item item1, Item item2, String description, String tier) {
        Name = name;
        Description = description;
        Item1 = item1;
        Item2 = item2;
        Tier = tier;
    }

    public String getName() { return Name; }

    public void setName(String name) {
        Name = name;
    }

    public Item getItem1() {
        return Item1;
    }

    public void setItem1(Item item1) {
        Item1 = item1;
    }

    public Item getItem2() {
        return Item2;
    }

    public void setItem2(Item item2) {
        Item2 = item2;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTier() {
        return Tier;
    }

    public void setTier(String tier) {
        Tier = tier;
    }
}
