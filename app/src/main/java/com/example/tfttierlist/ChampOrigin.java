package com.example.tfttierlist;

public class ChampOrigin {
    private String Name;
    private String Description;
    private String DescriptionFirstLevel;
    private String DescriptionSecondLevel;
    private String DescriptionThirdLevel;
    private int NumberOfChampsForFirstLevel;
    private int NumberOfChampsForSecondLevel;
    private int NumberOfChampsForThirdLevel;
    private String[] Champions;

    public ChampOrigin(String name, String description, String descriptionFirstLevel, String descriptionSecondLevel,
                       String descriptionThirdLevel, int numberOfChampsForFirstLevel, int numberOfChampsForSecondLevel,
                       int numberOfChampsForThirdLevel, String[] champions) {
        Name = name;
        Description = description;
        DescriptionFirstLevel = descriptionFirstLevel;
        DescriptionSecondLevel = descriptionSecondLevel;
        DescriptionThirdLevel = descriptionThirdLevel;
        NumberOfChampsForFirstLevel = numberOfChampsForFirstLevel;
        NumberOfChampsForSecondLevel = numberOfChampsForSecondLevel;
        NumberOfChampsForThirdLevel = numberOfChampsForThirdLevel;
        Champions = champions;
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

    public String getDescriptionFirstLevel() {
        return DescriptionFirstLevel;
    }

    public void setDescriptionFirstLevel(String descriptionFirstLevel) {
        DescriptionFirstLevel = descriptionFirstLevel;
    }

    public String getDescriptionSecondLevel() {
        return DescriptionSecondLevel;
    }

    public void setDescriptionSecondLevel(String descriptionSecondLevel) {
        DescriptionSecondLevel = descriptionSecondLevel;
    }

    public String getDescriptionThirdLevel() {
        return DescriptionThirdLevel;
    }

    public void setDescriptionThirdLevel(String descriptionThirdLevel) {
        DescriptionThirdLevel = descriptionThirdLevel;
    }

    public int getNumberOfChampsForFirstLevel() {
        return NumberOfChampsForFirstLevel;
    }

    public void setNumberOfChampsForFirstLevel(int numberOfChampsForFirstLevel) {
        NumberOfChampsForFirstLevel = numberOfChampsForFirstLevel;
    }

    public int getNumberOfChampsForSecondLevel() {
        return NumberOfChampsForSecondLevel;
    }

    public void setNumberOfChampsForSecondLevel(int numberOfChampsForSecondLevel) {
        NumberOfChampsForSecondLevel = numberOfChampsForSecondLevel;
    }

    public int getNumberOfChampsForThirdLevel() {
        return NumberOfChampsForThirdLevel;
    }

    public void setNumberOfChampsForThirdLevel(int numberOfChampsForThirdLevel) {
        NumberOfChampsForThirdLevel = numberOfChampsForThirdLevel;
    }

    public String[] getChampions() {
        return Champions;
    }

    public void setChampions(String[] champions) {
        Champions = champions;
    }
}
