package com.example.tfttierlist.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tfttierlist.Core.ChampClass;
import com.example.tfttierlist.Core.ChampOrigin;
import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView champGrid;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
    private Sqlito BaseDatos;
    private List<Champion> ChampionList;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        champGrid = (GridView) findViewById(R.id.champsGrid);

        champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nuevoCampeon(maplist.get(position).get("Name").toString());
            }
        });

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        ChampionList = BaseDatos.recuperaTodoAlfabetico();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            int id = idImagen("Pepe");
            item1.put("Img", id);
            maplist.add(item1);
        }

        GridAdapter adapter = new GridAdapter(this);
        champGrid.setAdapter(adapter);


        this.registerForContextMenu(champGrid);
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
        this.getMenuInflater().inflate(R.menu.actions_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {

            case R.id.alphOrder:
                this.alfabetico();
                GridAdapter adapter = new GridAdapter(this);
                champGrid.setAdapter(adapter);
                break;
            case R.id.costOrder:
                this.coste();
                GridAdapter adapter1 = new GridAdapter(this);
                champGrid.setAdapter(adapter1);
                break;
            case R.id.tierOrder:
                this.tier();
                GridAdapter adapter2 = new GridAdapter(this);
                champGrid.setAdapter(adapter2);
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
                v = _inflater.inflate(R.layout.list_champs, null);
            }
            // Get the TextView and ImageView from CustomView for displaying item
            TextView txtview = (TextView) v.findViewById(R.id.listChampTextView);
            ImageView imgview = (ImageView)v.findViewById(R.id.listChampImageView);


            String currentItem = maplist.get(position).get("Name").toString();
            // Set the text and image for current item using data from map list
            txtview.setText(currentItem);
            String mierda = maplist.get(position).get("Img").toString();
            Log.d("STATUS",mierda);
            imgview.setImageResource(Integer.parseInt(mierda));

            return v;
        }
    }

    public void nuevoCampeon(String Name) {
        Intent intent = new Intent(this, Champ_Info_Activity.class);
        intent.putExtra("Name", Name);
        this.startActivityForResult(intent, 11);
    }

    public void alfabetico() {
        ChampionList = BaseDatos.recuperaTodoAlfabetico();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            int id = idImagen("Pepe");
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
            int id = idImagen("Pepe");
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
            int id = idImagen("Pepe");
            item1.put("Img", id);
            maplist.add(item1);
        }
    }

    public int idImagen(String Name){
       return R.drawable.aatrox;

    }

}



