package com.example.tfttierlist.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.Sqlito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item_List_Activity extends AppCompatActivity {
    private GridView itemsGrid;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
    private Sqlito BaseDatos;
    private List<Champion> ChampionList;

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
        ChampionList = BaseDatos.recuperaTodoAlfabetico();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            Log.d("STATUS",champ.getName());
            item1.put("Name", champ.getName());
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

            case R.id.OrdenarAlfa:
                this.alfabetico();
                Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter);
                break;
            case R.id.OrdenarPorCoste:
                this.coste();
                Item_List_Activity.GridAdapter adapter1 = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter1);
                break;
            case R.id.OrdenarPorTier:
                this.tier();
                Item_List_Activity.GridAdapter adapter2 = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter2);
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

            case R.id.verObjetos:
                this.alfabetico();
                Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
                itemsGrid.setAdapter(adapter);
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
        Intent intent = new Intent(this, Champ_Info_Activity.class);
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
        return R.drawable.aatrox;
    }

}
