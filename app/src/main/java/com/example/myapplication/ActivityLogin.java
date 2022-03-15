package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {
    private EditText editName, editEmail, editPhone;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        btnLogin.setOnClickListener(view -> {
            Login();
        });
    }

    private void initUI() {
        editName = findViewById(R.id.name);
        editEmail = findViewById(R.id.email);
        editPhone = findViewById(R.id.phone);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void Login() {
        String strName = editName.getText().toString();
        String strEmail = editEmail.getText().toString();
        String strPhone = editPhone.getText().toString();
        Info info = new Info(strName, strEmail, strPhone);
        Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", info);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}