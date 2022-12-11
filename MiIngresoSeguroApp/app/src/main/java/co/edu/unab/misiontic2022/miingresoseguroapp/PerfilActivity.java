package co.edu.unab.misiontic2022.miingresoseguroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PerfilActivity extends AppCompatActivity {
    private final static String TAG = "CV_Perfil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_perfil);
    }

    public void configUsuario(View view){
        startActivity(new Intent(this,ConfPerfilActivity.class));
    }
}