package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    Button registerButton;
    EditText email;
    EditText password;
    EditText retypedPassword;

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        registerButton = findViewById(R.id.register);
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        retypedPassword = findViewById(R.id.password3);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid(email.getText().toString()) && password.getText().toString().equals(retypedPassword.getText().toString())) {
                    Intent intent = new Intent(SignUpActivity.this, FormActivity.class);
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                } else if (isEmailValid(email.getText().toString()) && !password.getText().toString().equals(retypedPassword.getText().toString())) {
                    Toast.makeText(SignUpActivity.this, "Those passwords don't match...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Somehow everything you typed is wrong, are you messing with me?", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
