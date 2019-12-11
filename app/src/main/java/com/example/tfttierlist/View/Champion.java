package com.example.tfttierlist.View;

public class Champion {
    private String Name;
    private String Abilities;
    private String Origin;
    private String ChampClass1;
    private String ChampClass2;
    private int Cost;
    private String Health;
    private int Mana;
    private int Armor;
    private int MR;
    private String DPS;
    private String Damage;
    private double AtkSpd;
    private String CritRate;
    private int Range;

    public Champion(String Name, String Abilities, String Origin, String ChampClass1, String ChampClass2, int Cost,
                    String Health, int Mana, int Armor, int MR, String DPS,
                    String Damage, double AtkSpd, String CritRate, int Range) {

        this.Name = Name;
        this.Abilities = Abilities;
        this.Origin = Origin;
        this.ChampClass1 = ChampClass1;
        this.ChampClass2 = ChampClass2;
        this.Cost = Cost;
        this.Health = Health;
        this.Mana = Mana;
        this.Armor = Armor;
        this.MR = MR;
        this.DPS = DPS;
        this.Damage = Damage;
        this.AtkSpd = AtkSpd;
        this.CritRate = CritRate;
        this.Range = Range;

    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAbilities() {
        return Abilities;
    }

    public void setAbilities(String abilities) {
        Abilities = abilities;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getChampClass1() {
        return ChampClass1;
    }

    public void setChampClass1(String champClass) {
        ChampClass1 = champClass;
    }

    public String getChampClass2() {  return ChampClass2; }

    public void setChampClass2(String champClass2) { ChampClass2 = champClass2;  }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public int getMana() {
        return Mana;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    public int getMR() { return MR; }

    public void setMR(int MR) { this.MR = MR; }

    public String getDPS() {
        return DPS;
    }

    public void setDPS(String DPS) {
        this.DPS = DPS;
    }

    public String getDamage() {
        return Damage;
    }

    public void setDamage(String damage) {
        Damage = damage;
    }

    public double getAtkSpd() {
        return AtkSpd;
    }

    public void setAtkSpd(double atkSpd) {
        AtkSpd = atkSpd;
    }

    public String getCritRate() {
        return CritRate;
    }

    public void setCritRate(String critRate) {
        CritRate = critRate;
    }

    public int getRange() {
        return Range;
    }

    public void setRange(int range) {
        Range = range;
    }
}
