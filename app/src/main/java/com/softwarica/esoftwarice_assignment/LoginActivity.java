package com.softwarica.esoftwarice_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals("softwarica") && etPassword.getText().toString().equals("coventry")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }

                else if
                (TextUtils.isEmpty(etUsername.getText())) {
                    etUsername.setError("Please enter username.");
                    return;
                }

                else if
                (TextUtils.isEmpty(etPassword.getText())) {
                    etPassword.setError("Please enter password.");
                    return;
                }

                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Username or Password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
