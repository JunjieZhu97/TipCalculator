package com.example.problem1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
TextInputEditText tietBillAmount;
SeekBar sbTipPercentage;
Button btnCalculate;
TextView tvTipFinalValue,tvTipAmount,tvTotalAmount,tvProgress;
int ProgressValue,MainBill,TipPercentValue,TipAmount,TotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tietBillAmount=findViewById(R.id.tietBill);
        sbTipPercentage=findViewById(R.id.sbTipPercentage);
        tvTipFinalValue=findViewById(R.id.tvTipFinalValue);
        tvTipAmount=findViewById(R.id.tvTipAmount);
        tvTotalAmount=findViewById(R.id.tvTotalAmount);
        tvProgress=findViewById(R.id.tvProgress);
        btnCalculate=findViewById(R.id.btnCalculate);

tvProgress.setText("0 %");
tvTipFinalValue.setText("0 %");
tvTipAmount.setText("0 %");
tvTotalAmount.setText("0 %");
        sbTipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ProgressValue= (seekBar.getWidth() - seekBar.getPaddingLeft()-seekBar.getPaddingRight()) * progress / seekBar.getMax();
                tvProgress.setText( progress+" %");
                tvProgress.setX((seekBar.getX()+seekBar.getPaddingLeft()+ProgressValue)-tvProgress.getWidth()/2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
tvTipFinalValue.setText(seekBar.getProgress()+" %");
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tietBillAmount.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Fill Bill Amount", Toast.LENGTH_LONG).show();
                    tietBillAmount.setError("Please Fill Bill Here !!");
                }
                else
                {
                MainBill=Integer.parseInt(tietBillAmount.getText().toString());
                TipPercentValue=sbTipPercentage.getProgress();
                TipAmount=(MainBill*TipPercentValue)/100;
                tvTipAmount.setText(TipAmount+"");
                TotalAmount=TipAmount+MainBill;

                tvTotalAmount.setText(TotalAmount+"");
                }
            }
        });
    }
}
