package com.example.vijaya.androidhardware;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StorageActivity extends AppCompatActivity {
    EditText txt_content;
    EditText contenttoDisplay;
    Button btn_save;
    Button btn_display;
    String FILENAME = "MyAppStorage";
    String ret;
    static final String DEBUGTAG = "JWP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        txt_content = (EditText) findViewById(R.id.id_txt_mycontent);
        contenttoDisplay = (EditText) findViewById(R.id.id_txt_display);
        btn_save = (Button) findViewById(R.id.id_btn_save);
        btn_display = (Button) findViewById(R.id.id_btn_display);
    }

    public void saveTofile(View v) throws IOException {

      btn_save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String text = txt_content.getText().toString();
              FileOutputStream fos = null;
              try{
                   fos = openFileOutput(FILENAME, Context.MODE_APPEND);
                  fos.write(text.getBytes());
                  fos.close();
              }catch (Exception e){
                  Log.d(DEBUGTAG, "unable to save file");
              }
          }
      });  // ICP Task4: Write the code to save the text

    }

    public void retrieveFromFile(View v) throws IOException {
        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fis =null;
                try {
                    fis = openFileInput(FILENAME);
                    InputStreamReader inputStreamReader = new InputStreamReader(fis);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((receiveString = bufferedReader.readLine())!= null){
                        stringBuilder.append(receiveString);
                    }
                    fis.close();
                    ret = stringBuilder.toString();
                    contenttoDisplay.setText(ret);
                    contenttoDisplay.setVisibility(View.VISIBLE);


                    contenttoDisplay.setText(txt_content.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        // ICP Task4: Write the code to display the above saved text

    }
}
