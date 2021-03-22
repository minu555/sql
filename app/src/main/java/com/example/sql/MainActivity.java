package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etemail,etphone;
    Button btnAdd,btnView;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);



        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EName = etName.getText().toString();
                String Eemail = etemail.getText().toString();
                String Ephone = etphone.getText().toString();




                if(EName.length() != 0 && Eemail.length() != 0 && Ephone.length() != 0){
                    AddData(EName,Eemail,Ephone);

                    etName.setText("");
                    etemail.setText("");
                    etphone.setText("");

                }else{
                     if(etName.length()==0){
                        etName.requestFocus();
                        etName.setError("FIELD CANNOT BE EMPTY");

                    }
                    else if(etemail.length()==0){
                        etemail.requestFocus();
                        etemail.setError("FIELD CANNOT BE EMPTY");
                    }
                    else if(etphone.length()==0){
                        etphone.requestFocus();
                        etphone.setError("FIELD CANNOT BE EMPTY");

                    }



                }
            }
        });

    }

    public void AddData(String eName, String eemail, String ephone) {
        boolean insertData = myDB.addData(eName,eemail,ephone);
        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }


}
