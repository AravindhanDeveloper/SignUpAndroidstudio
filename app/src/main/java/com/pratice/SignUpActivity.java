package com.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
EditText emailTxt,passwordTxt,confirmPassword;
TextView errorTxt,sucessTxt;
Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_page);

        
 emailTxt=findViewById(R.id.emailTxt);
 passwordTxt=findViewById(R.id.passwordTxt);
 confirmPassword=findViewById(R.id.confirmPassword);
 signUpButton=findViewById(R.id.signUpButton);
 errorTxt=findViewById(R.id.textinput_errorTxt);
 sucessTxt=findViewById(R.id.sucessTxt);
 signUpButton.setOnClickListener(new View.OnClickListener(){
     @Override
     public void onClick(View v){
         String email =emailTxt.getText().toString();
         String password =passwordTxt.getText().toString();
         String confirmPass =confirmPassword.getText().toString();
         String errorMsg="invalid email (or) password";
if(validEmail(email) & validPassword(password)& validConfirmPassword(password,confirmPass)){
//    Toast.makeText(MainActivity.this,"Sucess",Toast.LENGTH_LONG).show();
    resetError();
}else {
    setError(errorMsg);
}
     }
 });

// backgound start
Log.i("Lifecycle","onCreate()");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Lifecycle","onStart()");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Lifecycle","onResume()");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Lifecycle","onPause()");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Lifecycle","onStop()");

    }
//background end
    //    validation start
private boolean validEmail(String email){
      return   checkRegex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+", email);

}
private boolean validPassword(String password){
return checkRegex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$",password);
    }
private boolean validConfirmPassword(String actualpass,String confirmPass){
return actualpass.equals(confirmPass);
    }
private void setError(String errorMsg){
        errorTxt.setVisibility(View.VISIBLE);
        errorTxt.setText(errorMsg);
}
private void resetError(){
        errorTxt.setVisibility(View.INVISIBLE);
        errorTxt.setText("");
}
private boolean checkRegex(String patter,String input){
    Pattern r=Pattern.compile(patter);
    return r.matcher(input).matches();
}
}