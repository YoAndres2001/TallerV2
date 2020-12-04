package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CrudSelect extends AppCompatActivity {


    EditText edtDetalle_id;
    TextView txtDetalle_nametarea;
    TextView txtDetalle_id_usuario;
    TextView txtDetalle_descripcion;
    TextView txtDetalle_prioridad;
    TextView txtDetalle_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_select);

        edtDetalle_id  = (EditText) findViewById(R.id.edtDetalle_id);
        txtDetalle_nametarea  = (TextView) findViewById(R.id.txtDetalle_nametarea);
        txtDetalle_id_usuario  =  (TextView)findViewById(R.id.txtDetalle_id_usuario);
        txtDetalle_descripcion  = (TextView)findViewById(R.id.txtDetalle_descripcion);
        txtDetalle_prioridad  = (TextView)findViewById(R.id.txtDetalle_prioridad);
        txtDetalle_estado  = (TextView)findViewById(R.id.txtDetalle_estado);
    }

    public void BuscarTarea(View view){
        GestorBD gestor = new GestorBD(this, "BDUsuarios", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();


        Cursor datos = db.rawQuery("select user_id, title, description, priority, state from tasks where id =" + id, null);
        if (datos.moveToFirst()){

            txtDetalle_nametarea.setText(datos.getString(1).toString());
            txtDetalle_id_usuario.setText(datos.getString(0).toString());
            txtDetalle_descripcion.setText(datos.getString(2).toString());
            txtDetalle_prioridad.setText(datos.getString(3).toString());
            txtDetalle_estado.setText(datos.getString(4).toString());


            edtDetalle_id.setText("");
            db.close();
        }else{
            Toast.makeText(this, "No existen registros asociados a este id", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, CrudIndex.class);
        startActivity(Cancelar);
    }


}