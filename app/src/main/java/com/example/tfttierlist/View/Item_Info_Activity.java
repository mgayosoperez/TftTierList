package com.example.tfttierlist.View;

import android.content.Context;
import android.os.Bundle;

import com.example.tfttierlist.Core.Item;
import com.example.tfttierlist.Core.Sqlito;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfttierlist.R;

import java.util.ArrayList;
import java.util.List;

public class Item_Info_Activity extends AppCompatActivity {
    private List<Item> ItemList = new ArrayList<>();
    private Sqlito BaseDatos;

    private String NombreObjetoReceta1;
    private String NombreObjetoReceta2;
    private TextView tvDescription;
    private TextView tvItemName;
    private TextView tvItemTier;
    private ImageView imgObjetoPpal;
    private ImageView imgObjetoReceta1;
    private ImageView imgObjetoReceta2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_info_layout);

        this.BaseDatos = new Sqlito(this.getApplicationContext());
        ItemList = BaseDatos.recuperaItemsAlfabeticamente();

        //Inicializar variables
        tvDescription = findViewById(R.id.tvItemDescripcion);
        tvItemName = findViewById(R.id.tvItemName);
        tvItemTier = findViewById(R.id.tvItemTier);
        imgObjetoPpal = findViewById(R.id.imageViewItem);
        imgObjetoReceta1 = findViewById(R.id.imageViewItemRecipe1);
        imgObjetoReceta2 = findViewById(R.id.imageViewItemRecipe2);


        Bundle datos = this.getIntent().getExtras();
        Item ItemToShow = (Item) datos.getSerializable("Item");
        mostrarDatosObjeto(ItemToShow);

        imgObjetoReceta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatosObjetoNombre(NombreObjetoReceta1);
            }
        });
        imgObjetoReceta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatosObjetoNombre(NombreObjetoReceta2);
            }
        });
        imgObjetoReceta1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = NombreObjetoReceta1;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                return true;
            }
        });
        imgObjetoReceta2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = NombreObjetoReceta2;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                return true;
            }
        });
    }
    public void mostrarDatosObjeto(Item itemsito) {
        String imagename1 = itemsito.getName().toLowerCase().replace(" ","");
        imgObjetoPpal.setImageResource(getResources().getIdentifier(imagename1,"drawable", this.getPackageName()));
        String imagename2 = itemsito.getItem1().toLowerCase().replace(" ","");
        imgObjetoReceta1.setImageResource(getResources().getIdentifier(imagename2,"drawable", this.getPackageName()));
        String imagename3 = itemsito.getItem2().toLowerCase().replace(" ","");
        imgObjetoReceta2.setImageResource(getResources().getIdentifier(imagename3,"drawable", this.getPackageName()));

        NombreObjetoReceta1 = itemsito.getItem1();
          NombreObjetoReceta2 = itemsito.getItem2();
          tvItemName.setText(itemsito.getName());
          tvItemTier.setText(itemsito.getTier());
          tvDescription.setText(itemsito.getDescription());
    }

    public void mostrarDatosObjetoNombre(String Name) {
        for(Item itemsito : ItemList) {
            if (itemsito.getName().equals(Name)) {
                String imagename1 = itemsito.getName().toLowerCase().replace(" ","");
                imgObjetoPpal.setImageResource(getResources().getIdentifier(imagename1,"drawable", this.getPackageName()));
                String imagename2 = itemsito.getItem1().toLowerCase().replace(" ","");
                imgObjetoReceta1.setImageResource(getResources().getIdentifier(imagename2,"drawable", this.getPackageName()));
                String imagename3 = itemsito.getItem2().toLowerCase().replace(" ","");
                imgObjetoReceta2.setImageResource(getResources().getIdentifier(imagename3,"drawable", this.getPackageName()));

                NombreObjetoReceta1 = itemsito.getItem1();
                NombreObjetoReceta2 = itemsito.getItem2();
                tvItemName.setText(itemsito.getName());
                if(itemsito.getTier().equals("1")){
                    tvItemTier.setText("S");
                }else tvItemTier.setText(itemsito.getTier());
                tvDescription.setText(itemsito.getDescription());
            }
        }
    }
}
