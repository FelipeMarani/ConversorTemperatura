package com.inf2cm.conversordetemperatura;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    // declarando os objetos

    EditText mEditText;
    TextView mTextView;
    Button mButton;
    RadioButton mRadioButtonFah, mRadioButtonKel;
    //Functions/Métodos

    private boolean isEmptyValue(){
        return TextUtils.isEmpty(mEditText.getText().toString());
    }
    private double calculateFah(){
    double tempC = Double.parseDouble(mEditText.getText().toString());
    double tempF = (tempC * 9/5) + 32;
    return tempF;
    }
    private double calculateKel(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
        double tempK = tempC + 273.15;
        return tempK;
    }
    private String getResult(){
        String result;
        if (mRadioButtonKel.isChecked()){
            result = calculateKel() + " K";
        } else{
            result = calculateFah() + "  F";
        }
        return result;
    }
    private void showResult(){
        if (isEmptyValue()){
            Toast.makeText(this,"De a temperatura",Toast.LENGTH_SHORT).show();
            return;
        }

        mTextView.setText(getResult());
        mEditText.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText=findViewById(R.id.editTextInput);
        mTextView=findViewById(R.id.txtViewOutput);
        mButton=findViewById(R.id.buttonCalculate);
        mButton.setOnClickListener(new CMB);


    }
}