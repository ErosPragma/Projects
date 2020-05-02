package com.example.user.web_display;

import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.ListView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private static  ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        Log.i("TAG", "SECTION "+mSectionsPagerAdapter.getItemPosition(mViewPager));

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int pos = tabLayout.getSelectedTabPosition();
                String name="";
                if (pos==0)
                    name = "Clear History";
                else
                    name = "Clear All Bookmarks";

                Snackbar.make(view, name , Snackbar.LENGTH_LONG)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (pos==0)
                                    FileManager.deleteFile("history.txt");
                                else
                                    FileManager.deleteFile("bookmark.txt");
                                finish();
                                startActivity(getIntent());
                            }
                        })
                        .show();
            }
        });
    }



    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private AlertDialog.Builder alertDialog;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


        public static PlaceholderFragment newInstance(int position)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, position);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_list, container, false);

            listview = (ListView) rootView.findViewById(R.id.listview);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
            Log.i("TAG", "onCreateView: "+getArguments().getInt(ARG_SECTION_NUMBER));

            adapter.add("");
            if (getArguments().getInt(ARG_SECTION_NUMBER)==0)
            {
                String values = FileManager.getList("history.txt");
                Log.i("TAG", "onCreateView:\n"+values);
                if (!values.equals(""))
                {
                    String list[] = values.split("\n");
                    for (int i=0;i<list.length;i++)
                        adapter.add(list[i]);
                }
                listview.setAdapter(adapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                        final String item = adapter.getItem(position);
                        alertDialog = new AlertDialog.Builder(getActivity());

                        alertDialog.setPositiveButton("Bookmark",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.setCancelable(true);
                                        if (!FileManager.lineExist("bookmark.txt",item))
                                            FileManager.write("bookmark.txt",item);
                                        getActivity().finish();
                                        startActivity(getActivity().getIntent());
                                    }
                                });

                        alertDialog.setNegativeButton("DELETE",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        FileManager.deleteLine("history.txt",position-1);
                                        getActivity().finish();
                                        startActivity(getActivity().getIntent());
                                    }
                                });

                        alertDialog.setNeutralButton("GOTO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent result = new Intent();
                                result.putExtra("url",item);
                                getActivity().setResult(RESULT_OK,result);
                                getActivity().finish();
                            }
                        });

                        alertDialog.show();
                    }
                });
            }
            else
            {
                String values = FileManager.getList("bookmark.txt");
                Log.i("TAG", "onCreateView:\n"+values);
                if (!values.equals(""))
                {
                    String list[] = values.split("\n");
                    for (int i=0;i<list.length;i++)
                        adapter.add(list[i]);
                }
                listview.setAdapter(adapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                        final String item = adapter.getItem(position);
                       alertDialog = new AlertDialog.Builder(getActivity());


                        alertDialog.setPositiveButton("DELETE",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.setCancelable(true);
                                        FileManager.deleteLine("bookmark.txt",position-1);
                                        getActivity().finish();
                                        startActivity(getActivity().getIntent());
                                    }
                                });

                        alertDialog.setNeutralButton("GOTO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               Intent result = new Intent();
                                result.putExtra("url",item);
                                getActivity().setResult(RESULT_OK,result);
                                getActivity().finish();
                            }
                        });

                        alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertDialog.setCancelable(true);
                            }
                        });

                        alertDialog.show();
                    }
                });
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HISTORY";
                case 1:
                    return "BOOKMARK";
            }
            return null;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }

}
