package com.nontech.apipractice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Practice_Issue extends AppCompatActivity {

    EditText editText,name,email,number;
    TextView sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_issue);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);
        sendsms=findViewById(R.id.sendsms);


        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String names=name.getText().toString();
                String emails=email.getText().toString();
                String numbers=number.getText().toString();
                String url="http://192.168.1.12/apps/new.php?nam"+names+ "&emai="+emails+ "&numbe=" +numbers ;



                StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        new AlertDialog.Builder(Practice_Issue.this)
                                .setTitle("server response")
                                .setMessage(response)
                                .show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Practice_Issue.this, "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


                RequestQueue requestQueue= Volley.newRequestQueue(Practice_Issue.this);
                requestQueue.add(stringRequest);

            }




        });

    }
}