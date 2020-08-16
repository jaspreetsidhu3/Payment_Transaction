package com.example.paymenttransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetailActivity extends AppCompatActivity {
private TextView textdetail;
    StringBuffer stringBuffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textdetail=findViewById(R.id.detailtext);
        String name=getIntent().getExtras().getString("detail",null);
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        try {
            Toast.makeText(getApplicationContext(),""+name,Toast.LENGTH_SHORT).show();
            assert name != null;
            File file=new File(name);
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            stringBuffer=new StringBuffer();
            String text=null;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text).append("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textdetail.setText(stringBuffer);
   }
}