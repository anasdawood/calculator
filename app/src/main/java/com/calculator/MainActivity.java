package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextCurrentGrade ;
    EditText editTextGradeGoal ;
    EditText editTextWeightOdFinal ;
    TextView textViewRequired;
    Button calculate;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editTextCurrentGrade = findViewById(R.id.editTextCurrentGrade);
         editTextGradeGoal = findViewById(R.id.editTextGradeGoal);
         editTextWeightOdFinal = findViewById(R.id.editTextWeightOdFinal);
        textViewRequired = findViewById(R.id.textViewRequired);
        calculate = findViewById(R.id.calculate);
        calculate.setBackgroundResource(0);

    }

    public void calculate(View view) {

        if(editTextCurrentGrade.getText().toString().matches("") || editTextGradeGoal.getText().toString().matches("")
        || editTextWeightOdFinal.getText().toString().matches(""))
        {
            Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG).show();
            return;
        }

        Double current = Double.parseDouble(editTextCurrentGrade.getText().toString());
        Double goal = Double.parseDouble(editTextGradeGoal.getText().toString());
        Double weight = Double.parseDouble(editTextWeightOdFinal.getText().toString());
        Double required = (goal - ((1-(weight/100))*current))/weight;

        Double requiredDisplay = required*100;

        df2.setRoundingMode(RoundingMode.DOWN);
        textViewRequired.setText("To earn a(n)" + goal+"%, score a(n) "+ df2.format(requiredDisplay)+"%");

    }
}