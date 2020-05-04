package com.nr.user.mybasicapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class GalleryImageViewer extends AppCompatActivity {

    long picItem, picPrevItem, picNextItem;
    int picPosition;
    private ImageView m_vwImage;
    private ImageView delete;
    private AlertDialog.Builder alert;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery_viewer);
        delete = (ImageView) findViewById(R.id.delete);
        alert = new AlertDialog.Builder(this);
        Intent i = getIntent();

        picItem = i.getLongExtra("pictureId", -1);
        Log.i("TAG","To SHOW"+picItem);
        picPrevItem = i.getLongExtra("picturePrevId", -1);
        picNextItem = i.getLongExtra("pictureNextId", -1);
        picPosition = i.getIntExtra("picturePosition", -1);

        m_vwImage = (ImageView) findViewById(R.id.imageview);

        m_vwImage.setImageBitmap(new ImageSaver(getApplicationContext()).setFileName("image"+(int) picItem+".png").load());


        ImageView startImageView = (ImageView) findViewById(R.id.return_ImageView);
        startImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

        ImageView leftImageView = (ImageView) findViewById(R.id.left_ImageView);
        leftImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Drawable imagePrev = getResources().getDrawable((int) picPrevItem);
                m_vwImage.setImageBitmap(new ImageSaver(getApplicationContext()).setFileName("image"+(int) picPrevItem+".png").load());

                if (--picPosition < 0) picPosition = ImageAdapter.mThumbIds.length;
                picPrevItem = (ImageAdapter.getPrevItemId(picPosition));
                picNextItem = (ImageAdapter.getNextItemId(picPosition));

            }
        });

        ImageView rightImageView = (ImageView) findViewById(R.id.right_ImageView);
        rightImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Drawable imageNext = getResources().getDrawable((int) picNextItem);
                m_vwImage.setImageBitmap(new ImageSaver(getApplicationContext()).setFileName("image"+(int) picNextItem+".png").load());

                if (++picPosition > ImageAdapter.mThumbIds.length) picPosition = 0;
                picNextItem = (ImageAdapter.getNextItemId(picPosition));
                picPrevItem = (ImageAdapter.getPrevItemId(picPosition));

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alert.setMessage("Delete Photo");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean flg = new ImageSaver(getApplicationContext()).setFileName("image"+(int) picItem+".png").deleteFile();
                        String values="";
                        Log.i("TAG", "Delete: "+flg);
                        m_vwImage.setImageBitmap(new ImageSaver(getApplicationContext()).setFileName("image"+(int) picNextItem+".png").load());

                        BufferedReader rd;
                        int count=0;
                        try
                        {
                            rd = new BufferedReader(new InputStreamReader(openFileInput("config.txt")));
                            String line= rd.readLine();
                            values=""+(Integer.parseInt(line)-1);
                            for(;(line = rd.readLine())!=null;count++)
                                if ((Integer.parseInt(line)-1)!=picItem)
                                    values = values+"\n"+line;

                            rd.close();
                        }
                        catch (Exception e)
                        {
                            Log.i("TAG", "File not found: " + e.toString());
                        }

                        try
                        {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("config.txt", Context.MODE_PRIVATE));
                            outputStreamWriter.write(values);
                            outputStreamWriter.close();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            Log.i("TAG", "Delete : Writing : "+values);
                        }
                        setResult(RESULT_FIRST_USER);
                        finish();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ;
                    }
                });
                alert.create().show();
            }
        });


    }
}