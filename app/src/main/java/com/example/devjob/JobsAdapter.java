package com.example.devjob;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobViewHolder> {

    private Context context;
    private ArrayList<Jobs> jobsArrayList;
   /* private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }*/


    public JobsAdapter(Context context, ArrayList<Jobs> jobsArrayList) {
        this.context = context;
        this.jobsArrayList = jobsArrayList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.job_item, viewGroup,false);
        final JobViewHolder jobViewHolder=new JobViewHolder(view);
        jobViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,DetailActivity.class);
                i.putExtra("job_company", jobsArrayList.get(jobViewHolder.getAdapterPosition()).getCompany());
                i.putExtra("job_description", jobsArrayList.get(jobViewHolder.getAdapterPosition()).getDescription());
                i.putExtra("job_createdAt", jobsArrayList.get(jobViewHolder.getAdapterPosition()).getCreatedAt());
                i.putExtra("job_type", jobsArrayList.get(jobViewHolder.getAdapterPosition()).getType());
                i.putExtra("job_logo", jobsArrayList.get(jobViewHolder.getAdapterPosition()).getImageUrl());

                context.startActivity(i);

            }
        });

        return jobViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder jobViewHolder, int i) {
        Jobs currentJob=jobsArrayList.get(i);

        String company =currentJob.getCompany();
        String type=currentJob.getType();
        String createdAt=currentJob.getCreatedAt();
        String imageUrl=currentJob.getImageUrl();

        jobViewHolder.titleTextView.setText(company);
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
        LinearLayout view_container;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container=itemView.findViewById(R.id.container);
            posterImageView=itemView.findViewById(R.id.company_logo);
            titleTextView=itemView.findViewById(R.id.company_name);
            typeTextView=itemView.findViewById(R.id.type);
            createdatTextView=itemView.findViewById(R.id.created_at);

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });*/
        }
    }
}
