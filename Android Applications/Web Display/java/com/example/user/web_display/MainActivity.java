package com.example.user.web_display;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.content.DialogInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.support.design.widget.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

class FileManager
{
    private static String TAG="TAG";

    public static int createfile(String name)
    {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display";
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
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display/"+name;
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

    public static void deleteLine(String name,int pos)
    {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display/"+name;
        String values="",line;
        try
        {
            BufferedReader rd;
            try
            {
                rd = new BufferedReader(new FileReader((path)));
                for(int i=0;(line = rd.readLine())!=null;i++)
                    if (i!=pos)
                        values = values+line+"\n";

                rd.close();
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

    public static boolean lineExist(String name,String line)
    {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display/"+name;
        String value="";

        BufferedReader rd;
        try
        {
            rd = new BufferedReader(new FileReader(path));
            for(;(value = rd.readLine())!=null;)
            {
                if (value.equals(line))
                {
                    rd.close();
                    return true;
                }
            }
            rd.close();
        }
        catch (Exception e)
        {
            Log.i("TAG", "getList: "+e.toString());
        }
        return false;
    }

    public static void deleteFile(String name)
    {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display/"+name;
        new File(path).delete();
    }

    static void write(String name,String url)
    {
        String values="",line="";
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Web Display/"+name;

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

public class MainActivity extends AppCompatActivity {


    private static final int INTERNET_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private static final int MENU_ACTIVITY = 1;

    private FloatingActionButton load;
    private FloatingActionButton menu;
    private EditText url;
    private WebView webviewer;
    private AlertDialog.Builder alertDialog;

    private static String TAG = "TAG";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE);
        checkPermission(Manifest.permission.INTERNET,INTERNET_PERMISSION_CODE);

        load = (FloatingActionButton) findViewById(R.id.load);
        menu = (FloatingActionButton) findViewById(R.id.menu);
        webviewer = (WebView) findViewById(R.id.web);
        webviewer.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.i(TAG, "shouldOverrideUrlLoading: " + url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                Log.i(TAG, "onPageStarted: "+url);
                FileManager.write("history.txt",url);
                super.onPageStarted(view, url, favicon);
            }
        });
        webviewer.getSettings().setLoadsImagesAutomatically(true);
        webviewer.getSettings().setJavaScriptEnabled(true);
        webviewer.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //webviewer.loadUrl("file:///android_asset/homepage.html");
        webviewer.setVisibility(View.GONE);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,Main2Activity.class),MENU_ACTIVITY);
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog = new AlertDialog.Builder(MainActivity.this);
                url = new EditText(MainActivity.this);
                url.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                url.setTextAlignment(LinearLayout.TEXT_ALIGNMENT_CENTER);
                url.setHint("https://");
                url.setText(url.getText().toString());
                alertDialog.setView(url);
                alertDialog.setTitle("Enter url");
                alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        //TOAST.makeToast(getApplicationContext(),"onEnterKey",Toast.LENGTH_SHORT);
                        Log.i(TAG, "onKey: "+keyCode);
                        return false;
                    }
                });
                alertDialog.setPositiveButton("SEARCH",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String url_link = url.getText().toString();
                                Log.i(TAG, "onClick: "+url_link);
                                if (url_link.equals("")==true)
                                    webviewer.loadUrl("https://www.google.co.in");
                                else if (url_link.contains("http")==true)
                                    webviewer.loadUrl(url_link);
                                else if (url_link.contains("www")==true)
                                    webviewer.loadUrl("https://"+url_link);
                                else
                                    webviewer.loadUrl("https://www.google.com/search?q="+url_link);
                                webviewer.setVisibility(View.VISIBLE);

                            }
                        });
                alertDialog.setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                alertDialog.setCancelable(true);
                            }
                        });

                alertDialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webviewer.canGoBack())
            webviewer.goBack();
        else
            super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: RETURNED");
        if (resultCode== Activity.RESULT_OK && requestCode==MENU_ACTIVITY){
            String url_path = data.getStringExtra("url");
            Log.i(TAG, "onActivityResult: "+url_path);
            webviewer.loadUrl(url_path);
            webviewer.setVisibility(View.VISIBLE);
        }

    }

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)== PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(MainActivity.this,new String[] { permission },requestCode);
       /* else
            Toast.makeText(MainActivity.this,"Permission already granted",Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        if (requestCode == INTERNET_PERMISSION_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(MainActivity.this, "Internet Permission Granted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Internet Permission Denied",Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == STORAGE_PERMISSION_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(MainActivity.this,"Storage Permission Granted",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Storage Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }
}
