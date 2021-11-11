package com.example.p0331_sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Text1 extends Activity implements OnClickListener
{


    EditText etText1;

    Button btnSave, btnLoad;


    SharedPreferences sPref1;


    final String SAVED_TEXT = "saved_text";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etText1 = (EditText) findViewById(R.id.etText1);


        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText()
    {


        sPref1 = getPreferences(MODE_PRIVATE);
        Editor ed1 = sPref1.edit();
        ed1.putString(SAVED_TEXT, etText1.getText().toString());
        ed1.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();


    }

    void loadText()
    {


        sPref1 = getPreferences(MODE_PRIVATE);
        String savedText1 = sPref1.getString(SAVED_TEXT, "");
        etText1.setText(savedText1);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        saveText();
    }
}
