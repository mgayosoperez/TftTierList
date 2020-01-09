package com.example.tfttierlist.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Champ_List_Activity extends AppCompatActivity {
    private GridView champGrid;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
    private Sqlito BaseDatos;
    private List<Champion> ChampionList;
    private ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       champGrid = (GridView)findViewById(R.id.champsGrid);

       champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               nuevoCampeon(maplist.get(position).get("Name").toString());
           }
       });

       this.BaseDatos = new Sqlito(this.getApplicationContext());
       ChampionList = BaseDatos.recuperaTodoAlfabetico();



       alfabetico();
       GridAdapter adapter = new GridAdapter(this);
       champGrid.setAdapter(adapter);

       this.registerForContextMenu(champGrid);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.champ_context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {

            case R.id.OrdenarAlfa:
                this.alfabetico();
                GridAdapter adapter = new GridAdapter(this);
                champGrid.setAdapter(adapter);
                break;
            case R.id.OrdenarPorCoste:
                this.coste();
                GridAdapter adapter1 = new GridAdapter(this);
                champGrid.setAdapter(adapter1);
                break;
            case R.id.OrdenarPorTier:
                this.tier();
                GridAdapter adapter2 = new GridAdapter(this);
                champGrid.setAdapter(adapter2);
                break;
        }
        return toret;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.champ_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {

            case R.id.verObjetos:
                Intent intent = new Intent(this, Item_List_Activity.class);
                this.startActivityForResult(intent, 11);
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
                v = _inflater.inflate(R.layout.list_champs, null);
            }
            // Get the TextView and ImageView from CustomView for displaying item
            TextView txtview = (TextView) v.findViewById(R.id.listChampTextView);
            ImageView imgview = (ImageView)v.findViewById(R.id.listChampImageView);


            String currentItem = maplist.get(position).get("Name").toString();
            // Set the text and image for current item using data from map list
            txtview.setText(currentItem);
            String calidad = maplist.get(position).get("Img").toString();
            imgview.setImageResource(Integer.parseInt(calidad));

            return v;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        alfabetico();
    }

    public void nuevoCampeon(String Name) {
        Champion champ = new Champion();
        for(Champion aux : ChampionList) {
            if (aux.getName().equals(Name)) {
                champ = aux;
            }
        }
        Intent intent = new Intent(this, Champ_Info_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Champ", champ);
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 11);
    }

    public void alfabetico() {
        ChampionList = BaseDatos.recuperaTodoAlfabetico();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            int id = idImagen(champ.getName());
            item1.put("Img", id);
            maplist.add(item1);
        }
    }

    public void tier() {
        ChampionList = BaseDatos.recuperaTodoTier();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            int id = idImagen(champ.getName());
            item1.put("Img", id);
            maplist.add(item1);
        }
    }

    public void coste() {
        ChampionList = BaseDatos.recuperaTodoCoste();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            int id = idImagen(champ.getName());
            item1.put("Img", id);
            maplist.add(item1);
        }
    }

    public int idImagen(String Name) {
        switch(Name) {
            case "Singed":
                return R.drawable.singed;
            case "Olaf":
                return R.drawable.olaf;
            case "Nocturne":
                return R.drawable.nocturne;
            case "Nami":
                return R.drawable.nami;
            case "Lux":
                return R.drawable.lux;
            case "Vladimir":
                return R.drawable.vladimir;
            case "Yasuo":
                return R.drawable.yasuo;
            case "Sivir":
                return R.drawable.sivir;
            case "Nautilus":
                return R.drawable.nautilus;
            case "Maokai":
                return R.drawable.maokai;
            case "Ashe":
                return R.drawable.ashe;
            case "Master Yi":
                return R.drawable.masteryi;
            case "Zed":
                return R.drawable.zed;
            case "Annie":
                return R.drawable.annie;
            case "Brand":
                return R.drawable.brand;
            case "Janna":
                return R.drawable.janna;
            case "Kindred":
                return R.drawable.kindred;
            case "Malphite":
                return R.drawable.malphite;
            case "Qiyana":
                return R.drawable.qiyana;
            case "Taric":
                return R.drawable.taric;
            case "Skarner":
                return R.drawable.skarner;
            case "Volibear":
                return R.drawable.volibear;
            case "Yorick":
                return R.drawable.yorick;
            case "Senna":
                return R.drawable.senna;
            case "Lucian":
                return R.drawable.lucian;
            case "Dr Mundo":
                return R.drawable.drmundo;
            case "Ezreal":
                return R.drawable.ezreal;
            case "KogMaw":
                return R.drawable.kogmaw;
            case "LeBlanc":
                return R.drawable.leblanc;
            case "Malzahar":
                return R.drawable.malzahar;
            case "RekSai":
                return R.drawable.reksai;
            case "Soraka":
                return R.drawable.soraka;
            case "Syndra":
                return R.drawable.syndra;
            case "Thresh":
                return R.drawable.thresh;
            case "Twitch":
                return R.drawable.twitch;
            case "Zyra":
                return R.drawable.zyra;
            case "Amumu":
                return R.drawable.amumu;
            case "Aatrox":
                return R.drawable.aatrox;
            case "Azir":
                return R.drawable.azir;
            case "Diana":
                return R.drawable.diana;
            case "Ivern":
                return R.drawable.ivern;
            case "Sion":
                return R.drawable.sion;
            case "Varus":
                return R.drawable.varus;
            case "Braum":
                return R.drawable.braum;
            case "Jax":
                return R.drawable.jax;
            case "Nasus":
                return R.drawable.nasus;
            case "Neeko":
                return R.drawable.neeko;
            case "Vayne":
                return R.drawable.vayne;
            case "Warwick":
                return R.drawable.warwick;
            case "Taliyah":
                return R.drawable.taliyah;
            case "Veigar":
                return R.drawable.veigar;
            case "Khazix":
                return R.drawable.khazix;
            case "Renekton":
                return R.drawable.renekton;
            case "Ornn":
                return R.drawable.ornn;
            default:
                return R.drawable.zed;
        }
    }

}



