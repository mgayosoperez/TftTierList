package com.example.tfttierlist.View;

import android.os.Bundle;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Champ_Info_Activity extends AppCompatActivity {
    List<Champion> ChampList = new ArrayList<>();

    private Sqlito BaseDatos;

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
        this.BaseDatos = new Sqlito( this.getApplicationContext() );
        Log.d("STATE","nepe1");
        ChampList = BaseDatos.recuperaTodoAlfabetico();


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
        Bundle datos = this.getIntent().getExtras();
        String NombreCampeon = datos.getString("Name");


        for(Champion champ : ChampList){

            if (champ.getName().equals(NombreCampeon)){

                imagenCampeon(NombreCampeon);
                etDescription.setText(champ.getDescription());

                etChampName.setText(champ.getName());
                etOrigin.setText(champ.getOrigin());
                etClass.setText(champ.getChampClass());
                etCost.setText(champ.getCost());
                etHealth.setText(champ.getHealth());
                etMana.setText(champ.getMana());
                etArmor.setText(champ.getArmor());
                etMR.setText(champ.getMR());
                etDPS.setText(champ.getMR());
                etDamage.setText(champ.getDamage());
                etAtkSpd.setText(champ.getAtkSpd());
                etCritRate.setText(champ.getCritRate());
                etRange.setText(champ.getRange());

            }
        }

    }

    public void mostrarDatosCampeon(String Name){
        Champion aux = new Champion();

        for(Champion champ : ChampList){
            if (champ.getName().equals(Name)){
                imagenCampeon(Name);
                etDescription.setText(champ.getDescription());
                etChampName.setText(champ.getName());
                etOrigin.setText(champ.getOrigin());
                etClass.setText(champ.getChampClass());
                etCost.setText(champ.getCost());
                etHealth.setText(champ.getHealth());
                etMana.setText(champ.getMana());
                etArmor.setText(champ.getArmor());
                etMR.setText(champ.getMR());
                etDPS.setText(champ.getMR());
                etDamage.setText(champ.getDamage());
                etAtkSpd.setText(champ.getAtkSpd());
                etCritRate.setText(champ.getCritRate());
                etRange.setText(champ.getRange());
            }
        }
    }

    public boolean imagenCampeon (String Name) {
        switch(Name) {
            case "Singed":
                int id = R.drawable.singed;
                image.setImageResource(id);
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
            case "Zed":
                image.setImageResource(R.drawable.zed);

        }
        return true;
    }

}
