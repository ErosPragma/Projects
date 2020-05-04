package com.nr.user.mybasicapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import android.os.Environment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private static final String TAG = "TAG";

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount()
    {
        return mThumbIds.length;
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return mThumbIds[position];
    }

    public static long getPrevItemId(int position)
    {
        position = (position==0)? mThumbIds.length-1 : position-1;
        return mThumbIds[position];
    }

    public static long getNextItemId(int position)
    {
        position = (position+1)%mThumbIds.length;
        return mThumbIds[position];
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, GridView.AUTO_FIT));
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(0,0,0,0);
        }
        else
            imageView = (ImageView) convertView;


        //Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mContext.getResources(),mThumbIds[position]),300,300,false);
        //imageView.setImageBitmap(bitmap);
        //new ImageSaver(mContext).setFileName("image"+position+".png").save(bitmap);

        imageView.setImageBitmap(Bitmap.createScaledBitmap(new ImageSaver(mContext).setFileName("image"+position+".png").load(),300,300,false));
        return imageView;
    }

    static Integer[] mThumbIds=new Integer[0];
}

class ImageSaver {

    private String directoryName = "images";
    private String fileName = "image.png";
    private Context context;
    private boolean external;

    public ImageSaver(Context context) {
        this.context = context;
    }

    public ImageSaver setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ImageSaver setExternal(boolean external) {
        this.external = external;
        return this;
    }

    public ImageSaver setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
        return this;
    }

    public void save(Bitmap bitmapImage) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(createFile());
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            Log.i("TAG", "saved: file");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File createFile() {
        File directory;
        if(external){
            directory = getAlbumStorageDir(directoryName);
        }
        else {
            directory = context.getDir(directoryName, Context.MODE_PRIVATE);
        }
        if(!directory.exists() && !directory.mkdirs()){
            Log.i("TAG","Error creating directory " + directory);
        }


        //Toast.makeText(context, fileName, Toast.LENGTH_SHORT).show();
        return new File(directory, fileName);

    }

    public boolean deleteFile()
    {
        File file = createFile();
        return file.delete();
    }

    private File getAlbumStorageDir(String albumName) {
        return new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public Bitmap load() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(createFile());
            return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}


public class Gallery extends AppCompatActivity {
    private long prev=0,next= 0;
    private FloatingActionButton grid;
    private FloatingActionButton upload;
    private int grid_option = 1;
    private GridView gridview;
    private static final String TAG="TAG";
    private static final int PICK_IMAGE = 1;
    private static final int DEL_IMAGE = 1;
    private Uri imageUri;
    private ImageAdapter IA;
    private int n;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        IA = new ImageAdapter(this);

        upload = (FloatingActionButton)findViewById(R.id.upload);
        gridview = (GridView) findViewById(R.id.gridview);

        //read from file positions.txt to update ImageAdapter.mThumbsID
        String data = "";
        BufferedReader rd;
        try
        {
            rd = new BufferedReader(new InputStreamReader(openFileInput("config.txt")));
            String line= "";
            if (line!=null)
            {
                n=Integer.parseInt(rd.readLine());
                IA.mThumbIds = new Integer[n];

                for(int i=0;(data = rd.readLine())!=null;i++)
                {
                    Log.i(TAG, "onCreate: data : "+data);
                    IA.mThumbIds[i]=Integer.parseInt(data)-1;
                }
            }
            rd.close();
            Log.i(TAG, "File found:  Last line " + line);
        }
        catch (FileNotFoundException e) {
            Log.i(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.i(TAG, "Can not read file: " + e.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (data=="")
            Toast.makeText(this, "No Images" , Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Images successfully Loaded" , Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreate: data : "+data);

        if (n>0)
            gridview.setAdapter(IA);
        else
        {
            Log.i(TAG, "Empty Values: ");
        }

        gridview.setNumColumns(5);

        grid = (FloatingActionButton)findViewById(R.id.grid_opt);

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grid_option==1)
                {
                    grid_option = 0;
                    gridview.setNumColumns(1);
                    grid.setImageResource(R.drawable.grid_off_img);
                }
                else
                {
                    grid_option = 1;
                    gridview.setNumColumns(5);
                    grid.setImageResource(R.drawable.grid_on_img);
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("images/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                //startActivityForResult(Intent.createChooser(gallery,"select picture"),PICK_IMAGE);
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI),PICK_IMAGE);
            }
        });

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                prev = IA.getPrevItemId(position);
                next = IA.getNextItemId(position);

                showImage(gridview.getAdapter().getItemId(position),position);
            }
        });
    }

    private void showImage(long id, int pos){
        Intent pictureViewer = new Intent(this, GalleryImageViewer.class);
        pictureViewer.putExtra("pictureId",id );
        pictureViewer.putExtra("picturePosition", pos);
        pictureViewer.putExtra("picturePrevId", prev);
        pictureViewer.putExtra("pictureNextId", next);

        startActivityForResult(pictureViewer,DEL_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DEL_IMAGE && resultCode == RESULT_FIRST_USER)
        {
            finish();
            startActivity(getIntent());
        }
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data!=null)
        {
            imageUri = data.getData();
            String values="";

            try
            {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);

                BufferedReader rd;
                int count=0;
                try
                {
                    rd = new BufferedReader(new InputStreamReader(openFileInput("config.txt")));
                    String line= rd.readLine();
                    int n = Integer.parseInt(line)+1;
                    values=""+n;
                    for(;(line = rd.readLine())!=null;count++)
                        values = values+"\n"+line;

                    rd.close();
                    values = values +"\n" + n;
                }
                catch (FileNotFoundException e) {
                    Log.i(TAG, "File not found: " + e.toString());
                    values="1\n1";
                } catch (IOException e) {
                    Log.i(TAG, "Can not read file: " + e.toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                new ImageSaver(this).setFileName("image"+n+".png").save(bitmap);
                upload.setImageBitmap(new ImageSaver(this).setFileName("image"+(n-1)+".png").load());
                //Toast.makeText(getApplicationContext(), "File Uploaded!", Toast.LENGTH_LONG).show();


                Log.i(TAG, "To Store:\n"+values);
                try
                {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("config.txt", Context.MODE_PRIVATE));
                    outputStreamWriter.write(values);
                    outputStreamWriter.close();
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

            finish();
            startActivity(getIntent());
        }
    }
}