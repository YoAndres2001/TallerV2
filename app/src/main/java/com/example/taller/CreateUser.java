package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity implements View.OnClickListener {
    //EditText edtcreateid, edtcreateemail, edtcreatepass;
    EditText id,em,pas;
    Button reg,can;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        em=(EditText)findViewById(R.id.edtcreateemail);
        pas=(EditText)findViewById(R.id.edtcreatepass);
        reg=(Button)findViewById(R.id.bttRegistra);
        can=(Button)findViewById(R.id.bttcancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoUsuario(this);

        //edtcreateid = findViewById(R.id.edtcreateid);
        //edtcreateemail = findViewById(R.id.edtcreateemail);
        //edtcreatepass = findViewById(R.id.edtcreatepass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bttRegistra:
                Usuario u=new Usuario();
                u.setEmail(em.getText().toString());
                u.setPassword(pas.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"Los campos están vacios",Toast.LENGTH_LONG).show();
                } else if (dao.InsertarUsuario(u)) {
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(CreateUser.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.bttcancelar:
                Intent i=new Intent(CreateUser.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}