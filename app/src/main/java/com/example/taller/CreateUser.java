package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity {
    EditText edtcreateid, edtcreateemail, edtcreatepass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        edtcreateid = findViewById(R.id.edtcreateid);
        edtcreateemail = findViewById(R.id.edtcreateemail);
        edtcreatepass = findViewById(R.id.edtcreatepass);
    }

    public void CrearCuenta(View view){
        GestorBD gestor = new GestorBD(this, "Tasks", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtcreateid.getText().toString();
        String email = edtcreateemail.getText().toString();
        String password = edtcreatepass.getText().toString();

        if (!id.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            ContentValues fila = new ContentValues();

            fila.put("id", id);
            fila.put("email", email);
            fila.put("password", password);

            db.insert("users", null, fila);
            db.close();

            Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();

            edtcreateid.setText("");
            edtcreateemail.setText("");
            edtcreatepass.setText("");

        }else {
            Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }


    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, MainActivity.class);
        startActivity(Cancelar);
    }
}