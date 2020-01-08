package com.example.tfttierlist.Core;

import android.content.ContentValues;

import java.io.Serializable;

public class Origin implements Serializable {
    private static final String ORINAME = "name";
    private static final String ORIDESCRIPTION = "description";

    private String Name;
    private String Description;

    public Origin() {
    }

    public Origin(String name, String description) {
        Name = name;
        Description = description;
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
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(ORINAME,Name);
        values.put(ORIDESCRIPTION,Description);
        return values;
    }
}
