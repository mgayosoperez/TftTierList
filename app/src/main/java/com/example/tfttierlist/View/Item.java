package com.example.tfttierlist.View;

public class Item {
    private String Name;
    private String Description;
    private String Recipe;
    private String Tier;

    public Item(String name, String description, String recipe, String tier) {
        Name = name;
        Description = description;
        Recipe = recipe;
        Tier = tier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public String getTier() {
        return Tier;
    }

    public void setTier(String tier) {
        Tier = tier;
    }
}
