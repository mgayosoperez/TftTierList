package com.example.tfttierlist.View;

import android.os.Bundle;

import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.List;

public class Item_Info_Activity extends AppCompatActivity {
    private List<Item> ItemList = new ArrayList<>();
    private Sqlito BaseDatos;

    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_info_layout);

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        ItemList = BaseDatos.recuperaItems();

        //Inicializar variables
        tvDescription = findViewById(R.id.tvItemDescription);

        Item aux = new Item();



    }

}
