package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Key;

public class Signin extends AppCompatActivity {
    EditText UserName,password;
    Button Signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        UserName=(EditText)findViewById(R.id.UserName);
        password=(EditText) findViewById(R.id.password);
        Signin=(Button) findViewById(R.id.Signin);

        Bundle bundle=getIntent().getExtras();

        String usnme=bundle.getString("Username");
        String pwd=bundle.getString("password");
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User=UserName.getText().toString();
                String pass=password.getText().toString();
                if(User.equals(usnme)&&pass.equals(pwd))
                {
                    Toast.makeText(Signin.this, "success", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Signin.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
