package co.edu.unab.misiontic2022.miingresoseguroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EncuestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
    }
    public void configUsuario(View view){
        startActivity(new Intent(this,ConfPerfilActivity.class));
    }
    public void Send(View view){startActivity(new Intent(this,MainActivity.class));
    }
}