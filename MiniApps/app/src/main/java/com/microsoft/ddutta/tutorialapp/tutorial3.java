package com.microsoft.ddutta.tutorialapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.commons.lang.StringEscapeUtils;


public class tutorial3 extends ActionBarActivity {
    TextView txt,txt1;
    int type = 1;
    EditText edit;
    String idata="ABC";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial3);

        Button b=(Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.text);

        b.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)            {
                //Intent intent= new Intent(tutorial3.this,Preference.class);
                Log.d("test", "Hello Dipankar:"+type);
               // startActivity(intent);
                switch(type){
                    case 1: txt.setTypeface(Typeface.MONOSPACE);
                        break;
                    case 2:
                        txt.setTypeface(Typeface.SANS_SERIF);
                        break;
                    case 3:
                        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Molot.otf");
                        txt.setTypeface(tf);
                }
                type =type%3+1;
            }
        });

        //Handaling Unicode.
        Button b1=(Button) findViewById(R.id.button1);
        txt1 = (TextView) findViewById(R.id.text1);
        edit = (EditText) findViewById(R.id.edit);
        TextWatcher watcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                // we read something and perse for unicode...You knwo.
                String d = edit.getText().toString();
                Log.d("data","data:::::"+d);
                txt1.setText(d);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        };

        edit.addTextChangedListener(watcher);

        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                //Intent intent= new Intent(tutorial3.this,Preference.class);
                Log.d("test", "Bengali Unicode" + type);
                try
                {
                    String str="";
                    //str = edit.getText().toString();
                    //str = StringEscapeUtils.unescapeJava(str);
                    //txt1.setText(d);

                    str= "\u0017\u0016\u0007";//"\u0986\u09AE\u09Bf";
                    String Fname= "fonts/Siyamrupali_1_01.ttf";
                    txt1.setTypeface(Typeface.createFromAsset(getAssets(),Fname));
                    Log.d("data","data:::::"+str);
                    txt1.setText(str);
                }
                catch(Exception ex)
                {
                    txt1.setText("font cannot load: "+ ex.toString() );
                }

            }
        });

    }
}
