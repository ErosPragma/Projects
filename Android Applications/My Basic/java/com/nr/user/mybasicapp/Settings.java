package com.nr.user.mybasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Settings extends AppCompatActivity {

    private ImageView save;
    private EditText name;
    private EditText gmail;
    private EditText phone;
    private EditText drive;
    private EditText myweb;
    private static String phone_str;
    private static String name_str;
    private static String gmail_str;
    private static String drive_str;
    private static String myweb_str;
    private FileManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        save = (ImageView)findViewById(R.id.save);
        name = (EditText)findViewById(R.id.name_input);
        gmail = (EditText)findViewById(R.id.gmail_input);
        myweb = (EditText)findViewById(R.id.myweb_input);
        phone = (EditText)findViewById(R.id.phone_input);
        drive = (EditText)findViewById(R.id.drive_input);
        fm = new FileManager(this);

        String list[] = new FileManager(this).getList("config.txt").split("\n");
        name_str = list[0];
        gmail_str = list[1];
        phone_str = list[2];
        drive_str = list[3];
        myweb_str = list[4];

        name.setText(name_str);
        gmail.setText(gmail_str);
        phone.setText(phone_str.trim());
        drive.setText(drive_str.trim());
        myweb.setText(myweb_str.trim());


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gmail_string = gmail.getText().toString();
                String name_string = name.getText().toString();
                String phone_string = phone.getText().toString().trim();
                String drive_string = drive.getText().toString().trim();
                String myweb_string = myweb.getText().toString().trim();

                if (name_string.equals("") )
                    Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                else if (!gmail_string.equals("") &&( gmail_string.startsWith("www.") || !gmail_string.endsWith("@gmail.com")))
                    Toast.makeText(getApplicationContext(), "Invalid gmail!", Toast.LENGTH_SHORT).show();
                else if(!drive_string.equals("") && ( !drive_string.startsWith("https://drive.google.com/")))
                    Toast.makeText(getApplicationContext(), "Invalid drive Link!", Toast.LENGTH_SHORT).show();
                else if (!phone_string.equals("") && (phone_string.length()!=10 && Pattern.matches("\\d+",phone_string)))
                    Toast.makeText(getApplicationContext(), "Invalid Phone Number!", Toast.LENGTH_SHORT).show();
                else if(!myweb_string.equals("") && (!myweb_string.startsWith("https://")))
                    Toast.makeText(getApplicationContext(), "Invalid website Link!", Toast.LENGTH_SHORT).show();
                else
                {
                    if(drive_string.equals(""))
                        drive_string=" ";
                    if(gmail_string.equals(""))
                        gmail_string=" ";
                    if(phone_string.equals(""))
                        phone_string=" ";
                    if(myweb_string.equals(""))
                        myweb_string=" ";

                    fm.deleteFile("config.txt");
                    fm.write("config.txt",(name_string+"\n"+gmail_string+"\n"+phone_string+"\n"+drive_string+"\n"+myweb_string));
                    Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });
    }
}
