package co.edu.unab.misiontic2022.miingresoseguroapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unab.misiontic2022.miingresoseguroapp.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    CircleImageView mcircleImageViewBack;
    TextInputEditText mTextInputNombreCompletoRegistro;
    TextInputEditText mTextInputEmailRegistro;
    TextInputEditText mTextInputPasswordRegistro;
    TextInputEditText mTextInputPasswordRegistroConfirmacion;
    Button mButtonRegistro;
    FirebaseAuth  mAuth;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mcircleImageViewBack = findViewById(R.id.circleimageback);
        mTextInputNombreCompletoRegistro.findViewById(R.id.TextViewInputNombreCompletoRegistro);
        mTextInputEmailRegistro.findViewById(R.id.TextViewInputEmailRegistro);
        mTextInputPasswordRegistro.findViewById(R.id.TextViewInputPasswordRegistro);
        mTextInputPasswordRegistroConfirmacion.findViewById(R.id.TextViewInputPasswordRegistroConfirmación);
        mButtonRegistro.findViewById(R.id.btnRegistro);

        mAuth= FirebaseAuth.getInstance();
        mFirestore= FirebaseFirestore.getInstance();


      /*  mcircleImageViewBack.setOnClickListener(view -> finish());*/

        mcircleImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /*mButtonRegistro.setOnClickListener(view -> register());*/
        mButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register() {
        String nombrecompletoregistro = Objects.requireNonNull(mTextInputNombreCompletoRegistro.getText()).toString();
        String email = Objects.requireNonNull(mTextInputEmailRegistro.getText()).toString();
        String password = Objects.requireNonNull(mTextInputPasswordRegistro.getText()).toString();
        String confirmacionpassword = Objects.requireNonNull(mTextInputPasswordRegistroConfirmacion.getText()).toString();

        if (!nombrecompletoregistro.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmacionpassword.isEmpty()) {
            if (isEmailValid(email)) {
                if(password.equals(confirmacionpassword)){
                    if(password.length()>=6){
                        createUser(nombrecompletoregistro,email,password);
                    }else {
                        Toast.makeText(this, "Las contraseñas deben tener minimo seis(6) caracteres", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Correo ingresado Invalido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Datos Imcompletos", Toast.LENGTH_SHORT).show();
        }
    /* CTRL + ALT + L -> Organizar Codigo */
    }

    private void createUser(final String nombrecompletoregistro, final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                String id=mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("Nombre Completo", nombrecompletoregistro);
                map.put("email", email);
                map.put("password", password);
                mFirestore.collection("Users").document(id).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Usuario almacenado correctamnte", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "No fue posible almacenar usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RegisterActivity.this, "Registro incompleto", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}