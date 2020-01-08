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
        String BNombreCampeon = datos.getString("Name2");
        mostrarDatosCampeon(NombreCampeon,BNombreCampeon);
        Log.d("myTag",BNombreCampeon);
        Log.d("myTag",NombreCampeon);

    }

    public void mostrarDatosCampeon(String Name,String Bname){
        Champion aux = new Champion();
        Champion baux = new Champion();

        for(Champion champ : ChampList){
            if (champ.getName().equals(Bname)){
                aux=champ;
                BimagenCampeon(Name);
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
                imagenCampeon(Bname);
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
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liArmor);
            li.setBackgroundColor(Color.RED);
        }


        if(Integer.parseInt(baux.getCost())<=Integer.parseInt(aux.getCost())){
            li = findViewById(R.id.liCost);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liCost);
            li.setBackgroundColor(Color.RED);
        }


        if(Integer.parseInt(baux.getMana())>=Integer.parseInt(aux.getMana())){
            li = findViewById(R.id.liMana);
            li.setBackgroundColor(Color.CYAN);
        }else {
            li = findViewById(R.id.liMana);
            li.setBackgroundColor(Color.RED);
        }


        if(Integer.parseInt(baux.getMR())<=Integer.parseInt(aux.getMR())){
            li = findViewById(R.id.liMr);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liMr);
            li.setBackgroundColor(Color.RED);
        }


        if(stringToInt(baux.getDPS())<=stringToInt(aux.getDPS())){
            li = findViewById(R.id.liDPS);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liDPS);
            li.setBackgroundColor(Color.RED);
        }


        if(Integer.parseInt(baux.getRange())<=Integer.parseInt(aux.getRange())){
            li = findViewById(R.id.liRange);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liRange);
            li.setBackgroundColor(Color.RED);
        }

        if(Float.parseFloat(baux.getAtkSpd())<=Float.parseFloat(aux.getAtkSpd())){
            li = findViewById(R.id.liAtkSpd);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liAtkSpd);
            li.setBackgroundColor(Color.RED);
        }

        if(stringToInt(baux.getHealth())<=stringToInt(aux.getHealth())){
            li = findViewById(R.id.liHea);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liHea);
            li.setBackgroundColor(Color.RED);
        }

        if(stringToInt(baux.getDamage())<=stringToInt(aux.getDamage())){
            li = findViewById(R.id.liDamage);
            li.setBackgroundColor(Color.CYAN);
        }else{
            li = findViewById(R.id.liDamage);
            li.setBackgroundColor(Color.RED);
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
                break;
            case "Annie":
                image.setImageResource(R.drawable.annie);
                break;
            case "Brand":
                image.setImageResource(R.drawable.brand);
                break;
            case "Janna":
                image.setImageResource(R.drawable.janna);
                break;
            case "Kindred":
                image.setImageResource(R.drawable.kindred);
                break;
            case "Malphite":
                image.setImageResource(R.drawable.malphite);
                break;
            case "Qiyana":
                image.setImageResource(R.drawable.qiyana);
                break;
            case "Taric":
                image.setImageResource(R.drawable.taric);
                break;
            case "Skarner":
                image.setImageResource(R.drawable.skarner);
                break;
            case "Volibear":
                image.setImageResource(R.drawable.volibear);
                break;
            case "Yorick":
                image.setImageResource(R.drawable.yorick);
                break;
            case "Senna":
                image.setImageResource(R.drawable.senna);
                break;
            case "Lucian":
                image.setImageResource(R.drawable.lucian);
                break;
            case "Dr Mundo":
                image.setImageResource(R.drawable.drmundo);
                break;
            case "Ezreal":
                image.setImageResource(R.drawable.ezreal);
                break;
            case "KogMaw":
                image.setImageResource(R.drawable.kogmaw);
                break;
            case "LeBlanc":
                image.setImageResource(R.drawable.leblanc);
                break;
            case "Malzahar":
                image.setImageResource(R.drawable.malzahar);
                break;
            case "RekSai":
                image.setImageResource(R.drawable.reksai);
                break;
            case "Soraka":
                image.setImageResource(R.drawable.soraka);
                break;
            case "Syndra":
                image.setImageResource(R.drawable.syndra);
                break;
            case "Thresh":
                image.setImageResource(R.drawable.thresh);
                break;
            case "Twitch":
                image.setImageResource(R.drawable.twitch);
                break;
            case "Zyra":
                image.setImageResource(R.drawable.zyra);
                break;
            case "Amumu":
                image.setImageResource(R.drawable.amumu);
                break;
            case "Aatrox":
                image.setImageResource(R.drawable.aatrox);
                break;
            case "Azir":
                image.setImageResource(R.drawable.azir);
                break;
            case "Diana":
                image.setImageResource(R.drawable.diana);
                break;
            case "Ivern":
                image.setImageResource(R.drawable.ivern);
                break;
            case "Sion":
                image.setImageResource(R.drawable.sion);
                break;
            case "Varus":
                image.setImageResource(R.drawable.varus);
                break;
            case "Braum":
                image.setImageResource(R.drawable.braum);
                break;
            case "Jax":
                image.setImageResource(R.drawable.jax);
                break;
            case "Nasus":
                image.setImageResource(R.drawable.nasus);
                break;
            case "Neeko":
                image.setImageResource(R.drawable.neeko);
                break;
            case "Vayne":
                image.setImageResource(R.drawable.vayne);
                break;
            case "Warwick":
                image.setImageResource(R.drawable.warwick);
                break;
            case "Taliyah":
                image.setImageResource(R.drawable.taliyah);
                break;
            case "Veigar":
                image.setImageResource(R.drawable.veigar);
        }
        return true;
    }

    public boolean BimagenCampeon (String Name) {
        switch(Name) {
            case "Singed":
                int id = R.drawable.singed;
                Bimage.setImageResource(id);
                break;
            case "Olaf":
                Bimage.setImageResource(R.drawable.olaf);
                break;
            case "Nocturne":
                Bimage.setImageResource(R.drawable.nocturne);
                break;
            case "Nami":
                Bimage.setImageResource(R.drawable.nami);
                break;
            case "Lux":
                Bimage.setImageResource(R.drawable.lux);
                break;
            case "Vladimir":
                Bimage.setImageResource(R.drawable.vladimir);
                break;
            case "Yasuo":
                Bimage.setImageResource(R.drawable.yasuo);
                break;
            case "Sivir":
                Bimage.setImageResource(R.drawable.sivir);
                break;
            case "Nautilus":
                Bimage.setImageResource(R.drawable.nautilus);
                break;
            case "Maokai":
                Bimage.setImageResource(R.drawable.maokai);
                break;
            case "Ashe":
                Bimage.setImageResource(R.drawable.ashe);
                break;
            case "Master Yi":
                Bimage.setImageResource(R.drawable.masteryi);
                break;
            case "Zed":
                Bimage.setImageResource(R.drawable.zed);
                break;
            case "Annie":
                Bimage.setImageResource(R.drawable.annie);
                break;
            case "Brand":
                Bimage.setImageResource(R.drawable.brand);
                break;
            case "Janna":
                Bimage.setImageResource(R.drawable.janna);
                break;
            case "Kindred":
                Bimage.setImageResource(R.drawable.kindred);
                break;
            case "Malphite":
                Bimage.setImageResource(R.drawable.malphite);
                break;
            case "Qiyana":
                Bimage.setImageResource(R.drawable.qiyana);
                break;
            case "Taric":
                Bimage.setImageResource(R.drawable.taric);
                break;
            case "Skarner":
                Bimage.setImageResource(R.drawable.skarner);
                break;
            case "Volibear":
                Bimage.setImageResource(R.drawable.volibear);
                break;
            case "Yorick":
                Bimage.setImageResource(R.drawable.yorick);
                break;
            case "Senna":
                Bimage.setImageResource(R.drawable.senna);
                break;
            case "Lucian":
                Bimage.setImageResource(R.drawable.lucian);
                break;
            case "Dr Mundo":
                Bimage.setImageResource(R.drawable.drmundo);
                break;
            case "Ezreal":
                Bimage.setImageResource(R.drawable.ezreal);
                break;
            case "KogMaw":
                Bimage.setImageResource(R.drawable.kogmaw);
                break;
            case "LeBlanc":
                Bimage.setImageResource(R.drawable.leblanc);
                break;
            case "Malzahar":
                Bimage.setImageResource(R.drawable.malzahar);
                break;
            case "RekSai":
                Bimage.setImageResource(R.drawable.reksai);
                break;
            case "Soraka":
                Bimage.setImageResource(R.drawable.soraka);
                break;
            case "Syndra":
                Bimage.setImageResource(R.drawable.syndra);
                break;
            case "Thresh":
                Bimage.setImageResource(R.drawable.thresh);
                break;
            case "Twitch":
                Bimage.setImageResource(R.drawable.twitch);
                break;
            case "Zyra":
                Bimage.setImageResource(R.drawable.zyra);
                break;
            case "Amumu":
                Bimage.setImageResource(R.drawable.amumu);
                break;
            case "Aatrox":
                Bimage.setImageResource(R.drawable.aatrox);
                break;
            case "Azir":
                Bimage.setImageResource(R.drawable.azir);
                break;
            case "Diana":
                Bimage.setImageResource(R.drawable.diana);
                break;
            case "Ivern":
                Bimage.setImageResource(R.drawable.ivern);
                break;
            case "Sion":
                Bimage.setImageResource(R.drawable.sion);
                break;
            case "Varus":
                Bimage.setImageResource(R.drawable.varus);
                break;
            case "Braum":
                Bimage.setImageResource(R.drawable.braum);
                break;
            case "Jax":
                Bimage.setImageResource(R.drawable.jax);
                break;
            case "Nasus":
                Bimage.setImageResource(R.drawable.nasus);
                break;
            case "Neeko":
                Bimage.setImageResource(R.drawable.neeko);
                break;
            case "Vayne":
                Bimage.setImageResource(R.drawable.vayne);
                break;
            case "Warwick":
                Bimage.setImageResource(R.drawable.warwick);
                break;
            case "Taliyah":
                Bimage.setImageResource(R.drawable.taliyah);
                break;
            case "Veigar":
                Bimage.setImageResource(R.drawable.veigar);
        }
        return true;
    }

}
