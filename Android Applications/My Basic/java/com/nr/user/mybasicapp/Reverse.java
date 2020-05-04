package com.nr.user.mybasicapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Reverse extends AppCompatActivity {

    private EditText input;
    private ImageView copy;
    private TextView reverse;
    private ImageView clear;

    private ClipboardManager myclip;

    private void validate()
    {
        String inputString = input.getText().toString();
        String reverseString="";
        for (int i = 0; i < inputString.length(); i++)
            reverseString = inputString.charAt(i) + reverseString;
        reverse.setText(reverseString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);

        input = (EditText)findViewById(R.id.input);
        copy = (ImageView)findViewById(R.id.copy);
        reverse = (TextView)findViewById(R.id.reverse);
        clear = (ImageView)findViewById(R.id.clear);
        myclip = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);


        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    validate();
                    return true;
                }
                return false;
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                myclip.setPrimaryClip(ClipData.newPlainText("text",reverse.getText().toString()));
                Toast.makeText(getApplicationContext(), "Copied !!!", Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                reverse.setText("");
                Toast.makeText(getApplicationContext(), "Cleared !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
