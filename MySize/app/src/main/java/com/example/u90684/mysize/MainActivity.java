package com.example.u90684.mysize;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String NECK = "NECK";
    private static final String SLEEVE = "SLEEVE";
    private static final String WAIST = "WAIST";
    private static final String INSEAM = "INSEAM";
    private EditText editNECK;
    private EditText editSLEEVE;
    private EditText editWAIST;
    private EditText editINSEAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        String neck = pref.getString(NECK, "");
        String sleeve = pref.getString(SLEEVE, "");
        String waist = pref.getString(WAIST, "");
        String inseam = pref.getString(INSEAM, "");
        editNECK = (EditText)findViewById(R.id.neck);
        editSLEEVE = (EditText)findViewById(R.id.sleeve);
        editWAIST = (EditText)findViewById(R.id.waist);
        editINSEAM = (EditText)findViewById(R.id.inseam);

        editNECK.setText(neck);
        editSLEEVE.setText(sleeve);
        editWAIST.setText(waist);
        editINSEAM.setText(inseam);

        findViewById(R.id.height_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onSaveTaped(View view){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NECK,editNECK.getText().toString());
        editor.putString(SLEEVE,editSLEEVE.getText().toString());
        editor.putString(WAIST,editWAIST.getText().toString());
        editor.putString(INSEAM,editINSEAM.getText().toString());
        editor.commit();
    }
}
