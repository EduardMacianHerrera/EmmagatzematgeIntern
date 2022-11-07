package com.example.emmagatzematgeintern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText campo = findViewById(R.id.editTextTextPersonName);
        Button boton = findViewById(R.id.button);
        File ruta = new File(this.getFilesDir(),"dades.txt");

        try {
            Scanner scanner = new Scanner(ruta);
            while (scanner.hasNextLine()){
                campo.setText(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable texto = campo.getText();
                try {
                    FileWriter writer = new FileWriter(ruta);
                    writer.write(String.valueOf(texto));
                    writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }



}