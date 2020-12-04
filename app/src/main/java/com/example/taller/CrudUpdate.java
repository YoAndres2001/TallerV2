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

public class CrudUpdate extends AppCompatActivity {
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
        setContentView(R.layout.activity_crud_update);

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

    public void ModificarTarea(View view){
        GestorBD gestor = new GestorBD(this, "BDUsuarios", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = editText_CrudID.getText().toString();
        String id_usuario = editText_CrudID_Usuario.getText().toString();
        String nombre = editText_CrudNombre.getText().toString();
        String descripcion = editText_CrudDescripcion.getText().toString();
        String prioridad = idSpinnerPrioridad.getSelectedItem().toString();
        String estado = idSpinnerEstado.getSelectedItem().toString();

        ContentValues fila = new ContentValues();

        fila.put("id", id);
        fila.put("user_id", id_usuario);
        fila.put("title", nombre);
        fila.put("description", descripcion);
        fila.put("priority", prioridad);
        fila.put("state", estado);

        if (!id.isEmpty() && !id_usuario.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !prioridad.isEmpty() && !estado.isEmpty()){
            int filas = db.update("tasks", fila, "id=" + id, null);

            if (filas == 1){
                Toast.makeText(this, "La tarea se actualizo correctamente", Toast.LENGTH_SHORT).show();
                db.close();

                editText_CrudID.setText("");
                editText_CrudID_Usuario.setText("");
                editText_CrudNombre.setText("");
                editText_CrudDescripcion.setText("");
                idSpinnerPrioridad.getSelectedItem();
                idSpinnerEstado.getSelectedItem();
            }
            else {
                Toast.makeText(this, "ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        }

        db.close();
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, CrudIndex.class);
        startActivity(Cancelar);
    }
}