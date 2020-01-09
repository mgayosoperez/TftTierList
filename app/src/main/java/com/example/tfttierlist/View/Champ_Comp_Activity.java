package com.example.tfttierlist.View;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.List;

public class Champ_Comp_Activity extends AppCompatActivity {
    List<Champion> ChampList = new ArrayList<>();
    Button btn;

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

    TextView BetChampName;
    TextView BetOrigin;
    TextView BetClass;
    TextView BetDescription;
    TextView BetCost;
    TextView BetHealth;
    TextView BetMana;
    TextView BetArmor;
    TextView BetMR;
    TextView BetDPS;
    TextView BetDamage;
    TextView BetAtkSpd;
    TextView BetCritRate;
    TextView BetRange;

    ImageView Bimage;
    LinearLayout li;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comp_champ);
        this.BaseDatos = new Sqlito( this.getApplicationContext() );
        ChampList = BaseDatos.recuperaTodoAlfabetico();


        //Inicializar las variables
        etChampName = findViewById(R.id.twChampName1);
        etDescription = findViewById(R.id.etDescription1);
        etOrigin = findViewById(R.id.etOrigin1);
        etClass = findViewById(R.id.etClass1);
        etCost = findViewById(R.id.etCost1);
        etHealth = findViewById(R.id.etHealth1);
        etMana = findViewById(R.id.etMana1);
        etArmor = findViewById(R.id.etArmor1);
        etMR = findViewById(R.id.etMR1);
        etDPS = findViewById(R.id.etDPS1);
        etDamage = findViewById(R.id.etDamage1);
        etAtkSpd = findViewById(R.id.etAtkSpd1);
        etCritRate = findViewById(R.id.etCritRate1);
        etRange = findViewById(R.id.etRange1);
        image = findViewById(R.id.imageViewChamp1);

        BetChampName = findViewById(R.id.twChampName);
        BetDescription = findViewById(R.id.etDescription);
        BetOrigin = findViewById(R.id.etOrigin);
        BetClass = findViewById(R.id.etClass);
        BetCost = findViewById(R.id.etCost);
        BetHealth = findViewById(R.id.etHealth);
        BetMana = findViewById(R.id.etMana);
        BetArmor = findViewById(R.id.etArmor);
        BetMR = findViewById(R.id.etMR);
        BetDPS = findViewById(R.id.etDPS);
        BetDamage = findViewById(R.id.etDamage);
        BetAtkSpd = findViewById(R.id.etAtkSpd);
        BetCritRate = findViewById(R.id.etCritRate);
        BetRange = findViewById(R.id.etRange);
        Bimage = findViewById(R.id.imageViewChamp);


        Champion aux = new Champion();
        Bundle datos = this.getIntent().getExtras();
        String NombreCampeon = datos.getString("Name1");
        Champion ChampionToShow = (Champion) datos.getSerializable("Champ");

        mostrarDatosCampeon(NombreCampeon,ChampionToShow.getName());
        Log.d("myTag",ChampionToShow.getName());
        Log.d("myTag",NombreCampeon);

    }

    public void mostrarDatosCampeon(String Name,String Bname){
        Champion aux = new Champion();
        Champion baux = new Champion();

        for(Champion champ : ChampList){
            if (champ.getName().equals(Bname)){
                aux=champ;
                String imagename = champ.getName().toLowerCase().replace(" ","");
                image.setImageResource(getResources().getIdentifier(imagename,"drawable", this.getPackageName()));
                etDescription.setText(champ.getDescription());
                etChampName.setText(champ.getName());
                etOrigin.setText(champ.getOrigin());
                etClass.setText(champ.getChampClass());
                etCost.setText(champ.getCost());
                etHealth.setText(champ.getHealth());
                etMana.setText(champ.getMana());
                etArmor.setText(champ.getArmor());
                etMR.setText(champ.getMR());
                etDPS.setText(champ.getDPS());
                etDamage.setText(champ.getDamage());
                etAtkSpd.setText(champ.getAtkSpd());
                etCritRate.setText(champ.getCritRate());
                etRange.setText(champ.getRange());
            }
        }

        for(Champion champ : ChampList){
            if (champ.getName().equals(Name)){
                baux=champ;
                String imagename = champ.getName().toLowerCase().replace(" ","");
                Bimage.setImageResource(getResources().getIdentifier(imagename,"drawable", this.getPackageName()));
                BetDescription.setText(champ.getDescription());
                BetChampName.setText(champ.getName());
                BetOrigin.setText(champ.getOrigin());
                BetClass.setText(champ.getChampClass());
                BetCost.setText(champ.getCost());
                BetHealth.setText(champ.getHealth());
                BetMana.setText(champ.getMana());
                BetArmor.setText(champ.getArmor());
                BetMR.setText(champ.getMR());
                BetDPS.setText(champ.getDPS());
                BetDamage.setText(champ.getDamage());
                BetAtkSpd.setText(champ.getAtkSpd());
                BetCritRate.setText(champ.getCritRate());
                BetRange.setText(champ.getRange());
            }
        }

        if(Integer.parseInt(baux.getArmor())<=Integer.parseInt(aux.getArmor())){
            li = findViewById(R.id.liArmor);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liArmor);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }


        if(Integer.parseInt(baux.getCost())<=Integer.parseInt(aux.getCost())){
            li = findViewById(R.id.liCost);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liCost);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }


        if(Integer.parseInt(baux.getMana())>=Integer.parseInt(aux.getMana())){
            li = findViewById(R.id.liMana);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else {
            li = findViewById(R.id.liMana);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }


        if(Integer.parseInt(baux.getMR())<=Integer.parseInt(aux.getMR())){
            li = findViewById(R.id.liMr);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liMr);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }


        if(stringToInt(baux.getDPS())<=stringToInt(aux.getDPS())){
            li = findViewById(R.id.liDPS);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liDPS);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }

        if(Integer.parseInt(baux.getRange())<=Integer.parseInt(aux.getRange())){
            li = findViewById(R.id.liRange);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liRange);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }

        if(Float.parseFloat(baux.getAtkSpd())<=Float.parseFloat(aux.getAtkSpd())){
            li = findViewById(R.id.liAtkSpd);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liAtkSpd);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }

        if(stringToInt(baux.getHealth())<=stringToInt(aux.getHealth())){
            li = findViewById(R.id.liHea);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liHea);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }

        if(stringToInt(baux.getDamage())<=stringToInt(aux.getDamage())){
            li = findViewById(R.id.liDamage);
            li.setBackgroundColor(Color.argb(130,155,255,155));
        }else{
            li = findViewById(R.id.liDamage);
            li.setBackgroundColor(Color.argb(130,255,155,155));
        }
    }

    public int stringToInt(String barras){
        int toret=0;
        String[] separated = barras.split("/");
        toret=toret+Integer.parseInt(separated[0].replace(" ", ""));
        toret=toret+Integer.parseInt(separated[1].replace(" ", ""));
        toret=toret+Integer.parseInt(separated[2].replace(" ", ""));
        return toret;
    }

}
