package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class FormActivity extends AppCompatActivity {

    Button loginButton;
    Button signupButton;
    EditText email;
    EditText password;
    boolean validate = false;

    ArrayList<String> emailList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == SignUpActivity.RESULT_OK) {
            if (Objects.requireNonNull(data.getExtras()).containsKey("email")) {
                emailList.add(data.getStringExtra("email"));
            }
            if (Objects.requireNonNull(data.getExtras()).containsKey("password")) {
                passwordList.add(data.getStringExtra("password"));
            }
        }
    }

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
                for (int i = 0; i < emailList.size(); i++) {
                    if (email.getText().toString().equals(emailList.get(i).toString()) && password.getText().toString().equals(passwordList.get(i).toString())) {
                        validate = true;
                    }
                }

                if (validate) {
                    validate = false;
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
                startActivityForResult(intent, 2);
            }
        });


    }


}
