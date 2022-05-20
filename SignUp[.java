package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText Username,Password;
    Button Signupbtn;
    String usnme,psswd;
    String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username=(EditText)findViewById(R.id Username);
        Password=(EditText) findViewById(R.id Password);
        Signupbtn=(Button) findViewById(R.id Signupbtn);
        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usnme=Username.getText().toString();
                psswd=Password.getText().toString();

                if (validatePassword(psswd))
                {
                    Intent intent=new Intent((MainActivity.this,Signin.class));
                    Bundle bundle=new Bundle();
                    bundle.putString("username",usnme);
                    bundle.putString("password",psswd);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Inavalid password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean validatePassword(String psswd) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(psswd);
    }
}
