package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    ProgressBar Pbar;
    Button btnProcesar;
    String mensaje =" Usted seleciono: ";
    AutoCompleteTextView ACTAnimal;
    AutoCompleteTextView ACTFruta;
    AutoCompleteTextView ACTLenguaje;
    String [] fruta={"Manzana", "Pera", "Uva", "Piña", "Fresa", "Naranja", "Sandia", "Melon"};
    String [] animal={"León", "Jirafa", "Oso", "Tigre", "Mono", "Perro", "Gato", "Humano"};
    String [] lenguaje={"C#", "C++", "Java", "Ruby", "C", "Python", "JavaScript", "Php"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("HS16-I04-001");
        }
        ACTFruta=findViewById(R.id.ACTFruta);
        ACTAnimal=findViewById(R.id.ACTAnimal);
        ACTLenguaje=findViewById(R.id.ACTLenguaje);
        ArrayAdapter<String> adapterF=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fruta);
        ArrayAdapter<String> adapterA=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);
        ArrayAdapter<String> adapterL=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, lenguaje);
        ACTFruta.setThreshold(1);
        ACTFruta.setAdapter(adapterF);
        ACTAnimal.setThreshold(1);
        ACTAnimal.setAdapter(adapterA);
        ACTLenguaje.setThreshold(1);
        ACTLenguaje.setAdapter(adapterL);
        Pbar=findViewById(R.id.Pbar);
        btnProcesar=findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(this);
    }
    private void setProgressValue(final int progress){
        Pbar.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);

            }
        });
        thread.start();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnProcesar:
                setProgressValue(0);
                Toast.makeText(this,mensaje+ ACTFruta.getText().toString() , Toast.LENGTH_LONG).show();
                Toast.makeText(this,mensaje+ ACTAnimal.getText().toString() , Toast.LENGTH_LONG).show();
                Toast.makeText(this,mensaje+ ACTLenguaje.getText().toString() , Toast.LENGTH_LONG).show();
                break;
        }
    }
}
