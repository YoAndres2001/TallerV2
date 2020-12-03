package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrudSelectAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_select_admin);
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, IndexAdmin.class);
        startActivity(Cancelar);
    }
}