package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;
        import android.content.Context;
        import android.os.Handler;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

public class ActivitySecundaria extends AppCompatActivity implements View.OnClickListener {
    ProgressBar Pbar;
    private final String TAG = "EVENTOS";
    Button btnProcesar;
    String mensaje =" Usted seleciono: ";
    AutoCompleteTextView ACTAnimal;
    AutoCompleteTextView ACTFruta;
    AutoCompleteTextView ACTLenguaje;
    TextView porcentaje;
    String [] fruta={"Manzana", "Pera", "Uva", "Piña", "Fresa", "Naranja", "Sandia", "Melon"};
    String [] animal={"León", "Jirafa", "Oso", "Tigre", "Mono", "Perro", "Gato", "Humano"};
    String [] lenguaje={"C#", "C++", "Java", "Ruby", "C", "Python", "JavaScript", "Php"};
    private int mProgressStatus = 0;
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
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
        porcentaje=findViewById(R.id.porcentaje);
        btnProcesar=findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnProcesar: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mProgressStatus < 100){
                            mProgressStatus++;
                            android.os.SystemClock.sleep(50);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Pbar.setProgress(mProgressStatus);
                                    porcentaje.setText(mProgressStatus + " %");
                                }
                            });
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ActivitySecundaria.this,mensaje+ ACTFruta.getText().toString()+"\n"
                                        +mensaje+ ACTAnimal.getText().toString()+"\n"
                                        +mensaje+ ACTLenguaje.getText().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();
            }
            break;
        }
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando evento onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando evento onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando evento onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando evento onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando evento onDestroy");
    }
}
