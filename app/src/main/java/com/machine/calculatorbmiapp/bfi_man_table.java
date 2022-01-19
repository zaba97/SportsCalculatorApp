package com.machine.calculatorbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bfi_man_table extends AppCompatActivity {
    EditText weight, height, waist;
    TextView resultText;
    TextureView result;
    String calculation, BFIresult;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfi_man_table);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        waist = findViewById(R.id.waist);
        resultText = findViewById(R.id.result);

        Button changeActivityBFI = findViewById(R.id.button);

        changeActivityBFI.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                changeActivity();
            }
        });
    }

            private void changeActivity() {
                Intent intent = new Intent(this, bfi_man_table.class);
                startActivity(intent);
            }

            public void calculateBFI(View view) {
                String S1 = weight.getText().toString();
                String S2 = height.getText().toString();
                String S3 = waist.getText().toString();

                double weightValue = Float.parseFloat(S1);
                double heightValue = Float.parseFloat(S2);
                double waistValue = Float.parseFloat(S3);
                double a = (4.15 * waistValue);
                double b = (a / 2.54);
                double c = (0.082 * weightValue);
                double d = (b - c - 98.42);
                double e = (weightValue * 2.2);
                double bfi = (d / e * 100);

                calculation = "Twoje BFI wynosi " + bfi + " %" + "\n";
                resultText.setText(calculation);
            }
        }