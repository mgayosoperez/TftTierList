package com.example.tfttierlist.View;

import android.media.Image;
import android.os.Bundle;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Champ_Info_Activity extends AppCompatActivity {
    Champion a = new Champion("Singed", "Poison", "Alchemist", "-", "Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.", 'S', '5', "950 / 1710 / 3420", '0', '0', 50, 20 ,"0/0/0" ,"0/0/0" ,'0' ,"0,25" ,'0');
    Champion b = new Champion("Olaf", "Glacial", "Berserker", "-", "Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.", 'S', 4, "750 / 1350 / 2700", 90, 0, 35, 20 ,"60 / 107 / 214" ,"70 / 126 / 252" ,0.85 ,"25%" ,1);
    Champion c = new Champion("Nocturne", "Steel", "Assassin", "-", "Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%", 'S',3, "650 / 1170 / 2340", 0, 0, 25, 20, "45 / 81 / 162", "60 / 108 / 216" ,0.75 ,"25%" ,1 );
    Champion d = new Champion("Nami", "Ocean", "Mystic", "-", "Nami sends a massive wave toward a random enemy, damaging and knocking up enemies it passes through and granting allies it passes through bonus magic damage on hit. Damage: 150 / 250 / 350 Stun Duration: 1.5 / 2 / 2.5 Bonus Damage: 25 / 50 / 300", 'S', 5, "750 / 1350 / 2700", 125, 50, 25 ,20 ,"38 / 68 / 135" ,"50 / 90 / 180" ,0.75 ,"25%", 4);
    Champion e = new Champion("Lux", "x", "Avatar", "-", "Final Spark. Lux fires a straight beam of light at enemies. If at least one enemy is killed, she restores 50 mana. Damage: 600 / 900 / 9999", 'S', 7, "850 / 1530 / 3060", 80, 0, 25 ,20 ,"55 / 99 / 199" ,"65 / 117 / 234" ,0.85 ,"25%", 4);
    Champion f = new Champion("Vladimir", "Ocean", "Mage", "-", "Drain. Vladimir damages a target enemy, healing himself for the damage dealt. Damage: 200 / 325 / 450", 'C', 1, "550 / 990 / 1980", 75, 0, 35 ,20 ,"26 / 47 / 94" ,"40 / 72 / 144" ,0.65 ,"25%", 2);
    Champion g = new Champion("Amumu", "Inferno", "Warden", "-", "Curse of the Sad Mummy. Amumus rage explodes, dealing magic damage to enemies in an area around him, and stunning them for 1.5 seconds. Damage: 250 / 500 / 1337. Range: 2 / 3 / 4", 'B', 5, "900 / 1620 / 3240", 150, 50, 150 ,20 ,"41 / 74 / 149" ,"55 / 99 / 198" ,0.75 ,"25%", 1);
    Champion h = new Champion("Yasuo", "Cloud", "Blademaster", "-", "Last Breath. Yasuo blinks to the enemy with the most items and knocks them up, holding them airborn for 1 second and hitting them, dealing basic attack damage and applying on-hit effects. Hits: 4 / 5 / 6", 'B', 2, "600 / 1080 / 2160", 100, 0, 30 ,20 ,"42 / 76 / 151" ,"60 / 108 / 216" ,0.7 ,"25%", 1);
    Champion i = new Champion("Sivir", "Desert", "Blademaster", "-", "Ricochet. For the next 5 seconds, Sivirs attacks will bounce up to 10 times to nearby enemies, dealing damage and applying on-hit effects. Damage: 100% / 125% / 150%", 'B', 3, "600 / 1080 / 2160", 65, 0, 25 ,20 ,"39 / 69 / 139" ,"55 / 99 / 198" ,0.7 ,"25%", 3);
    Champion j = new Champion("Nautilus", "Ocean", "Warden", "-", "Depth Charge. Nautilus sends out a depth charge that seeks out the furthest enemy champion, knocking them up and stunning them. It also deals damage to all enemies it passes. Damage: 100 / 200 / 400. Stun Duration: 3 / 4 / 6", 'B', 3, "850 / 1530 / 3060", 125, 50, 40 ,20 ,"33 / 59 / 119" ,"55 / 99 / 198" ,0.6 ,"25%", 1);
    Champion k = new Champion("Maokai", "Woodland", "Druid", "-", "Sap Magic. After taking damage from a spell, Maokais next attack will heal him. Heal Amount: 100 / 150 / 200", 'B', 1, "650 / 1170 / 2340", 0, 0, 35 ,20 ,"28 / 50 / 99" ,"55 / 99 / 198" ,0.5 ,"25%", 1);
    Champion m = new Champion("Ashe", "Crystal", "Ranger", "-", "Rangers Focus. For 5 seconds, Ashe gains 50% Attack Speed, and her basic attacks fire a flurry of arrows dealing physical damage. Attack Speed Bonus: 50% / 75% / 250%. Damage Per Arrow: 25% / 30% / 35%", 'B', 4, "550 / 990 / 1980", 35, 0, 20 ,20 ,"48 / 86 / 173" ,"60 / 108 / 216" ,0.8 ,"25%", 4);
    Champion n = new Champion("Master Yi", "Shadow", "Blademaster", "Mystic", "Meditate. Master Yi meditates, becoming untargetable for 1 second and healing over the duration. After Master Yi finishes meditating, he gains 100% Attack Speed and deal bonus magic damage on hit for 6 seconds. Bonus Damage: 50 / 75 / 500", 'A', 5, "850 / 1530 / 3060", 150, 100, 30 ,20 ,"70 / 126 / 252" ,"70 / 126 / 252" ,1 ,"25%", 1);

    List<Champion> ChampList = new ArrayList<>();

    TextView etChampName;
    TextView etOrigin;
    TextView etClass;
    TextView etDescription;
    TextView etCost;
    TextView etHealth;
    TextView etMana;
    TextView etArmor;
    TextView etMR;
    TextView etDPS;
    TextView etDamage;
    TextView etAtkSpd;
    TextView etCritRate;
    TextView etRange;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champ__info_);

        //Inicializar lista de campeones
        ChampList.add(a);
        ChampList.add(b);
        ChampList.add(c);
        ChampList.add(d);
        ChampList.add(e);
        ChampList.add(f);
        ChampList.add(g);
        ChampList.add(h);
        ChampList.add(i);
        ChampList.add(j);
        ChampList.add(k);
        ChampList.add(m);
        ChampList.add(n);


        //Inicializar las variables
        etChampName = findViewById(R.id.twChampName);
        etDescription = findViewById(R.id.etDescription);
        etOrigin = findViewById(R.id.etOrigin);
        etClass = findViewById(R.id.etClass);
        etCost = findViewById(R.id.etCost);
        etHealth = findViewById(R.id.etHealth);
        etMana = findViewById(R.id.etMana);
        etArmor = findViewById(R.id.etArmor);
        etMR = findViewById(R.id.etMR);
        etDPS = findViewById(R.id.etDPS);
        etDamage = findViewById(R.id.etDamage);
        etAtkSpd = findViewById(R.id.etAtkSpd);
        etCritRate = findViewById(R.id.etCritRate);
        etRange = findViewById(R.id.etRange);
        image = findViewById(R.id.imageView);

        Champion aux = new Champion();

        for(Champion champ : ChampList){
            if (champ.getName() == "Ashe"){
                aux = champ;
            }
        }

        imagenCampeon("Ashe");
        etDescription.setText(aux.getDescription());
        etChampName.setText(aux.getName());
        etOrigin.setText(aux.getOrigin());
        etClass.setText(aux.getChampClass());
        etCost.setText(Integer.toString(aux.getCost()));
        etHealth.setText(aux.getHealth());
        etMana.setText(Integer.toString(aux.getMana()));
        etArmor.setText(Integer.toString(aux.getArmor()));
        etMR.setText(Integer.toString(aux.getMR()));
        etDPS.setText(Integer.toString(aux.getMR()));
        etDamage.setText(aux.getDamage());
        etAtkSpd.setText(Double.toString(aux.getAtkSpd()));
        etCritRate.setText(aux.getCritRate());
        etRange.setText(Integer.toString(aux.getRange()));
/*
        Bundle datos = this.getIntent().getExtras();
        String NombreCampeon = datos.getString("Name");
        if (NombreCampeon == null) {
            mostrarDatosCampeon("Ashe");
        }else {
            mostrarDatosCampeon(NombreCampeon);
        }*/
    }

    public void mostrarDatosCampeon(String Name){
        Champion aux = new Champion();

        for(Champion champ : ChampList){
            if (champ.getName() == Name){
                aux = champ;
            }
        }

        imagenCampeon(Name);
        etDescription.setText(aux.getDescription());
        etChampName.setText(aux.getName());
        etOrigin.setText(aux.getOrigin());
        etClass.setText(aux.getChampClass());
        etCost.setText(Integer.toString(aux.getCost()));
        etHealth.setText(aux.getHealth());
        etMana.setText(Integer.toString(aux.getMana()));
        etArmor.setText(Integer.toString(aux.getArmor()));
        etMR.setText(Integer.toString(aux.getMR()));
        etDPS.setText(Integer.toString(aux.getMR()));
        etDamage.setText(aux.getDamage());
        etAtkSpd.setText(Double.toString(aux.getAtkSpd()));
        etCritRate.setText(aux.getCritRate());
        etRange.setText(Integer.toString(aux.getRange()));
    }

    public boolean imagenCampeon (String Name) {
        if (Name == null){
            return false;
        }
        switch(Name) {
            case "Singed":
                image.setImageResource(R.drawable.singed);
                break;
            case "Olaf":
                image.setImageResource(R.drawable.olaf);
                break;
            case "Nocturne":
                image.setImageResource(R.drawable.nocturne);
                break;
            case "Nami":
                image.setImageResource(R.drawable.nami);
                break;
            case "Lux":
                image.setImageResource(R.drawable.lux);
                break;
            case "Vladimir":
                image.setImageResource(R.drawable.vladimir);
                break;
            case "Yasuo":
                image.setImageResource(R.drawable.yasuo);
                break;
            case "Sivir":
                image.setImageResource(R.drawable.sivir);
                break;
            case "Nautilus":
                image.setImageResource(R.drawable.nautilus);
                break;
            case "Maokai":
                image.setImageResource(R.drawable.maokai);
                break;
            case "Ashe":
                image.setImageResource(R.drawable.ashe);
                break;
            case "Master Yi":
                image.setImageResource(R.drawable.masteryi);
                break;
            default:
                image.setImageResource(R.drawable.ashe);
        }
        return true;
    }

}
