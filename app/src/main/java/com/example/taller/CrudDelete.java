package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CrudDelete extends AppCompatActivity {
    EditText edtDetalle_id;
    TextView txtDetalle_nametarea;
    TextView txtDetalle_id_usuario;
    TextView txtDetalle_descripcion;
    TextView txtDetalle_prioridad;
    TextView txtDetalle_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_delete);

        edtDetalle_id  = (EditText) findViewById(R.id.edtDetalle_id);
        txtDetalle_nametarea  = (TextView) findViewById(R.id.txtDetalle_nametarea);
        txtDetalle_id_usuario  =  (TextView)findViewById(R.id.txtDetalle_id_usuario);
        txtDetalle_descripcion  = (TextView)findViewById(R.id.txtDetalle_descripcion);
        txtDetalle_prioridad  = (TextView)findViewById(R.id.txtDetalle_prioridad);
        txtDetalle_estado  = (TextView)findViewById(R.id.txtDetalle_estado);
    }

    public void EliminarTarea(View view){
        GestorBD gestor = new GestorBD(this, "Tasks", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();

        if (!id.isEmpty()){
            int filas = db.delete("tasks", "id=" + id,null);

            if (filas == 1){
                Toast.makeText(this, "Se ha eliminado la tarea", Toast.LENGTH_LONG).show();
                db.close();
                txtDetalle_nametarea.setText("Nombre de Tarea: ");
                txtDetalle_id_usuario.setText("Id de usuario: ");
                txtDetalle_descripcion.setText("Descipción de Tarea:");
                txtDetalle_prioridad.setText("Prioridad: ");
                txtDetalle_estado.setText("Estado: ");
            }else {
                Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        }
        db.close();
    }



    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, CrudIndex.class);
        startActivity(Cancelar);
    }

}