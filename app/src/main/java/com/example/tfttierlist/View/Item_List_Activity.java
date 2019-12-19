package com.example.tfttierlist.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item_List_Activity extends AppCompatActivity {
    private GridView itemsGrid;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
    private Sqlito BaseDatos;
    private List<Item> ItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_layout);


        itemsGrid = (GridView) findViewById(R.id.itemsGrid);

        itemsGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verItem(maplist.get(position).get("Name").toString());
            }
        });

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        ItemList = BaseDatos.recuperaItems();

        maplist.clear();

        for (Item item : ItemList) {
            HashMap<String, Object> item1 = new HashMap<>();
            Log.d("STATUS",item.getName());
            item1.put("Name", item.getName());
            int id = idImagen("Pepe");
            item1.put("Img", id);
            maplist.add(item1);
        }

        Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
        itemsGrid.setAdapter(adapter);
        this.registerForContextMenu(itemsGrid);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {

            case R.id.OrdenarObjetoAlfa:
                this.alfabetico();
                Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter);
                break;
            case R.id.OrdenarObjetoCoste:
                this.coste();
                Item_List_Activity.GridAdapter adapter1 = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter1);
                break;
            case R.id.OrdenarObjetoTier:
                this.tier();
                Item_List_Activity.GridAdapter adapter2 = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter2);
                break;
        }
        return toret;

    }


    public class GridAdapter extends BaseAdapter {
        private Context mContext;

        public GridAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return maplist.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            // Inflate the layout for each list item
            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (v == null) {
                v = _inflater.inflate(R.layout.list_items, null);
            }
            // Get the TextView and ImageView from CustomView for displaying item
            TextView txtview = (TextView) v.findViewById(R.id.listItemTextView);
            ImageView imgview = (ImageView)v.findViewById(R.id.listItemsImageView);


            String currentItem = maplist.get(position).get("Name").toString();
            // Set the text and image for current item using data from map list
            txtview.setText(currentItem);
            String calidad = maplist.get(position).get("Img").toString();
            imgview.setImageResource(Integer.parseInt(calidad));

            return v;
        }
    }

    public void verItem(String Name) {
        Intent intent = new Intent(this, Item_Info_Activity.class);
        intent.putExtra("Name", Name);
        this.startActivityForResult(intent, 11);
    }

    public void alfabetico() {

    }

    public void tier() {

    }

    public void coste() {

    }

    public int idImagen(String Name){
        switch(Name) {
            case "Spatula":
                return R.drawable.spatula;
            case "Needlessly Large Rod":
                return R.drawable.needlesslylargerod;
            case "Tear of the Goddess":
                return R.drawable.tearofthegoddess;
            case "B.F. Sword":
                return R.drawable.bfsword;
            case "Recurve Bow":
                return R.drawable.recurvebow;
            case "Giants Belt":
                return R.drawable.giantsbelt;
            case "Negatron Cloak":
                return R.drawable.negatroncloak;
            case "Sparring Gloves":
                return R.drawable.sparringgloves;
            case "Chain Vest":
                return R.drawable.chainvest;
            case "Force of Nature":
                return R.drawable.forceofnature;
            case "Berserker Axe":
                return R.drawable.berserkeraxe;
            case "Blade of the Ruined King":
                return R.drawable.bladeoftheruinedking;
            case "Frozen Mallet":
                return R.drawable.frozenmallet;
            case "Inferno Cinder":
                return R.drawable.infernocinder;
            case "Talisman of Light":
                return R.drawable.talismanoflight;
            case "Wardens Mail":
                return R.drawable.wardensmail;
            case "Youmuus Ghostblade":
                return R.drawable.youmuusghostblade;
            case "Guinsoo Rageblade":
                return R.drawable.guinsoosrageblade;
            case "Morellonomicon":
                return R.drawable.morellonomicon;
            case "Hand of Justice":
                return R.drawable.handofjustice;
            case "Iceborne Gauntlet":
                return R.drawable.icebornegauntlet;
            case "Infinity Edge":
                return R.drawable.infinityedge;
            case "Phantom Dancer":
                return R.drawable.phantomdancer;
            case "Seraphs Embrace":
                return R.drawable.seraphsembrace;
            case "Spear of Shojin":
                return R.drawable.spearofshojin;
            case "Bloodthirster":
                return R.drawable.bloodthirster;
            case "Deathblade":
                return R.drawable.deathblade;
            case "Hush":
                return R.drawable.hush;
            case "Ludens Echo":
                return R.drawable.ludensecho;
            case "Rabadons Deathcap":
                return R.drawable.rabadonsdeathcap;
            case "Runaans Hurricane":
                return R.drawable.runaanshurricane;
            case "Sword Breaker":
                return R.drawable.swordbreaker;
            case "Thiefs Gloves":
                return R.drawable.thiefsgloves;
            case "Zephyr":
                return R.drawable.zephyr;
            case "Giant Slayer":
                return R.drawable.giantslayer;
            case "Guardian Angel":
                return R.drawable.guardianangel;
            case "Ionic Spark":
                return R.drawable.ionicspark;
            case "Jeweled Gauntlet":
                return R.drawable.jeweledgauntlet;
            case "Red Buff":
                return R.drawable.redbuff;
            case "Statikk Shiv":
                return R.drawable.statikkshiv;
            case "Warmogs Armor":
                return R.drawable.warmogsarmor;
            case "Zekes Herald":
                return R.drawable.zekesherald;
            case "Dragons Claw":
                return R.drawable.dragonsclaw;
            case "Frozen Heart":
                return R.drawable.frozenheart;
            case "Hextech Gunblade":
                return R.drawable.hextechgunblade;
            case "Locket of the Iron Solari":
                return R.drawable.locketoftheironsolari;
            case "Rapid Firecannon":
                return R.drawable.rapidfirecannon;
            case "Redemption":
                return R.drawable.redemption;
            case "Trap Claw":
                return R.drawable.trapclaw;
            case "Quicksilver":
                return R.drawable.quicksilver;
            case "Repeating Crossbow":
                return R.drawable.repeatingcrossbow;
            case "Thornmail":
                return R.drawable.thornmail;
            case "Titanic Hydra":
                return R.drawable.titanichydra;
            default:
                return R.drawable.aatrox;
        }
    }

}
