package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrudIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_index);
    }

    public void GoToInsertar(View view){
        Intent ActivityRegistrar = new Intent(this, CrudInsert.class);
        startActivity(ActivityRegistrar);
    }

    public void GoToModificar(View view){
        Intent ActivityModificar = new Intent(this, CrudUpdate.class);
        startActivity(ActivityModificar);
    }

    public void GoToBuscar (View view){
        Intent ActivityBuscar = new Intent(this, CrudSelect.class);
        startActivity(ActivityBuscar);
    }

    public void GoToEliminar (View view){
        Intent ActivityEliminar = new Intent(this, CrudDelete.class);
        startActivity(ActivityEliminar);
    }

    public void GoToLogin(View view) {
        Intent ActivityLogin = new Intent(this, MainActivity.class);
        startActivity(ActivityLogin);
    }


}