package com.nontech.apipractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {

    RecyclerView recyclearview;
    List<DetailsAdapter>images;

    Adapter adapter;

    public static String channelurl="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myview=inflater.inflate(R.layout.fragment_news, container, false);

        recyclearview=myview.findViewById(R.id.recyclearview);
        images=new ArrayList<>();


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, "http://192.168.1.5/jsonpractice/practicejson.json", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int x=0; x<response.length(); x++){
                            try {

                                JSONObject jsonObject=response.getJSONObject(x);

                                DetailsAdapter detailsAdapter=new DetailsAdapter();
                                detailsAdapter.setLogo(jsonObject.getString("Logo"));


                                images.add(detailsAdapter);



                            } catch (JSONException e) {
                                Toast.makeText(getContext(), "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }




                        adapter=new Adapter(images,getContext());
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
                        recyclearview.setLayoutManager(gridLayoutManager);
                        recyclearview.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        RequestQueue queue= Volley.newRequestQueue(getContext());
        queue.add(jsonArrayRequest);



        return myview;

    }

}