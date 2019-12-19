package com.example.tfttierlist.View;

import android.content.Context;
import android.os.Bundle;

import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.List;

public class Item_Info_Activity extends AppCompatActivity {
    private List<Item> ItemList = new ArrayList<>();
    private Sqlito BaseDatos;

    private TextView tvDescription;
    private ImageView imgObjetoPpal;
    private ImageView imgObjetoReceta1;
    private ImageView imgObjetoReceta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_info_layout);

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        ItemList = BaseDatos.recuperaItems();

        //Inicializar variables
        tvDescription = findViewById(R.id.tvItemDescription);
        imgObjetoPpal = findViewById(R.id.imageViewItem);
        imgObjetoReceta1 = findViewById(R.id.imageViewItemRecipe1);
        imgObjetoReceta2 = findViewById(R.id.imageViewItemRecipe2);
        imgObjetoReceta1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "name";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                return true;
            }
        });

        imgObjetoReceta2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "name";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                return true;
            }
        });
        Bundle datos = this.getIntent().getExtras();
        String NombreObjeto = datos.getString("Name");
        mostrarDatosObjeto(NombreObjeto);
    }

    public void mostrarDatosObjeto(String Name) {
        Item aux = new Item();

        for (Item itemsito : ItemList) {
            if (itemsito.getName().equals(Name)) {
                imagenItem1(Name);
                tvDescription.setText(itemsito.getDescription());
            }
        }
    }

    public void imagenItem1(String Name) {
        switch (Name) {
            case "Spatula":
                imgObjetoPpal.setImageResource(R.drawable.spatula);
                break;
            case "Needlessly Large Rod":
                imgObjetoPpal.setImageResource(R.drawable.needlesslylargerod);
                break;
            case "Tear of the Goddess":
                imgObjetoPpal.setImageResource(R.drawable.tearofthegoddess);
                break;
            case "B.F. Sword":
                imgObjetoPpal.setImageResource(R.drawable.bfsword);
                break;
            case "Recurve Bow":
                imgObjetoPpal.setImageResource(R.drawable.recurvebow);
                break;
            case "Giants Belt":
                imgObjetoPpal.setImageResource(R.drawable.giantsbelt);
                break;
            case "Negatron Cloak":
                imgObjetoPpal.setImageResource(R.drawable.negatroncloak);
                break;
            case "Sparring Gloves":
                imgObjetoPpal.setImageResource(R.drawable.sparringgloves);
                break;
            case "Chain Vest":
                imgObjetoPpal.setImageResource(R.drawable.chainvest);
                break;
            case "Force of Nature":
                imgObjetoPpal.setImageResource(R.drawable.forceofnature);
                break;
            case "Berserker Axe":
                imgObjetoPpal.setImageResource(R.drawable.berserkeraxe);
                break;
            case "Blade of the Ruined King":
                imgObjetoPpal.setImageResource(R.drawable.bladeoftheruinedking);
                break;
            case "Frozen Mallet":
                imgObjetoPpal.setImageResource(R.drawable.frozenmallet);
                break;
            case "Inferno Cinder":
                imgObjetoPpal.setImageResource(R.drawable.infernocinder);
                break;
            case "Talisman of Light":
                imgObjetoPpal.setImageResource(R.drawable.talismanoflight);
                break;
            case "Wardens Mail":
                imgObjetoPpal.setImageResource(R.drawable.wardensmail);
                break;
            case "Youmuus Ghostblade":
                imgObjetoPpal.setImageResource(R.drawable.youmuusghostblade);
                break;
            case "Guinsoo Rageblade":
                imgObjetoPpal.setImageResource(R.drawable.guinsoosrageblade);
                break;
            case "Morellonomicon":
                imgObjetoPpal.setImageResource(R.drawable.morellonomicon);
                break;
            case "Hand of Justice":
                imgObjetoPpal.setImageResource(R.drawable.handofjustice);
                break;
            case "Iceborne Gauntlet":
                imgObjetoPpal.setImageResource(R.drawable.icebornegauntlet);
                break;
            case "Infinity Edge":
                imgObjetoPpal.setImageResource(R.drawable.infinityedge);
                break;
            case "Phantom Dancer":
                imgObjetoPpal.setImageResource(R.drawable.phantomdancer);
                break;
            case "Seraphs Embrace":
                imgObjetoPpal.setImageResource(R.drawable.seraphsembrace);
                break;
            case "Spear of Shojin":
                imgObjetoPpal.setImageResource(R.drawable.spearofshojin);
                break;
            case "Bloodthirster":
                imgObjetoPpal.setImageResource(R.drawable.bloodthirster);
                break;
            case "Deathblade":
                imgObjetoPpal.setImageResource(R.drawable.deathblade);
                break;
            case "Hush":
                imgObjetoPpal.setImageResource(R.drawable.hush);
                break;
            case "Ludens Echo":
                imgObjetoPpal.setImageResource(R.drawable.ludensecho);
                break;
            case "Rabadons Deathcap":
                imgObjetoPpal.setImageResource(R.drawable.rabadonsdeathcap);
                break;
            case "Runaans Hurricane":
                imgObjetoPpal.setImageResource(R.drawable.runaanshurricane);
                break;
            case "Sword Breaker":
                imgObjetoPpal.setImageResource(R.drawable.swordbreaker);
                break;
            case "Thiefs Gloves":
                imgObjetoPpal.setImageResource(R.drawable.thiefsgloves);
                break;
            case "Zephyr":
                imgObjetoPpal.setImageResource(R.drawable.zephyr);
                break;
            case "Giant Slayer":
                imgObjetoPpal.setImageResource(R.drawable.giantslayer);
                break;
            case "Guardian Angel":
                imgObjetoPpal.setImageResource(R.drawable.guardianangel);
                break;
            case "Ionic Spark":
                imgObjetoPpal.setImageResource(R.drawable.ionicspark);
                break;
            case "Jeweled Gauntlet":
                imgObjetoPpal.setImageResource(R.drawable.jeweledgauntlet);
                break;
            case "Red Buff":
                imgObjetoPpal.setImageResource(R.drawable.redbuff);
                break;
            case "Statikk Shiv":
                imgObjetoPpal.setImageResource(R.drawable.statikkshiv);
                break;
            case "Warmogs Armor":
                imgObjetoPpal.setImageResource(R.drawable.warmogsarmor);
                break;
            case "Zekes Herald":
                imgObjetoPpal.setImageResource(R.drawable.zekesherald);
                break;
            case "Dragons Claw":
                imgObjetoPpal.setImageResource(R.drawable.dragonsclaw);
                break;
            case "Frozen Heart":
                imgObjetoPpal.setImageResource(R.drawable.frozenheart);
                break;
            case "Hextech Gunblade":
                imgObjetoPpal.setImageResource(R.drawable.hextechgunblade);
                break;
            case "Locket of the Iron Solari":
                imgObjetoPpal.setImageResource(R.drawable.locketoftheironsolari);
                break;
            case "Rapid Firecannon":
                imgObjetoPpal.setImageResource(R.drawable.rapidfirecannon);
                break;
            case "Redemption":
                imgObjetoPpal.setImageResource(R.drawable.redemption);
                break;
            case "Trap Claw":
                imgObjetoPpal.setImageResource(R.drawable.trapclaw);
                break;
            case "Quicksilver":
                imgObjetoPpal.setImageResource(R.drawable.quicksilver);
                break;
            case "Repeating Crossbow":
                imgObjetoPpal.setImageResource(R.drawable.repeatingcrossbow);
                break;
            case "Thornmail":
                imgObjetoPpal.setImageResource(R.drawable.thornmail);
                break;
            case "Titanic Hydra":
                imgObjetoPpal.setImageResource(R.drawable.titanichydra);
                break;
            case "Mages Cap":
                imgObjetoPpal.setImageResource(R.drawable.magescap);
                break;
            default:
                imgObjetoPpal.setImageResource(R.drawable.lanada);
                break;
        }

    }

    public void imagenItem2(String Name) {
        switch (Name){
            case "Spatula":
                imgObjetoReceta1.setImageResource(R.drawable.spatula);
                break;
            case "Needlessly Large Rod":
                imgObjetoReceta1.setImageResource(R.drawable.needlesslylargerod);
                break;
            case "Tear of the Goddess":
                imgObjetoReceta1.setImageResource(R.drawable.tearofthegoddess);
                break;
            case "B.F. Sword":
                imgObjetoReceta1.setImageResource(R.drawable.bfsword);
                break;
            case "Recurve Bow":
                imgObjetoReceta1.setImageResource(R.drawable.recurvebow);
                break;
            case "Giants Belt":
                imgObjetoReceta1.setImageResource(R.drawable.giantsbelt);
                break;
            case "Negatron Cloak":
                imgObjetoReceta1.setImageResource(R.drawable.negatroncloak);
                break;
            case "Sparring Gloves":
                imgObjetoReceta1.setImageResource(R.drawable.sparringgloves);
                break;
            case "Chain Vest":
                imgObjetoReceta1.setImageResource(R.drawable.chainvest);
                break;
            case "Force of Nature":
                imgObjetoReceta1.setImageResource(R.drawable.forceofnature);
                break;
            case "Berserker Axe":
                imgObjetoReceta1.setImageResource(R.drawable.berserkeraxe);
                break;
            case "Blade of the Ruined King":
                imgObjetoReceta1.setImageResource(R.drawable.bladeoftheruinedking);
                break;
            case "Frozen Mallet":
                imgObjetoReceta1.setImageResource(R.drawable.frozenmallet);
                break;
            case "Inferno Cinder":
                imgObjetoReceta1.setImageResource(R.drawable.infernocinder);
                break;
            case "Talisman of Light":
                imgObjetoReceta1.setImageResource(R.drawable.talismanoflight);
                break;
            case "Wardens Mail":
                imgObjetoReceta1.setImageResource(R.drawable.wardensmail);
                break;
            case "Youmuus Ghostblade":
                imgObjetoReceta1.setImageResource(R.drawable.youmuusghostblade);
                break;
            case "Guinsoo Rageblade":
                imgObjetoReceta1.setImageResource(R.drawable.guinsoosrageblade);
                break;
            case "Morellonomicon":
                imgObjetoReceta1.setImageResource(R.drawable.morellonomicon);
                break;
            case "Hand of Justice":
                imgObjetoReceta1.setImageResource(R.drawable.handofjustice);
                break;
            case "Iceborne Gauntlet":
                imgObjetoReceta1.setImageResource(R.drawable.icebornegauntlet);
                break;
            case "Infinity Edge":
                imgObjetoReceta1.setImageResource(R.drawable.infinityedge);
                break;
            case "Phantom Dancer":
                imgObjetoReceta1.setImageResource(R.drawable.phantomdancer);
                break;
            case "Seraphs Embrace":
                imgObjetoReceta1.setImageResource(R.drawable.seraphsembrace);
                break;
            case "Spear of Shojin":
                imgObjetoReceta1.setImageResource(R.drawable.spearofshojin);
                break;
            case "Bloodthirster":
                imgObjetoReceta1.setImageResource(R.drawable.bloodthirster);
                break;
            case "Deathblade":
                imgObjetoReceta1.setImageResource(R.drawable.deathblade);
                break;
            case "Hush":
                imgObjetoReceta1.setImageResource(R.drawable.hush);
                break;
            case "Ludens Echo":
                imgObjetoReceta1.setImageResource(R.drawable.ludensecho);
                break;
            case "Rabadons Deathcap":
                imgObjetoReceta1.setImageResource(R.drawable.rabadonsdeathcap);
                break;
            case "Runaans Hurricane":
                imgObjetoReceta1.setImageResource(R.drawable.runaanshurricane);
                break;
            case "Sword Breaker":
                imgObjetoReceta1.setImageResource(R.drawable.swordbreaker);
                break;
            case "Thiefs Gloves":
                imgObjetoReceta1.setImageResource(R.drawable.thiefsgloves);
                break;
            case "Zephyr":
                imgObjetoReceta1.setImageResource(R.drawable.zephyr);
                break;
            case "Giant Slayer":
                imgObjetoReceta1.setImageResource(R.drawable.giantslayer);
                break;
            case "Guardian Angel":
                imgObjetoReceta1.setImageResource(R.drawable.guardianangel);
                break;
            case "Ionic Spark":
                imgObjetoReceta1.setImageResource(R.drawable.ionicspark);
                break;
            case "Jeweled Gauntlet":
                imgObjetoReceta1.setImageResource(R.drawable.jeweledgauntlet);
                break;
            case "Red Buff":
                imgObjetoReceta1.setImageResource(R.drawable.redbuff);
                break;
            case "Statikk Shiv":
                imgObjetoReceta1.setImageResource(R.drawable.statikkshiv);
                break;
            case "Warmogs Armor":
                imgObjetoReceta1.setImageResource(R.drawable.warmogsarmor);
                break;
            case "Zekes Herald":
                imgObjetoReceta1.setImageResource(R.drawable.zekesherald);
                break;
            case "Dragons Claw":
                imgObjetoReceta1.setImageResource(R.drawable.dragonsclaw);
                break;
            case "Frozen Heart":
                imgObjetoReceta1.setImageResource(R.drawable.frozenheart);
                break;
            case "Hextech Gunblade":
                imgObjetoReceta1.setImageResource(R.drawable.hextechgunblade);
                break;
            case "Locket of the Iron Solari":
                imgObjetoReceta1.setImageResource(R.drawable.locketoftheironsolari);
                break;
            case "Rapid Firecannon":
                imgObjetoReceta1.setImageResource(R.drawable.rapidfirecannon);
                break;
            case "Redemption":
                imgObjetoReceta1.setImageResource(R.drawable.redemption);
                break;
            case "Trap Claw":
                imgObjetoReceta1.setImageResource(R.drawable.trapclaw);
                break;
            case "Quicksilver":
                imgObjetoReceta1.setImageResource(R.drawable.quicksilver);
                break;
            case "Repeating Crossbow":
                imgObjetoReceta1.setImageResource(R.drawable.repeatingcrossbow);
                break;
            case "Thornmail":
                imgObjetoReceta1.setImageResource(R.drawable.thornmail);
                break;
            case "Titanic Hydra":
                imgObjetoReceta1.setImageResource(R.drawable.titanichydra);
                break;
            case "Mages Cap":
                imgObjetoReceta1.setImageResource(R.drawable.magescap);
                break;
            default:
                imgObjetoReceta1.setImageResource(R.drawable.lanada);
                break;
        }

    }

    public void imagenItem3(String Name) {
        switch (Name){
            case "Spatula":
                imgObjetoReceta2.setImageResource(R.drawable.spatula);
                break;
            case "Needlessly Large Rod":
                imgObjetoReceta2.setImageResource(R.drawable.needlesslylargerod);
                break;
            case "Tear of the Goddess":
                imgObjetoReceta2.setImageResource(R.drawable.tearofthegoddess);
                break;
            case "B.F. Sword":
                imgObjetoReceta2.setImageResource(R.drawable.bfsword);
                break;
            case "Recurve Bow":
                imgObjetoReceta2.setImageResource(R.drawable.recurvebow);
                break;
            case "Giants Belt":
                imgObjetoReceta2.setImageResource(R.drawable.giantsbelt);
                break;
            case "Negatron Cloak":
                imgObjetoReceta2.setImageResource(R.drawable.negatroncloak);
                break;
            case "Sparring Gloves":
                imgObjetoReceta2.setImageResource(R.drawable.sparringgloves);
                break;
            case "Chain Vest":
                imgObjetoReceta2.setImageResource(R.drawable.chainvest);
                break;
            case "Force of Nature":
                imgObjetoReceta2.setImageResource(R.drawable.forceofnature);
                break;
            case "Berserker Axe":
                imgObjetoReceta2.setImageResource(R.drawable.berserkeraxe);
                break;
            case "Blade of the Ruined King":
                imgObjetoReceta2.setImageResource(R.drawable.bladeoftheruinedking);
                break;
            case "Frozen Mallet":
                imgObjetoReceta2.setImageResource(R.drawable.frozenmallet);
                break;
            case "Inferno Cinder":
                imgObjetoReceta2.setImageResource(R.drawable.infernocinder);
                break;
            case "Talisman of Light":
                imgObjetoReceta2.setImageResource(R.drawable.talismanoflight);
                break;
            case "Wardens Mail":
                imgObjetoReceta2.setImageResource(R.drawable.wardensmail);
                break;
            case "Youmuus Ghostblade":
                imgObjetoReceta2.setImageResource(R.drawable.youmuusghostblade);
                break;
            case "Guinsoo Rageblade":
                imgObjetoReceta2.setImageResource(R.drawable.guinsoosrageblade);
                break;
            case "Morellonomicon":
                imgObjetoReceta2.setImageResource(R.drawable.morellonomicon);
                break;
            case "Hand of Justice":
                imgObjetoReceta2.setImageResource(R.drawable.handofjustice);
                break;
            case "Iceborne Gauntlet":
                imgObjetoReceta2.setImageResource(R.drawable.icebornegauntlet);
                break;
            case "Infinity Edge":
                imgObjetoReceta2.setImageResource(R.drawable.infinityedge);
                break;
            case "Phantom Dancer":
                imgObjetoReceta2.setImageResource(R.drawable.phantomdancer);
                break;
            case "Seraphs Embrace":
                imgObjetoReceta2.setImageResource(R.drawable.seraphsembrace);
                break;
            case "Spear of Shojin":
                imgObjetoReceta2.setImageResource(R.drawable.spearofshojin);
                break;
            case "Bloodthirster":
                imgObjetoReceta2.setImageResource(R.drawable.bloodthirster);
                break;
            case "Deathblade":
                imgObjetoReceta2.setImageResource(R.drawable.deathblade);
                break;
            case "Hush":
                imgObjetoReceta2.setImageResource(R.drawable.hush);
                break;
            case "Ludens Echo":
                imgObjetoReceta2.setImageResource(R.drawable.ludensecho);
                break;
            case "Rabadons Deathcap":
                imgObjetoReceta2.setImageResource(R.drawable.rabadonsdeathcap);
                break;
            case "Runaans Hurricane":
                imgObjetoReceta2.setImageResource(R.drawable.runaanshurricane);
                break;
            case "Sword Breaker":
                imgObjetoReceta2.setImageResource(R.drawable.swordbreaker);
                break;
            case "Thiefs Gloves":
                imgObjetoReceta2.setImageResource(R.drawable.thiefsgloves);
                break;
            case "Zephyr":
                imgObjetoReceta2.setImageResource(R.drawable.zephyr);
                break;
            case "Giant Slayer":
                imgObjetoReceta2.setImageResource(R.drawable.giantslayer);
                break;
            case "Guardian Angel":
                imgObjetoReceta2.setImageResource(R.drawable.guardianangel);
                break;
            case "Ionic Spark":
                imgObjetoReceta2.setImageResource(R.drawable.ionicspark);
                break;
            case "Jeweled Gauntlet":
                imgObjetoReceta2.setImageResource(R.drawable.jeweledgauntlet);
                break;
            case "Red Buff":
                imgObjetoReceta2.setImageResource(R.drawable.redbuff);
                break;
            case "Statikk Shiv":
                imgObjetoReceta2.setImageResource(R.drawable.statikkshiv);
                break;
            case "Warmogs Armor":
                imgObjetoReceta2.setImageResource(R.drawable.warmogsarmor);
                break;
            case "Zekes Herald":
                imgObjetoReceta2.setImageResource(R.drawable.zekesherald);
                break;
            case "Dragons Claw":
                imgObjetoReceta2.setImageResource(R.drawable.dragonsclaw);
                break;
            case "Frozen Heart":
                imgObjetoReceta2.setImageResource(R.drawable.frozenheart);
                break;
            case "Hextech Gunblade":
                imgObjetoReceta2.setImageResource(R.drawable.hextechgunblade);
                break;
            case "Locket of the Iron Solari":
                imgObjetoReceta2.setImageResource(R.drawable.locketoftheironsolari);
                break;
            case "Rapid Firecannon":
                imgObjetoReceta2.setImageResource(R.drawable.rapidfirecannon);
                break;
            case "Redemption":
                imgObjetoReceta2.setImageResource(R.drawable.redemption);
                break;
            case "Trap Claw":
                imgObjetoReceta2.setImageResource(R.drawable.trapclaw);
                break;
            case "Quicksilver":
                imgObjetoReceta2.setImageResource(R.drawable.quicksilver);
                break;
            case "Repeating Crossbow":
                imgObjetoReceta2.setImageResource(R.drawable.repeatingcrossbow);
                break;
            case "Thornmail":
                imgObjetoReceta2.setImageResource(R.drawable.thornmail);
                break;
            case "Titanic Hydra":
                imgObjetoReceta2.setImageResource(R.drawable.titanichydra);
                break;
            case "Mages Cap":
                imgObjetoReceta2.setImageResource(R.drawable.magescap);
                break;
            default:
                imgObjetoReceta2.setImageResource(R.drawable.lanada);
                break;
        }
    }


}
