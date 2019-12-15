package com.example.tfttierlist.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
    private Window window;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set color to the status bar
        this.window = getWindow();
        //window.setStatusBarColor(Color.parseColor("5c007a"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("43a047")));
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("757575")));
        window.setNavigationBarColor(Color.parseColor("43a047"));


        champGrid = (GridView) findViewById(R.id.champsGrid);
        champGrid.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
                Toast.makeText(getApplicationContext(), maplist.get(p3).get("Name").toString(), Toast.LENGTH_LONG).show();
            }

        });
            HashMap<String, Object> item1 = new HashMap<>();
            item1.put("Name", "Aatrox");
            item1.put("Img", R.drawable.aatrox);
            maplist.add(item1);

            HashMap<String, Object> item2 = new HashMap<>();
            item2.put("Name", "Annie");
            item2.put("Img", R.drawable.annie);
            maplist.add(item2);

            HashMap<String, Object> item3 = new HashMap<>();
            item3.put("Name", "Zed");
            item3.put("Img", R.drawable.zed);

            maplist.add(item3);
            HashMap<String, Object> item4 = new HashMap<>();
            item4.put("Name", "Dr Mundo");
            item4.put("Img", R.drawable.drmundo);

            maplist.add(item4);
            HashMap<String, Object> item5 = new HashMap<>();
            item5.put("Name", "Master Yi");
            item5.put("Img", R.drawable.masteryi);
            maplist.add(item5);

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

