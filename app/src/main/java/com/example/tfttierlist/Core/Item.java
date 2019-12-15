package com.example.tfttierlist.Core;

public class Item {
    private String Name;
    private String Item1;
    private String Item2;
    private String Description;
    private String Tier;

    public Item(String name, String item1, String item2, String description, String tier) {
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

    public String getItem1() {
        return Item1;
    }

    public void setItem1(String item1) {
        Item1 = item1;
    }

    public String getItem2() {
        return Item2;
    }

    public void setItem2(String item2) {
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
