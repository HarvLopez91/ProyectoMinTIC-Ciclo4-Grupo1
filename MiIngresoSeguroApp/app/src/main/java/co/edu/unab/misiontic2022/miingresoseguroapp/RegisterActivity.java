package co.edu.unab.misiontic2022.miingresoseguroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    CircleImageView mcircleImageViewBack;
    TextInputEditText mTextInputNombreCompletoRegistro;
    TextInputEditText mTextInputEmailRegistro;
    TextInputEditText mTextInputPasswordRegistro;
    TextInputEditText mTextInputPasswordRegistroConfirmacion;
    Button mButtonRegistro;

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
        mcircleImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();
            }
        });


    }

    private void registro() {
        String nombrecompletoregistro = mTextInputNombreCompletoRegistro.getText().toString();
        String email = mTextInputEmailRegistro.getText().toString();
        String password = mTextInputPasswordRegistro.getText().toString();
        String confirmacionpassword = mTextInputPasswordRegistroConfirmacion.getText().toString();

        if (!nombrecompletoregistro.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmacionpassword.isEmpty()) {
            if (isEmailValid(email)) {
                Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Correo ingresado Invalido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Datos Imcompletos", Toast.LENGTH_SHORT).show();
        }
    /* CTRL + ALT + L -> Organizar Codigo */
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}