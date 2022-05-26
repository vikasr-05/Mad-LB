package com.example.prgm3_4mt20cs401;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username,password;
    Button signinBtn;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String uname=  bundle.getString("username");
        String pass =  bundle.getString("password");


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signinBtn = findViewById(R.id.signinbtn);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<2) {
                    String signinuname = username.getText().toString();
                    String signinpass = password.getText().toString();

                    if (uname.equals(signinuname) && pass.equals(signinpass)){
                        Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, loginSuccessful.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                        count++;
                    }

                } else {
                    Toast.makeText(getApplicationContext(),"Too Many Attempts",Toast.LENGTH_SHORT).show();
                    signinBtn.setEnabled(false);
                }


            }
        });

    }
}
