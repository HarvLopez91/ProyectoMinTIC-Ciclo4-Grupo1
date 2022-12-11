package co.edu.unab.misiontic2022.miingresoseguroapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import co.edu.unab.misiontic2022.miingresoseguroapp.R;


public class MainActivity extends AppCompatActivity {

    TextView mTextViewRegister;
    TextInputEditText mTextViewInputEmail;
    TextInputEditText  mTextViewInputPassword;
    Button mButtonLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewRegister=findViewById(R.id.textViewRegister);
        mTextViewInputEmail=findViewById(R.id.TextViewInputEmail);
        mTextViewInputPassword=findViewById(R.id.TextViewInputPassword);
        mButtonLogin=findViewById(R.id.btnIniciarSesion);

        mAuth = FirebaseAuth.getInstance();

        mTextViewRegister.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        mButtonLogin.setOnClickListener(view -> login());
    }

    private void login() {
        String email= Objects.requireNonNull(mTextViewInputEmail.getText()).toString();
        String password= Objects.requireNonNull(mTextViewInputPassword.getText()).toString();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(MainActivity.this, "El email y la contraseña no son correctos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.d("Campo","email"+email);
        Log.d("Campo","password"+password);

    }
}