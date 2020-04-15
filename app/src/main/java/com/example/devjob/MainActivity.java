package com.example.devjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.devjob.JobsAdapter;
import com.example.devjob.Jobs;
import com.example.devjob.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JobsAdapter.OnItemClickListener{

    public static final String KEY_TITLE = "title";
    public static final String KEY_COMPANY = "company";
    public static final String KEY_POSTER_URL = "posterUrl";
    public static final String KEY_TYPE = "type";
    public static final String KEY_CREATEDAT = "createdAt";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_HOWTOAPPLY = "howToApply";

    private RecyclerView recyclerView;
    private JobsAdapter jobsAdapter;
    private ArrayList<Jobs>jobsArrayList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jobsArrayList=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        getJobs();
    }

    private void getJobs() {
        String url="https://jobs.github.com/positions.json?search=node";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("Search");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String title = jsonObject.getString("Title");
                        String type = jsonObject.getString("Type");
                        String createdat = jsonObject.getString("CreatedAt");
                        String posterUrl = jsonObject.getString("Poster");

                        Jobs jobs = new Jobs();
                        jobs.setTitle(title);
                        jobs.setType(type);
                        jobs.setCreatedAt(createdat);
                        jobs.setImageUrl(posterUrl);


                        jobsArrayList.add(jobs);
                    }
                jobsAdapter=new JobsAdapter(MainActivity.this,jobsArrayList);
                recyclerView.setAdapter(jobsAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
            requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,
                DetailActivity.class);
        Jobs clickedjob = jobsArrayList.get(position);
        intent.putExtra(KEY_COMPANY, clickedjob.getCompany());
        intent.putExtra(KEY_TITLE, clickedjob.getTitle());
        intent.putExtra(KEY_POSTER_URL, clickedjob.getImageUrl());
        intent.putExtra(KEY_TYPE, clickedjob.getType());
        intent.putExtra(KEY_CREATEDAT, clickedjob.getCreatedAt());
        intent.putExtra(KEY_LOCATION, clickedjob.getLocation());
        intent.putExtra(KEY_DESCRIPTION, clickedjob.getDescription());
        intent.putExtra(KEY_HOWTOAPPLY, clickedjob.getHowtoapply());

        startActivity(intent);
    }
}
