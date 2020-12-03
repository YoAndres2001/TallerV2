package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String correo = "admin@empresa.com";
    String clave = "admin123";
    EditText edtMain_email;
    EditText edtMain_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMain_email = findViewById(R.id.edtMain_email);
        edtMain_password = findViewById(R.id.edtMain_password);

    }


    public void GoToIndex (View view){

        if (correo.equals(edtMain_email.getText().toString()) && clave.equals(edtMain_password.getText().toString())) {
            Intent ActivityirgotoIndexadmin = new Intent(this, IndexAdmin.class);
            startActivity(ActivityirgotoIndexadmin);
            Toast.makeText(this, "Bienvenido al home", Toast.LENGTH_LONG).show();

        } else {
            Intent Activityirgotocrudindex = new Intent(this, CrudIndex.class);
            startActivity(Activityirgotocrudindex);
            
            //GestorBD gestor = new GestorBD(this, "Tasks", null, 1);
            //SQLiteDatabase db = gestor.getWritableDatabase();

            //String email = edtMain_email.getText().toString();


            //Cursor datos = db.rawQuery("select email from users where email =" + email, null);
            //if (datos.moveToFirst()){
                //edtMain_email.setText("");
                //startActivity(Activityirgotocrudindex);
                //db.close();
            //}else{
                //Toast.makeText(this, "No existen registros asociados a este id", Toast.LENGTH_SHORT).show();
            //}

            //db.close();
        }
    }



    public void GoToRegistrar (View view){
        Intent ActivityirRegistrar = new Intent(this, CreateUser.class);
        startActivity(ActivityirRegistrar);
    }


}