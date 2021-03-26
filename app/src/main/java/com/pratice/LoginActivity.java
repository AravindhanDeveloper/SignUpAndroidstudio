package com.pratice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.login_page);
    TextView signUpOpen= findViewById(R.id.signUpButton);
    signUpOpen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         OpenSignUp();
        }
    });

    }
//    Intent-->>> object
    public void OpenSignUp(){
        Intent intent= new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}
