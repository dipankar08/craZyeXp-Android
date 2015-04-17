package com.microsoft.ddutta.tutorialapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class tutorial10 extends ActionBarActivity {

    private int mYear;
    private int mMonth;
    private int mDay;

    private TextView mDateDisplay;
    private Button mPickDate;

    static final int DATE_DIALOG_ID = 0;

    EditText eText;
    AutoCompleteTextView autocompletetextview;
    Button btnProduct;
    CheckBox chk1, chk2;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial9);

        //--- text view---
        TextView txtView = (TextView) findViewById(R.id.text);
        final String Label = txtView.getText().toString();
        txtView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You have clicked the Label : " + Label, Toast.LENGTH_LONG).show();
            }
        });

        // Edit Text
        eText = (EditText) findViewById(R.id.edittext);
        eText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
                msg.show();
            }
        });

        //Auto Complete Text View
        autocompletetextview = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        String[] arr = {"MS SQL SERVER", "MySQL", "Oracle"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, arr);
        autocompletetextview.setThreshold(1);
        autocompletetextview.setAdapter(adapter);

        //Bootom
        btnProduct = (Button) findViewById(R.id.button);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1 = btnProduct.getText().toString();
                Toast.makeText(getApplicationContext(),
                        String.valueOf(t1), Toast.LENGTH_LONG).show();
            }
        });

        //image Button
        ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(tutorial10.this, "ImageButtonClicked : tutorialspoint.com",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //check Box
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox1);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(tutorial10.this, " Ck1 Checked",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(tutorial10.this, " Ck1 UnChecked",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Radio Button
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (checkedId == R.id.radio0) {
                    Toast.makeText(tutorial10.this, " Radio 0",
                            Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.radio1) {
                    Toast.makeText(tutorial10.this, " Radio 1",
                            Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.radio2) {
                    Toast.makeText(tutorial10.this, " Radio 2",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Toggle Byutton
        ToggleButton toggleAlarm = (ToggleButton) findViewById(R.id.toggleButton);
        toggleAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(tutorial10.this, " Onm",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(tutorial10.this, " OFF",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Drop Down
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                Toast.makeText(parentView.getContext(), "Selected: " + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                Toast.makeText(tutorial10.this,"Nothing selecetd", Toast.LENGTH_LONG).show();
            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        //date Picker
        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);
        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        // display the current date
        mDateDisplay.setText(  new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
        }

}
