package com.example.user.myjiofi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Button;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button load;
    private EditText url;
    private WebView webviewer;

    private Document doc;
    private String details_known[][]=new String[2][100];
    private String details_unknown[][]=new String[2][20];
    private int count_known=0,count_unknown=0;
    private static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run()
            {
                try
                {
                    doc = Jsoup.connect("http://jiofi.local.html/").timeout(6000).get();
                    Elements hidden = doc.select("input[type=hidden]");
                    for (Element cell : hidden)
                    {
                        //Log.i("TAG", count++ + "\t" + cell.id() + ":" + cell.val() + "\n");
                        details_known[0][count_known] = cell.id();
                        details_known[0][count_known++] = cell.val();
                    }

                    doc = Jsoup.connect("http://jiofi.local.html/cgi-bin/en-jio/mStatus.html").get();
                    Elements div = doc.select("div > div > a");
                    for (Element block_a : div)
                    {
                        Elements block_strong = block_a.select("strong");
                        for (Element strong : block_strong)
                        {
                            Element label = strong.nextElementSibling().nextElementSibling();
                            String word = strong.text().substring(0,strong.text().length()-1);
                            String value = label.text();

                            //Log.i("TAG", count+++"\t"+word+"\t"+value_id+":"+value);
                            if (value.equals("")==true)
                            {
                                details_known[0][count_known] = word;
                                details_known[1][count_known++] = label.id();
                            }
                            else
                            {
                                details_unknown[0][count_unknown] = word;
                                details_unknown[1][count_unknown++] = value;
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
        });

        thread.start();

        for (int i=0;i<count_known;i++)
            Log.i("TAG", i+":"+details_known[0][i]+"\t"+details_known[0][i]);
        for (int i=0;i<count_unknown;i++)
            Log.i("TAG", i+":"+details_unknown[0][i]+"\t"+details_unknown[0][i]);

        Log.i("TAG", "onCreate: DONE");
    }
}
