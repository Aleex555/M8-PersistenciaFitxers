package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellidos;
    private EditText email;
    private EditText telefono;



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Button guardar = (Button) findViewById(R.id.button1);
                nombre = findViewById(R.id.nombre);
                apellidos = findViewById(R.id.apellidos);
                email = findViewById(R.id.mail);
                telefono = findViewById(R.id.telf);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String contacto = nombre.getText().toString() + ";" + apellidos.getText().toString() + ";" +telefono.getText().toString()+ ";" + email.getText().toString()  + "\n";
                        try {
                            FileOutputStream fos = openFileOutput("contactos.txt", MODE_APPEND);
                            File fis = getDir("contactos.txt", MODE_APPEND);
                            fos.write(contacto.getBytes());
                            fos.close();

                            Toast.makeText(MainActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "No se ha podido guardar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}