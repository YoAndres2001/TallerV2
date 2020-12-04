package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CrudInsert extends AppCompatActivity {

    TextView prioridad, estado;
    Spinner comboPrioridad, comboEstado;

    EditText editText_CrudID;
    EditText editText_CrudID_Usuario;
    EditText editText_CrudNombre;
    EditText editText_CrudDescripcion;
    Spinner idSpinnerPrioridad;
    Spinner idSpinnerEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_insert);


        prioridad= (TextView) findViewById(R.id.etiSelecionarprioridad);
        comboPrioridad= (Spinner) findViewById(R.id.idSpinnerPrioridad);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,
                R.array.combo_prioridad,android.R.layout.simple_spinner_item);
        comboPrioridad.setAdapter(adapter1);

        estado= (TextView) findViewById(R.id.etiSelecionarestado);
        comboEstado= (Spinner) findViewById(R.id.idSpinnerEstado);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,
                R.array.combo_estados,android.R.layout.simple_spinner_item);
        comboEstado.setAdapter(adapter2);


        editText_CrudID  = (EditText) findViewById(R.id.editText_CrudID);
        editText_CrudID_Usuario  = (EditText) findViewById(R.id.editText_CrudID_Usuario);
        editText_CrudNombre  =  (EditText)findViewById(R.id.editText_CrudNombre);
        editText_CrudDescripcion  = (EditText)findViewById(R.id.editText_CrudDescripcion);
        idSpinnerPrioridad  = (Spinner)findViewById(R.id.idSpinnerPrioridad);
        idSpinnerEstado  = (Spinner)findViewById(R.id.idSpinnerEstado);


    }

    public void RegistarTarea(View view){

        GestorBD gestor = new GestorBD(this, "BDUsuarios", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = editText_CrudID.getText().toString();
        String id_usuario = editText_CrudID_Usuario.getText().toString();
        String nombre = editText_CrudNombre.getText().toString();
        String descripcion = editText_CrudDescripcion.getText().toString();
        String prioridad = idSpinnerPrioridad.getSelectedItem().toString();
        String estado = idSpinnerEstado.getSelectedItem().toString();

        if (!id.isEmpty() && !id_usuario.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !prioridad.isEmpty() && !estado.isEmpty()){
            ContentValues fila = new ContentValues();

            fila.put("id", id);
            fila.put("user_id", id_usuario);
            fila.put("title", nombre);
            fila.put("description", descripcion);
            fila.put("priority", prioridad);
            fila.put("state", estado);

            db.insert("tasks", null, fila);
            db.close();

            Toast.makeText(this, "Tarea ingresado exitosamente", Toast.LENGTH_SHORT).show();

            editText_CrudID.setText("");
            editText_CrudID_Usuario.setText("");
            editText_CrudNombre.setText("");
            editText_CrudDescripcion.setText("");
            idSpinnerPrioridad.getSelectedItem();
            idSpinnerEstado.getSelectedItem();
        }else {
            Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, CrudIndex.class);
        startActivity(Cancelar);
    }
}