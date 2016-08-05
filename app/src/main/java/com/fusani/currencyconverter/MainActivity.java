package com.fusani.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convertCurrency(View view) {
        // get the amount to convert
        Double amount = Double.parseDouble(((EditText) findViewById(R.id.amount)).getText().toString());

        // get the currency we're converting from and to
        String fromCurrency = ((Spinner) findViewById(R.id.fromCurrency)).getSelectedItem().toString();
        String toCurrency = ((Spinner) findViewById(R.id.toCurrency)).getSelectedItem().toString();

        if (fromCurrency.equals("USD") && toCurrency.equals("Euro")) {
            amount *= 0.9;
        } else if (fromCurrency.equals("Euro") && toCurrency.equals("USD")) {
            amount *= 1.11;
        }

        Toast.makeText(getApplicationContext(), String.format("%.2f", amount), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner fromCurrency = (Spinner) findViewById(R.id.fromCurrency);
        Spinner toCurrency = (Spinner) findViewById(R.id.toCurrency);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);
    }
}
