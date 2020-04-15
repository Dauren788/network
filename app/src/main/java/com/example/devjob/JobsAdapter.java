package com.example.devjob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobViewHolder> {

    private Context context;
    private ArrayList<Jobs> jobsArrayList;

    public JobsAdapter(Context context, ArrayList<Jobs> jobsArrayList) {
        this.context = context;
        this.jobsArrayList = jobsArrayList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.job_item, viewGroup,false);

        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder jobViewHolder, int i) {
        Jobs currentJob=jobsArrayList.get(i);

        String title =currentJob.getTitle();
        String type=currentJob.getType();
        String createdAt=currentJob.getCreatedAt();
        String imageUrl=currentJob.getImageUrl();

        jobViewHolder.titleTextView.setText(title);
        jobViewHolder.typeTextView.setText(type);
        jobViewHolder.createdatTextView.setText(createdAt);
        Picasso.get().load(imageUrl).fit().centerInside().into(jobViewHolder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return jobsArrayList.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder{

        ImageView posterImageView;
        TextView titleTextView;
        TextView typeTextView;
        TextView createdatTextView;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            posterImageView=itemView.findViewById(R.id.posterImageView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
            typeTextView=itemView.findViewById(R.id.typeTextView);
            createdatTextView=itemView.findViewById(R.id.created_atTextView);

        }
    }
}
