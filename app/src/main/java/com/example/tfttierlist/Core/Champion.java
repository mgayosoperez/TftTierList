package com.example.tfttierlist.Core;

public class Champion {

    private String Name;
    private String Origin;
    private String ChampClass;
    private String OriginClass;
    private String Description;
    private char Tier;
    private int Cost;
    private String Health;
    private int Mana;
    private int InicialMana;
    private int Armor;
    private int MR;
    private String DPS;
    private String Damage;
    private double AtkSpd;
    private String CritRate;
    private int Range;

    public Champion() {
    }

    public Champion(String Name, String Origin, String ChampClass, String OriginClass,
                    String Description, char Tier, int Cost, String Health, int Mana, int InicialMana, int Armor, int MR, String DPS,
                    String Damage, double AtkSpd, String CritRate, int Range) {

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
        this.MR = MR;
        this.DPS = DPS;
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

    public char getTier() {
        return Tier;
    }

    public void setTier(char tier) {
        Tier = tier;
    }

    public int getInicialMana() {
        return InicialMana;
    }

    public void setInicialMana(int inicialMana) {
        InicialMana = inicialMana;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

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
