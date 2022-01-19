package com.machine.calculatorbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView name, surname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BMI = findViewById(R.id.button);
        Button BMR = findViewById(R.id.button2);
        Button BFI_man = findViewById(R.id.button3);
        Button BFI_woman = findViewById(R.id.button4);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        Button add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String usersurname = surname.getText().toString();

                Intent intent = new Intent(MainActivity.this,name_surname.class);
                intent.putExtra("keyname", username);
                intent.putExtra("keyusername", usersurname);
                startActivity(intent);
            }
        });



        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMI();
            }

        });
        BMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMR();
            }
        });
        BFI_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BFI_man();
            }
        });
        BFI_woman.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BFI_woman();
            }
        });
    }

    private void BMI() {
        Intent intent = new Intent(this, bmi_table.class);
        startActivity(intent);
    }
    private void BMR() {
        Intent intent = new Intent(this, bmr_table.class);
        startActivity(intent);
    }
    private void BFI_man() {
        Intent intent = new Intent(this, bfi_man_table.class);
        startActivity(intent);
    }
    private void BFI_woman() {
        Intent intent = new Intent(this, bfi_woman_table.class);
        startActivity(intent);
    }

    }

