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

public class MainActivity extends Activity implements OnClickListener
{

    EditText etText;
    EditText etText1;
    EditText etText2;
    Button btnSave, btnLoad;

    SharedPreferences sPref;
    SharedPreferences sPref1;
    SharedPreferences sPref2;

    final String SAVED_TEXT1 = "saved_text1";
    final String SAVED_TEXT2 = "saved_text2";
    final String SAVED_TEXT3 = "saved_text3";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        etText1 = (EditText) findViewById(R.id.etText1);
        etText2 = (EditText) findViewById(R.id.etText2);

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
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT1, etText.getText().toString());
        ed.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        sPref1 = getPreferences(MODE_PRIVATE);
        Editor ed1 = sPref1.edit();
        ed1.putString(SAVED_TEXT2, etText1.getText().toString());
        ed1.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        sPref2 = getPreferences(MODE_PRIVATE);
        Editor ed2 = sPref2.edit();
        ed2.putString(SAVED_TEXT3, etText2.getText().toString());
        ed2.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText()
    {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT1, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();

        sPref1 = getPreferences(MODE_PRIVATE);
        String savedText1 = sPref1.getString(SAVED_TEXT2, "");
        etText1.setText(savedText1);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();

        sPref2 = getPreferences(MODE_PRIVATE);
        String savedText2 = sPref2.getString(SAVED_TEXT3, "");
        etText2.setText(savedText2);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        saveText();
    }
}