package co.edu.unab.misiontic2022.miingresoseguroapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import co.edu.unab.misiontic2022.miingresoseguroapp.EncuestaActivity;
import co.edu.unab.misiontic2022.miingresoseguroapp.R;
import co.edu.unab.misiontic2022.miingresoseguroapp.RegisterActivity;


public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    TextView mTextViewRegister;
    TextInputEditText mTextViewInputEmail;
    TextInputEditText mTextViewInputPassword;
    Button mButtonIniciarSesion;
    private final static String TAG = "CV_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Log.d(TAG, "onCreate");*/
        setContentView(R.layout.activity_main);

        mTextViewRegister = findViewById(R.id.textViewRegister);
        mTextViewInputEmail = findViewById(R.id.TextViewInputEmail);
        mTextViewInputPassword = findViewById(R.id.TextViewInputPassword);
        mButtonIniciarSesion = findViewById(R.id.btnIniciarSesion);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new
                        Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mButtonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

    }

    private void iniciarSesion() {
        String email=mTextViewInputEmail.getText().toString();
        String password=mTextViewInputPassword.getText().toString();
        Log.d("Campo", "email"+email);
        Log.d("Campo", "password"+password);
    }


/*    public void inicio(View view){
        startActivity(new Intent(this, EncuestaActivity.class));
    }*/
}