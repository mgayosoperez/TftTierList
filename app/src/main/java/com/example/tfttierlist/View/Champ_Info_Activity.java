package com.example.tfttierlist.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Origin;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;


import android.widget.Button;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Champ_Info_Activity extends AppCompatActivity {

    Button btn;
    private List<Champion> ChampList = new ArrayList<>();
    private Sqlito BaseDatos;


    TextView etChampName;
    TextView etTier;
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

    private String ChampOrigin1;
    private String ChampOrigin2;
    private String ChampOrigin3;
    private String OrClass;

    ImageView image;
    ImageView originClassImage1;
    ImageView originClassImage2;
    ImageView originClassImage3;

    private List<Origin> OriginList = new ArrayList<>();
    private Origin theOrigin1;
    private Origin theOrigin2;
    private Origin theOrigin3;

    private ImageView OriClassImg1;
    private ImageView OriClassImg2;
    private ImageView OriClassImg3;


    private ImageButton Star;
    private boolean isEnable = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champ_info_layout);

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        OriginList = BaseDatos.recuperaOrigenes();


        //Inicializar las variables
        btn = findViewById(R.id.btnComparar);
        etChampName = findViewById(R.id.twChampName);
        etTier = findViewById(R.id.tvChampTier);
        etDescription = findViewById(R.id.etDescription);
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
        image = findViewById(R.id.imageViewItem);
        originClassImage1 = findViewById(R.id.oriClassImg1);
        originClassImage2 = findViewById(R.id.oriClassImg2);
        originClassImage3 = findViewById(R.id.oriClassImg3);
        OriClassImg1 = findViewById(R.id.oriClassImg1);
        OriClassImg2 = findViewById(R.id.oriClassImg2);
        OriClassImg3 = findViewById(R.id.oriClassImg3);


        Bundle datos = this.getIntent().getExtras();
        final Champion ChampionToShow = (Champion) datos.getSerializable("Champ");
        mostrarDatosCampeon(ChampionToShow);

        theOrigin1 = searchOrigin(ChampOrigin1);
        theOrigin2 = searchOrigin(ChampOrigin2);
        theOrigin3 = searchOrigin(ChampOrigin3);

        String imagename1 = theOrigin1.getName().toLowerCase();
        OriClassImg1.setImageResource(getResources().getIdentifier(imagename1,"drawable", this.getPackageName()));
        String imagename2 = theOrigin2.getName().toLowerCase();
        if(theOrigin3.getName().equals("default")){
            OriClassImg2.setImageResource(getResources().getIdentifier("lanada3232","drawable", this.getPackageName()));
            OriClassImg3.setImageResource(getResources().getIdentifier(imagename2,"drawable", this.getPackageName()));
        }else{
            OriClassImg2.setImageResource(getResources().getIdentifier(imagename2,"drawable", this.getPackageName()));
            String imagename3 = theOrigin3.getName().toLowerCase();
            OriClassImg3.setImageResource(getResources().getIdentifier(imagename3,"drawable", this.getPackageName()));
        }




        Star = findViewById(R.id.favorite_button);
        if(ChampionToShow.isFavorite().equals("1")){
            Star.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
        }
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEnable){
                    Star.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
                    BaseDatos.updateFavorite(ChampionToShow.getName(),"0");
                }else{
                    Star.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
                    BaseDatos.updateFavorite(ChampionToShow.getName(),"1");
                }isEnable = !isEnable;
            }
        });

        Bundle datos2 = this.getIntent().getExtras();
        final String NombreCampeon = datos.getString("Name");
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                compararCampeon(ChampionToShow);
            }
        });
        mostrarDatosCampeon(NombreCampeon);


        originClassImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOriginClass(theOrigin1);

            }
        });
        originClassImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOriginClass(theOrigin2);
            }
        });
        originClassImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOriginClass(theOrigin3);
            }
        });
    }
    public void compararCampeon(Champion champ) {
        Intent intent = new Intent(this, Comp_List_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Champ", champ);
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 11);
    }


    public void showOriginClass (Origin champOrigin){
        Intent intent = new Intent(this, OriginClass_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Origin", champOrigin);
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 11);
    }

    public Origin searchOrigin (String Name){
        for(Origin aux : OriginList){
            if(aux.getName().equals(Name)){
                return aux;
            }
        }
        return new Origin("default","");
    }

    public void mostrarDatosCampeon(Champion champ){
        ChampOrigin1 = champ.getOrigin();
        ChampOrigin2 = champ.getChampClass();
        ChampOrigin3 = champ.getOriginClass();

        String imagename = champ.getName().toLowerCase().replace(" ","");
        image.setImageResource(getResources().getIdentifier(imagename,"drawable", this.getPackageName()));
        if (champ.getTier().equals("1")){
            etTier.setText("S");
        }else{
            etTier.setText(champ.getTier());
        }
        etDescription.setText(champ.getDescription());
        etChampName.setText(champ.getName());
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

    public void mostrarDatosCampeon(String Name){
        for(Champion champ : ChampList){
            if (champ.getName().equals(Name)){
                String imagename = champ.getName().toLowerCase().replace(" ","");
                image.setImageResource(getResources().getIdentifier(imagename,"drawable", this.getPackageName()));
                etDescription.setText(champ.getDescription());
                etChampName.setText(champ.getName());

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
                if (champ.getTier().equals("1")){
                    etTier.setText("S");
                }else{
                    etTier.setText(champ.getTier());
                }
            }
        }
    }




}
