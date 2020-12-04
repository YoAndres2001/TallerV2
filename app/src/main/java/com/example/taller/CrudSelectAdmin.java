package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CrudSelectAdmin extends AppCompatActivity {
    EditText edtDetalle_email;

    ListView lista;
    ArrayList<String> Lista;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_select_admin);

        edtDetalle_email  = (EditText) findViewById(R.id.edtDetalle_email);
        lista = (ListView) findViewById(R.id.lista);


    }

    public void BuscarEmpleado(View view){
        GestorBD gestor = new GestorBD(this, "BDUsuarios", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String email = edtDetalle_email.getText().toString();


        Cursor datos = db.rawQuery("SELECT u.email, title FROM tasks t JOIN usuario u\n" +
                "on(t.user_id = u.id) where u.email =" + email, null);
        if (datos.moveToFirst()){
            Lista.add(datos.getString(0).toString());
            lista.setAdapter(adapter);

            edtDetalle_email.setText("");
            db.close();
        }else{
            Toast.makeText(this, "No existen registros asociados a este email", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, IndexAdmin.class);
        startActivity(Cancelar);
    }
}