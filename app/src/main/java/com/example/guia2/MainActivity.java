package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    EditText edtContraseña, edtCorreo;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        edtCorreo = findViewById(R.id.edtCorreo);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciarSesion: {
                if (edtCorreo.getText().toString().isEmpty()) {
                    Toast.makeText(this, "¡Campo correo electronico vacio!", Toast.LENGTH_LONG).show();
                } else {
                    if (edtContraseña.getText().toString().isEmpty()) {
                        Toast.makeText(this, "¡Campo contraseña vacia!", Toast.LENGTH_LONG).show();
                    } else {
                        Intent in = new Intent(this, Activity2.class);
                        startActivity(in);
                    }
                }
            }
            break;
        }
        return false;
    }
}
