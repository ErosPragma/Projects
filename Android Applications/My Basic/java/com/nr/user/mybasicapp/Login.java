package com.nr.user.mybasicapp;

import android.Manifest;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.util.Log;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


class FileManager
{
    private static String TAG="TAG";
    private static String path;
    private static Context context;

    FileManager(Context c)
    {
        this.context = c;
        File path = context.getExternalFilesDir(null);
        if (null==path)
            path = context.getFilesDir();

        this.path = path.getAbsolutePath();
        Log.i(TAG, "FileManager: PATH : "+this.path);
    }
    public static String getPath()
    {
        //External Visible folder
        //return (Environment.getExternalStorageDirectory().getAbsolutePath()+"/Android/data/com.nr.myapp");

        //internal invisible folder
        return FileManager.path;
    }

    public static int createfile(String name)
    {
        String path = getPath();
        File dir;
        File file;
        while(true)
        {
            try
            {
                dir = new File(path);
                if(dir.mkdirs())
                    Log.i(TAG, "write: dir created : "+path);
                else
                    Log.i(TAG, "write: dir exist : "+path);

                path = path + "/" + name;
                file = new File(path);
                if (file.createNewFile()) {
                    Log.i(TAG, "write: file created : " + path);
                    return 1;
                }
                else {
                    Log.i(TAG, "write: file exist : " + path);
                    return 0;
                }
            }
            catch (Exception e)
            {
                Log.i(TAG, "write: Creation Failed : "+e.toString());
            }

            return -1;
        }
    }

    public static String getList(String name)
    {
        String path = getPath()+"/"+name;
        Log.i("TAG", "getList: "+path);
        String line="";
        String value="";
        // list[0]="www.google.com";

        if (createfile(name)!=0)
            return "";

        BufferedReader rd;
        try
        {
            rd = new BufferedReader(new FileReader(path));
            for(;(line = rd.readLine())!=null;)
                value = value + line +"\n";
            rd.close();
        }
        catch (Exception e)
        {
            Log.i("TAG", "getList: "+e.toString());
        }
        Log.i("TAG", "\n"+value);
        return value;
    }


    public static void deleteFile(String name)
    {
        String path = getPath()+"/"+name;
        new File(path).delete();
    }

    static void write(String name,String url)
    {
        String values="",line="";
        String path = getPath()+"/"+name;

        createfile(name);

        try
        {
            BufferedReader rd;
            try
            {
                rd = new BufferedReader(new FileReader((path)));
                for(;(line = rd.readLine())!=null;)
                    values = values+line+"\n";

                rd.close();
                values = values + url +"\n";
            }
            catch (Exception e)
            {
                Log.i(TAG, "Can not read file: " + e.toString());
            }
            try
            {
                Log.i("TAG", "Store: "+path);
                FileWriter fr = new FileWriter(path);
                fr.write(values);
                fr.close();
                Log.i(TAG, "Stored:\n"+values);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Log.i(TAG, "onActivityResult: Writing : "+values);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Log.i(TAG, "onActivityResult: Writing Error");
        }
    }
}



public class Login extends AppCompatActivity {

    private static final int INTERNET_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private EditText name;
    private EditText gmail;
    private String name_string;
    private String gmail_string;
    private ImageView go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE);
        checkPermission(Manifest.permission.INTERNET,INTERNET_PERMISSION_CODE);

        if (!new FileManager(this).getList("config.txt").equals(""))
            startActivity(new Intent(Login.this,Main.class));

        name = (EditText)findViewById(R.id.name);
        gmail = (EditText)findViewById(R.id.gmail);
        go = (ImageView) findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        gmail.setOnKeyListener(new View.OnKeyListener() {
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
    }

    public void validate()
    {
        gmail_string = gmail.getText().toString();
        name_string = name.getText().toString();

        if (name_string.equals("") || gmail_string.equals("") )
            Toast.makeText(getApplicationContext(), "Enter Name or gmail", Toast.LENGTH_SHORT).show();
        else if (gmail_string.startsWith("www") || !gmail_string.endsWith("@gmail.com"))
            Toast.makeText(getApplicationContext(), "Invalid gmail!", Toast.LENGTH_SHORT).show();
        else
        {
            new FileManager(this).write("config.txt",(name_string+"\n"+gmail_string+"\n \n \n \n"));
            startActivity(new Intent(Login.this,Main.class));
        }
    }
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(Login.this, permission)== PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(Login.this,new String[] { permission },requestCode);
       /* else
            Toast.makeText(Login.this,"Permission already granted",Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        if (requestCode == INTERNET_PERMISSION_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(Login.this, "Internet Permission Granted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Login.this,"Internet Permission Denied",Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == STORAGE_PERMISSION_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(Login.this,"Storage Permission Granted",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Login.this,"Storage Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }
}
