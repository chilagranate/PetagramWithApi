package com.chila.mascotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfCtaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_cta);

    }

    public void guardarConfigCta(View v){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        EditText text;
        text = findViewById(R.id.nueva_cuenta);

        String nombreUsuario = text.getText().toString();

        editor.putString("usuario",nombreUsuario);
        editor.commit();

        finish();



    }
}
