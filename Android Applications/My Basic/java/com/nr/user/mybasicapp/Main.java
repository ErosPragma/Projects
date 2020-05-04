package com.nr.user.mybasicapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

class My_Adapter extends BaseAdapter{

    private Context context;

    My_Adapter(Context c)
    {
        this.context = c;
    }
    @Override
    public int getCount() {
        return thumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return thumbs[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, GridView.AUTO_FIT));
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(0,0,0,50);

        }
        else
            imageView = (ImageView) convertView;


        //imageView.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),thumbs[position]),100,100,false));
        imageView.setImageResource(thumbs[position]);
        imageView.setPadding(25,25,25,25);
        return imageView;
    }

    private Integer[] thumbs = {
            R.drawable.img_language,
            R.drawable.img_gallery,
            R.drawable.img_callme,
            R.drawable.img_mypc,
            R.drawable.img_drive,
            R.drawable.img_settings
    };
}

public class Main extends AppCompatActivity {

    private GridView gridview;
    private TextView title;
    private static String gmail;
    private static String name;
    private static String phone;
    private static String drive;
    private static String myweb;
    private static int SETTINGS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = FileManager.getList("config.txt").split("\n");
        name = list[0];
        gmail = list[1];
        phone = list[2];
        drive = list[3];
        myweb = list[4];

        title = (TextView) findViewById(R.id.title);
        title.setText("Welcome "+name+"!");

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new My_Adapter(this));
        gridview.setNumColumns(3);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(Main.super.getBaseContext(), ""+position , Toast.LENGTH_SHORT).show();

                Intent intent;
                switch (position)
                {
                    case 0: startActivity(new Intent(Main.this,Reverse.class));
                            break;
                    case 1: startActivity(new Intent(Main.this,Gallery.class));
                        break;
                    case 2:
                        if (phone.equals(" "))
                            Toast.makeText(Main.super.getBaseContext(), "speeddial not set" , Toast.LENGTH_SHORT).show();
                        else
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone)));
                        break;
                    case 3:
                        if (myweb.equals(" "))
                            Toast.makeText(Main.super.getBaseContext(), "website not set" , Toast.LENGTH_SHORT).show();
                        else
                        {
                            intent = new Intent(Main.this,Web.class);
                            intent.putExtra("url",myweb);
                            startActivity(intent);
                        }
                        break;
                    case 4:
                        if (drive.equals(" "))
                            Toast.makeText(Main.super.getBaseContext(), "drive link not set" , Toast.LENGTH_SHORT).show();
                        else
                        {
                            intent = new Intent(Main.this,Web.class);
                            intent.putExtra("url",drive);
                            startActivity(intent);
                        }
                        break;
                    case 5:
                        intent = new Intent(Main.this,Settings.class);
                        startActivityForResult(intent,SETTINGS);
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SETTINGS && resultCode==RESULT_OK)
        {
            Log.i("TAG", "onActivityResult: DONE");
            finish();
            startActivity(getIntent());
        }
    }
}
