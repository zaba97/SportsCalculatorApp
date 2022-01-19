package com.machine.calculatorbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi_table extends AppCompatActivity {
    EditText weight, height, age;
    TextView resultText;
    TextureView result;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_table);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        resultText = findViewById(R.id.result);

        Button changeActivityBTN = findViewById(R.id.button);

        changeActivityBTN.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                changeActivity();
            }

        });
    }

    private void changeActivity() {
        Intent intent = new Intent(this, bmi_table.class);
        startActivity(intent);
    }

    public void calculateBMI(View view) {
        String S1=weight.getText().toString();
        String S2=height.getText().toString();

        float weightValue=Float.parseFloat(S1);
        float heightValue=Float.parseFloat(S2) / 100;
        float bmi = weightValue / (heightValue * heightValue);
        if (bmi < 16){
            BMIresult = "Lekka niedowaga";
        }
        else if(bmi <15.5) {
            BMIresult = "Niedowaga";
        }
        else if(bmi > 18.8 && bmi <= 24.9){
            BMIresult = "BMI w normie";
        }
        else if (bmi >= 25.5 && bmi <= 29.9) {
            BMIresult = "Nadwaga";
        }
        calculation = "Twoje BMI wynosi: " + bmi +"\n";
        resultText.setText(calculation);
    }

    public void calculateBMR(View view) {
        String S1=weight.getText().toString();
        String S2=height.getText().toString();
        String S3=age.getText().toString();

        double weightValue=Float.parseFloat(S1);
        double heightValue=Float.parseFloat(S2);
        double ageValue = Float.parseFloat(S3);
        double bmr = (66 + ((13.7 * weightValue) + (5.0 * heightValue)) - (6.8 * ageValue));

        calculation = "Twoje BMR wynosi: " + bmr +"\n";
        resultText.setText(calculation);
    }


}
