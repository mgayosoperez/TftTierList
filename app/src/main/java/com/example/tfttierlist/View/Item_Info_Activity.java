package com.example.tfttierlist.View;

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

        Bundle datos = this.getIntent().getExtras();
        String NombreObjeto = datos.getString("Name");
        mostrarDatosObjeto(NombreObjeto);
    }

    public void mostrarDatosObjeto(String Name){
        Item aux = new Item();

        for(Item itemsito : ItemList){
            if (itemsito.getName().equals(Name)){
                imagenItem(Name);
                tvDescription.setText(itemsito.getDescription());
            }
        }
    }

    public void imagenItem (String Name){
        imgObjetoPpal.setImageResource(R.drawable.bfsword);
        imgObjetoReceta1.setImageResource(R.drawable.lanada);
        imgObjetoReceta2.setImageResource(R.drawable.lanada);
    }


}
