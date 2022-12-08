package co.edu.unab.misiontic2022.miingresoseguroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView mTextViewRegister;

    private final static String TAG = "CV_Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        mTextViewRegister=findViewById(R.id.textViewRegister);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                        Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    public void inicio(View view){
        startActivity(new Intent(this,EncuestaActivity.class));
    }
}