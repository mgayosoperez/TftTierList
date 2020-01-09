package com.example.tfttierlist.View;

import android.os.Bundle;

import com.example.tfttierlist.Core.Origin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tfttierlist.R;

public class OriginClass_Activity extends AppCompatActivity {

    private TextView OriginClassName;
    private TextView OriginClassDescription;
    private ImageView ivOriginClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_origin_class_);

        OriginClassName= findViewById(R.id.tvOriClassName);
        OriginClassDescription = findViewById(R.id.tvOriClassDescription);
        ivOriginClass = findViewById(R.id.ivOriginClass);

        Bundle datos = this.getIntent().getExtras();
        Origin OriginToShow = (Origin) datos.getSerializable("Origin");

        OriginClassName.setText(OriginToShow.getName());
        OriginClassDescription.setText(OriginToShow.getDescription());

        String imagename = OriginToShow.getName().toLowerCase().replace(" ","");
        ivOriginClass.setImageResource(getResources().getIdentifier(imagename,"drawable", this.getPackageName()));
    }


}
