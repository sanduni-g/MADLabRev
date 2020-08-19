package com.example.revlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddReading extends AppCompatActivity {

    TextView lblTitle, lblAuthor;
    EditText txtTitle, txtAuthor;
    Button buttonView;
    Intent intent;
    int flag;
    String title, author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reading);

        lblTitle = findViewById(R.id.lblTitle);
        lblAuthor = findViewById(R.id.lblAuthor);

        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);

        buttonView = findViewById(R.id.buttonView);

        intent= getIntent();
        flag = intent.getIntExtra("ToAddReading", -1);

        changeFragmnet();


    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = txtTitle.getText().toString();
                author = txtAuthor.getText().toString();
            }
        });
    }
    private void changeFragmnet(){
        if(flag == 1){
            lblAuthor.setText("Author: ");
            lblTitle.setText("Book Title: ");
            Fragment fragment1 ;
            fragment1 = new bookFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment1);
            ft.commit();
        }
        else{
            lblTitle.setText("Title of the Article: ");
            lblAuthor.setText("Editor: ");
            Fragment fragment2 ;
            fragment2 = new bookFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment2);
            ft.commit();
        }
    }

}
