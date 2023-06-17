package com.androiddev.automate;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EVPointsAdapter extends FirebaseRecyclerAdapter<PumpsModel, EVPointsAdapter.myviewholder> {
    PumpsModel model1;

    public EVPointsAdapter(@NonNull FirebaseRecyclerOptions<PumpsModel> options) {
        super(options);
//        this.firebaseRecyclerOptions = options;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull PumpsModel model) {
//        Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
        holder.name.setText(model.getPumpName());
        holder.location.setText(model.getLocation());
        Glide.with(holder.pic.getContext()).load(model.getImg()).into(holder.pic);
        this.model1 = model;
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
//                startActivity(intent);
                Bundle bundle = new Bundle();
                bundle.putString("latKey",model.getLat());
                bundle.putString("lngKey",model.getLng());
                MapsFragment mapsFragment = new MapsFragment();
                mapsFragment.setArguments(bundle);
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame,mapsFragment,"MapsFragment").addToBackStack("MapsFragment").commit();
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());
                progressDialog.setMessage("Maps Loading...");
//                progressDialog.setTitle();
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                },2000);
            }
        });
    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ev_points_layout,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,location;
        ImageView pic;
        CardView card;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
                pic = itemView.findViewById(R.id.bunk_img);
                name = itemView.findViewById(R.id.bunk_name);
                location = itemView.findViewById(R.id.location1);
                card = itemView.findViewById(R.id.card);
//                air = itemView.findViewById(R.id.air1);
//            this.onNoteListener = onNoteListener;
        }
    }
}
