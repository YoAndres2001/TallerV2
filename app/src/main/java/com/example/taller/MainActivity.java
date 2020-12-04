package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String correo = "admin@empresa.com";
    String clave = "clave";
    EditText email, pass;
    Button login, registrarse;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.edtMain_email);
        pass=(EditText)findViewById(R.id.edtMain_password);
        login=(Button)findViewById(R.id.bttGotoIndex);
        registrarse=(Button)findViewById(R.id.bttGotoRegistrar);
        dao=new daoUsuario(this);

        login.setOnClickListener(this);
        registrarse.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bttGotoIndex:
                String em=email.getText().toString();
                String pas=pass.getText().toString();
                if(em.equals("")&&pas.equals("")){
                    Toast.makeText(this,"Los campos están vacios",Toast.LENGTH_LONG).show();
                } else if(dao.login(em,pas)==1) {
                    Usuario ux=dao.getUsuario(em,pas);
                    Toast.makeText(this,"Bienvenido a la app", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(MainActivity.this, CrudIndex.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                } else if (em.equals(correo)&&pas.equals(clave)){
                    Toast.makeText(this, "Bienvenido administrador", Toast.LENGTH_LONG).show();
                    Intent i3=new Intent(MainActivity.this,IndexAdmin.class);
                    startActivity(i3);
                } else {
                    Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.bttGotoRegistrar:
                Intent i=new Intent(MainActivity.this,CreateUser.class);
                startActivity(i);
                break;
        }

    }
    
}