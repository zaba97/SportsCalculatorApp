package com.machine.calculatorbmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmr_table extends AppCompatActivity {
    EditText weight, height, age;
    TextView resultText;
    TextureView result;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_table);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        resultText = findViewById(R.id.result);
        Button changeActivityBTN = findViewById(R.id.button);

        changeActivityBTN.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
            }

        });
    }

    private void changeActivity() {
        Intent intent = new Intent(this, bmi_table.class);
        startActivity(intent);
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
