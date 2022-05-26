package com.example.prgm3_4mt20cs401;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signUpBtn = findViewById(R.id.signupbtn);

        String regex = "^(?=.*[0-9])"
                        +"(?=.*[a-z])(?=.*[A-Z])"
                        +"(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regex);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=username.getText().toString();
                String pass=password.getText().toString();

                Matcher matcher = pattern.matcher(pass);
                if((uname.length()==0) || pass.length()==0) {
                    Toast.makeText(getApplicationContext(),"usernmae or password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    if(matcher.matches()) {
                        Intent intent = new Intent(MainActivity.this, login.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username", uname);
                        bundle.putString("password", pass);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Password pattern is not Proper", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
