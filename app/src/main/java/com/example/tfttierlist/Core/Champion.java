package com.example.tfttierlist.Core;


import android.content.ContentValues;

import java.io.Serializable;

public class Champion implements Serializable {
    private static final String CHAMP_TABLE = "champ";
    private static final String NAME = "name";
    private static final String ORIGIN = "origin";
    private static final String CHAMPCLASS = "champclass";
    private static final String ORIGINCLASS = "originclass";
    private static final String DESCRIPTION = "description";
    private static final String TIER = "tier";
    private static final String COST = "coste";
    private static final String HEALTH = "health";
    private static final String MANA = "mana";
    private static final String INITIALMANA = "initialmana";
    private static final String ARMOR = "armor";
    private static final String MR = "mr";
    private static final String DPS = "dps";
    private static final String DAMAGE = "damage";
    private static final String ATKSPD = "atkspd";
    private static final String CRITRATE = "critrate";
    private static final String RANGE = "range";

    private String Name;
    private String Origin;
    private String ChampClass;
    private String OriginClass;
    private String Description;
    private String Tier;
    private String Cost;
    private String Health;
    private String Mana;
    private String InicialMana;
    private String Armor;
    private String Mr;
    private String Dps;
    private String Damage;
    private String AtkSpd;
    private String CritRate;
    private String Range;

    public Champion() {
    }

    public Champion(String Name, String Origin, String ChampClass, String OriginClass,
                    String Description, String Tier, String Cost, String Health, String Mana, String InicialMana, String Armor, String MR, String DPS,
                    String Damage, String AtkSpd, String CritRate, String Range) {

        this.Name = Name;
        this.Origin = Origin;
        this.ChampClass = ChampClass;
        this.OriginClass = OriginClass;
        this.Description = Description;
        this.Tier = Tier;
        this.Cost = Cost;
        this.Health = Health;
        this.Mana = Mana;
        this.InicialMana = Mana;
        this.Armor = Armor;
        this.Mr = MR;
        this.Dps = DPS;
        this.Damage = Damage;
        this.AtkSpd = AtkSpd;
        this.CritRate = CritRate;
        this.Range = Range;

    }

    public String getChampClass() {
        return ChampClass;
    }

    public String getOriginClass() {
        return OriginClass;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }


    public void setChampClass(String champClass) {
        ChampClass = champClass;
    }


    public void setOriginClass(String originClass) {
        OriginClass = originClass;
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

    public String getInicialMana() {
        return InicialMana;
    }

    public void setInicialMana(String inicialMana) {
        InicialMana = inicialMana;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public String getMana() {
        return Mana;
    }

    public void setMana(String mana) {
        Mana = mana;
    }

    public String getArmor() {
        return Armor;
    }

    public void setArmor(String armor) {
        Armor = armor;
    }

    public String getMR() { return Mr; }

    public void setMR(String MR) { this.Mr = MR; }

    public String getDPS() {
        return Dps;
    }

    public void setDPS(String DPS) {
        this.Dps = DPS;
    }

    public String getDamage() {
        return Damage;
    }

    public void setDamage(String damage) {
        Damage = damage;
    }

    public String getAtkSpd() {
        return AtkSpd;
    }

    public void setAtkSpd(String atkSpd) {
        AtkSpd = atkSpd;
    }

    public String getCritRate() {
        return CritRate;
    }

    public void setCritRate(String critRate) {
        CritRate = critRate;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(NAME,Name);
        values.put(ORIGIN,Origin);
        values.put(CHAMPCLASS,ChampClass);
        values.put(ORIGINCLASS,OriginClass);
        values.put(DESCRIPTION,Description);
        values.put(TIER,Tier);
        values.put(COST,Cost);
        values.put(HEALTH,Health);
        values.put(MANA,Mana);
        values.put(INITIALMANA,InicialMana);
        values.put(ARMOR,Armor);
        values.put(MR,Mr);
        values.put(DPS,Dps);
        values.put(DAMAGE,Damage);
        values.put(ATKSPD,AtkSpd);
        values.put(CRITRATE,CritRate);
        values.put(RANGE,Range);

        return values;
    }

}
