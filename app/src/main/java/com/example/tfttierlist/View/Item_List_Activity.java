package com.example.tfttierlist.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
import android.widget.SearchView;
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
    private List<String> SearchList;
    private int opc;

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
        alfabetico();
        this.registerForContextMenu(itemsGrid);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {

            case R.id.OrdenarObjetoAlfa:
                this.alfabetico();
                break;
            case R.id.OrdenarObjetoTier:
                this.tier();
                break;
        }
        return toret;

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.item_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean toret = false;
        switch (item.getItemId()) {
            case R.id.SearchItem:
               Busqueda();
               break;
        }
        return toret;
    }

    public void Busqueda (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        final SearchView SVITEM = new SearchView(this);
        this.opc = 0;
        builder.setTitle("Search Champ");
        builder.setView(SVITEM);

        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String champChain = SVITEM.getQuery().toString();
                SearchList = BaseDatos.searchItems(champChain);
                mostrarBusqueda();
            }
        });
        GridAdapter adapter = new GridAdapter(this);
        itemsGrid.setAdapter(adapter);
        builder.show();
    }

    public void verItem(String Name) {
        Item TheItem = new Item();
        for(Item itemsito : ItemList) {
            if (itemsito.getName().equals(Name)) {
                TheItem = itemsito;
            }
        }
        Intent intent = new Intent(this, Item_Info_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Item", TheItem);
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 11);
    }
    public void mostrarBusqueda() {
        maplist.clear();

        for (String str : SearchList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", str);
            String imagename = str.toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }
    }

    public void alfabetico() {
        ItemList = BaseDatos.recuperaItemsAlfabeticamente();

        maplist.clear();

        for (Item itemsito : ItemList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", itemsito.getName());
            String imagename = itemsito.getName().toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }

        Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
        itemsGrid.setAdapter(adapter);

    }

    public void tier() {
        ItemList = BaseDatos.recuperaItemsTier();

        maplist.clear();

        for (Item itemsito : ItemList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", itemsito.getName());
            String imagename = itemsito.getName().toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }

        Item_List_Activity.GridAdapter adapter = new Item_List_Activity.GridAdapter(this);
        itemsGrid.setAdapter(adapter);
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

}
