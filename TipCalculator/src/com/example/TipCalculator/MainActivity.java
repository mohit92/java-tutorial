package com.example.TipCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;

import java.text.DecimalFormat;

/**
 * Created by mohit on 6/3/14.
 */
public class MainActivity extends Activity {

    private static final String TOTAL_BILL = "TOTAL_BILL";
    private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";

    private double currentBillTotal;
    private int currentCustomPercent;

    private EditText billTotalEditText;
    private EditText tenEditText;
    private EditText fifteenEditText;
    private EditText twentyEditText;
    private EditText tenTotalEditText;
    private EditText fifteenTotalEditText;
    private EditText twentyTotalEditText;
    private SeekBar customSeekBar;
    private EditText customSeekBarEditText;
    private EditText calculatedTipEditText;
    private EditText calculatedTotalEditText;





    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if(savedInstanceState==null)
        {
            currentBillTotal=0.0;
            currentCustomPercent=17;
        }
        else
        {
            currentBillTotal = savedInstanceState.getDouble(TOTAL_BILL);
            currentCustomPercent = savedInstanceState.getInt(CUSTOM_PERCENT);
        }

        billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);

        tenEditText = (EditText) findViewById(R.id.tenEditText);
        tenTotalEditText = (EditText) findViewById(R.id.tenTotalEditText);

        fifteenEditText = (EditText) findViewById(R.id.fifteenEditText);
        fifteenTotalEditText = (EditText) findViewById(R.id.fifteenTotalEditText);

        twentyEditText = (EditText) findViewById(R.id.twentyEditText);
        twentyTotalEditText = (EditText) findViewById(R.id.twentyTotalEditText);

        customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        customSeekBarEditText = (EditText) findViewById(R.id.customSeekBarEditText);

        calculatedTipEditText = (EditText) findViewById(R.id.calculatedTipEditText);
        calculatedTotalEditText = (EditText) findViewById(R.id.calculatedTotalEditText);

        billTotalEditText.addTextChangedListener(textWatcher);

        customSeekBar.setOnSeekBarChangeListener(new seekBarChangeListener());

    }
    private class seekBarChangeListener implements SeekBar.OnSeekBarChangeListener
    {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            Log.d("DEBUG", "Progress is :" + progress);
            customSeekBarEditText.setText(progress+"%");
            updateCustomTip();
        }
        public void onStartTrackingTouch(SeekBar seekbar){}
        public void onStopTrackingTouch(SeekBar seekBar){}
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence billTotal, int i, int i2, int i3) {
            try
            {
                currentBillTotal = Double.parseDouble(billTotal.toString());

                updateStandardTips();
                updateCustomTip();
            }
            catch (NumberFormatException e)
            {
                currentBillTotal = 0.0;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void updateStandardTips()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        double tipTenPercent = currentBillTotal * .10;
        double totalTenPercent = currentBillTotal * 1.1;

        tenEditText.setText(df.format(tipTenPercent));
        tenTotalEditText.setText(df.format(totalTenPercent));

        double tipFifteenPercent = currentBillTotal * .15;
        double totalFifteenPercent = currentBillTotal * 1.15;

        fifteenEditText.setText(df.format(tipFifteenPercent));
        fifteenTotalEditText.setText(df.format(totalFifteenPercent));

        double tipTwentyPercent = currentBillTotal * .2;
        double totalTwentyPercent = currentBillTotal * 1.2;

        twentyEditText.setText(df.format(tipTwentyPercent));
        twentyTotalEditText.setText(df.format(totalTwentyPercent));


    }

    private void updateCustomTip()
    {
        currentCustomPercent = customSeekBar.getProgress();
        double customTipPercent = currentCustomPercent/100.0;
        double customTip = currentBillTotal * customTipPercent;
        double totalCustom = currentBillTotal * (1 + customTipPercent);

        DecimalFormat df = new DecimalFormat("#.00");
        calculatedTipEditText.setText(df.format(customTip));
        calculatedTotalEditText.setText(df.format(totalCustom));

    }

    protected  void onSaveInstanceState(Bundle savedInstanceState)
    {
        Log.d("DEBUG","Entered in saved instance state");
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putDouble(TOTAL_BILL,currentBillTotal);
        savedInstanceState.putInt(CUSTOM_PERCENT,currentCustomPercent);
    }

}
