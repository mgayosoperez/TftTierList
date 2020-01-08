package com.example.tfttierlist.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Origin;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Champ_Info_Activity extends AppCompatActivity {
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
    private Sqlito BaseDatos;
    private List<Origin> OriginList;
    private Origin theOrigin1;
    private Origin theOrigin2;
    private Origin theOrigin3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champ_info_layout);

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        OriginList = BaseDatos.recuperaOrigenes();


        //Inicializar las variables
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



        Bundle datos = this.getIntent().getExtras();
        Champion ChampionToShow = (Champion) datos.getSerializable("Champ");
        mostrarDatosCampeon(ChampionToShow);

        theOrigin1 = searchOrigin(ChampOrigin1);
        theOrigin2 = searchOrigin(ChampOrigin2);
        theOrigin3 = searchOrigin(ChampOrigin3);

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
        return new Origin();
    }

    public void mostrarDatosCampeon(Champion champ){
        ChampOrigin1 = champ.getOrigin();
        ChampOrigin2 = champ.getChampClass();
        ChampOrigin3 = champ.getOriginClass();

        imagenCampeon(champ.getName());
        etTier.setText(champ.getTier());
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
                break;
            case "Khazix":
                image.setImageResource(R.drawable.khazix);
                break;
            case "Renekton":
                image.setImageResource(R.drawable.renekton);
                break;
            case "Ornn":
                image.setImageResource(R.drawable.ornn);
                break;
        }
        return true;
    }

}
