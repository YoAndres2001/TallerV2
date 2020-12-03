package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndexAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_admin);
    }

    public void GoToSelectAdmin(View view){
        Intent ActivityBuscarAdmin = new Intent(this, CrudSelectAdmin.class);
        startActivity(ActivityBuscarAdmin);
    }

    public void GoToLogin(View view) {
        Intent ActivityLogin = new Intent(this, MainActivity.class);
        startActivity(ActivityLogin);
    }

}