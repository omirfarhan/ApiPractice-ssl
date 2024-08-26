package com.nontech.apipractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

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


    }

    private void loadfragment() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.famelayout,new NewsFragment());
        fragmentTransaction.commit();

    }


}