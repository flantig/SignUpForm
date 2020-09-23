package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    Button loginButton;
    Button signupButton;
    EditText email;
    EditText password;
    boolean validate = false;

    ArrayList[][] users = new ArrayList[10][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginButton = findViewById(R.id.login);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < users.length; i++) {
                    if (email.getText().toString().equals(users[i][0].toString()) && password.getText().toString().equals(users[i][1].toString())) {
                            validate = true;
                    }
                }

                if(validate){
                    Intent intent = new Intent(FormActivity.this, UserPageActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(FormActivity.this, "That's the wrong email or password... ", Toast.LENGTH_LONG).show();
                }
            }
        });

        signupButton = findViewById(R.id.signup);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }


}
