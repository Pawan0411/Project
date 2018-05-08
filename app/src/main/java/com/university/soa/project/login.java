package com.university.soa.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * @author Mohit Agarwal
 * @version Created on 08-05-2018.
 */

public class login extends AppCompatActivity {
    TextView user,password;
    String student;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg=user.getText().toString().trim();
                String pass=password.getText().toString().trim();
                try {
                    student= new API().execute(reg, pass).get();
                } catch (InterruptedException e) {
                    //handle exception accordingly
                } catch (ExecutionException e) {
                    //handle exception accordingly
                }
                finally {
                    // string student contain name of the student
                    // do something with string student here
                }

            }
        });

    }

}
