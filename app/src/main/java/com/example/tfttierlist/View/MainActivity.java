package com.example.tfttierlist.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfttierlist.Core.Champion;
import com.example.tfttierlist.Core.SqlIO;
import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView champGrid;
    private SqlIO BaseDatos;
    private List<Champion> ChampionList;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChampionList.addAll(this.BaseDatos.recuperaTodosLosCampeones());

        champGrid = (GridView) findViewById(R.id.champsGrid);
        champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
                Toast.makeText(getApplicationContext(), maplist.get(p3).get("Name").toString(), Toast.LENGTH_LONG).show();
            }

        });
        for (Champion c : ChampionList) {
            String aux = c.getName().toLowerCase();
            if (aux.contains(" ")) {
                aux = aux.replace(" ", "");
            }
            String imgName = "R.drawable." + aux;
            HashMap<String, Object> mapAux = new HashMap<>();
            mapAux.put("Name", c.getName());
            mapAux.put("Img", imgName);
            maplist.add(mapAux);
        }
        GridAdapter adapter = new GridAdapter(this);
        champGrid.setAdapter(adapter);
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
                LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (v == null) {
                    v = _inflater.inflate(R.layout.list_champs, null);
                }
                // Get the TextView and ImageView from CustomView for displaying item
                TextView txtview = (TextView) v.findViewById(R.id.listChampTextView);
                ImageView imgview = (ImageView) v.findViewById(R.id.listChampImageView);

                // Set the text and image for current item using data from map list
                txtview.setText(maplist.get(position).get("Name").toString());
                imgview.setImageResource(Integer.parseInt(maplist.get(position).get("Img").toString()));
                return v;
            }
        }


    }

