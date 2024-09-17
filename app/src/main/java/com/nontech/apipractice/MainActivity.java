package com.nontech.apipractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public static ProgressBar progressBar;
    TextView news,sports,entertainment;
    FrameLayout famelayout;

    private boolean isfragment=false;

    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalScrollView=findViewById(R.id.horixontalscrollview);
        horizontalScrollView.setSmoothScrollingEnabled(true);


        news=findViewById(R.id.news);
        sports=findViewById(R.id.sports);
        entertainment=findViewById(R.id.entertainment);
        progressBar=findViewById(R.id.progressbar);
        famelayout=findViewById(R.id.famelayout);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isfragment){
                    loadfragment();
                    isfragment=true;
                }



            }
        });


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isfragment){

                   Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                   startActivity(intent);

                }

            }
        });


        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Practice_Issue.class);
                startActivity(intent);

            }
        });


    }

    private void loadfragment() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.famelayout,new NewsFragment());
        fragmentTransaction.commit();

    }


}