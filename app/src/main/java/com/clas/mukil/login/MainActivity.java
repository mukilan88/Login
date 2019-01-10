package com.clas.mukil.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// class created for each palettes used
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
//over writing the process
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//class name above is inserted to palette id name in the layout
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.textView);
        Login =(Button)findViewById(R.id.btnLogin);
        Info.setText("No of Attempts Remaining:  5");//setting the number to show in the screen
        /* TODO: button onclick function */
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                validate(Name.getText().toString(), Password.getText().toString());
                }
            });
        }
        /* TODO: using of simple if condition check name and password go to next page */
        private void validate(String userName, String userPassword){
            if((userName.equals("admin")) && (userPassword.equals("1234"))){
            Intent i =  new Intent(MainActivity.this, Nextpage.class);
            startActivity(i);
        }else {
            counter--;
            Info.setText("No of Attempts Remaining:  " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
