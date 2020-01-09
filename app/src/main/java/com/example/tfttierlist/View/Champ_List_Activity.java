package com.example.tfttierlist.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
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
    private List<String> FavoritesList;
    private List<String> SearchList;
    private int opc;

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
            case R.id.VerFavoritos:
                this.mostrarFavorito();
                GridAdapter adapter0 = new GridAdapter(this);
                champGrid.setAdapter(adapter0);
                break;
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
            case R.id.buscarCampeon:
                Busqueda();
                break;
            case R.id.verObjetos:
                Intent intent = new Intent(this, Item_List_Activity.class);
                this.startActivityForResult(intent, 11);
                break;
        }
        return toret;
    }
    public void Busqueda (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        final SearchView SVCHAMP = new SearchView(this);
        this.opc = 0;
        builder.setTitle("Search Champ");
        builder.setView(SVCHAMP);

        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String champChain = SVCHAMP.getQuery().toString();
                SearchList = BaseDatos.searchChamps(champChain);
                mostrarBusqueda();
            }
        });
        GridAdapter adapter = new GridAdapter(this);
        champGrid.setAdapter(adapter);
        builder.show();

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
            String imagename = champ.getName().toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }
    }


    public void mostrarFavorito() {
        FavoritesList = BaseDatos.showFavoriteChampions();

        maplist.clear();

        for (String str : FavoritesList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", str);
            String imagename = str.toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }
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

    public void tier() {
        ChampionList = BaseDatos.recuperaTodoTier();

        maplist.clear();

        for (Champion champ : ChampionList) {
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", champ.getName());
            String imagename = champ.getName().toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
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
            String imagename = champ.getName().toLowerCase().replace(" ","");
            int id = getResources().getIdentifier(imagename,"drawable", this.getPackageName());
            item1.put("Img", id);
            maplist.add(item1);
        }
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
}



