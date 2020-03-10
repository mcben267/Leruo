package com.dev.alpha.leruo;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class AgentsAdapter extends RecyclerView.Adapter<AgentsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Profile> profiles;

     AgentsAdapter(Context c , ArrayList<Profile> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_model,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.name.setText(profiles.get(position).getName());
       //holder.location.setText(profiles.get(position).getLocation());
       // holder.contact.setText(profiles.get(position).getContact());
        //Picasso.get().load(profiles.get(position).getProfilePic()).into(holder.profilePic);
        //if(profiles.get(position).getPermission()) {
          //  holder.btn.setVisibility(View.VISIBLE);
            //holder.onClick(position);
        //}

        Profile profile  = profiles.get(position);

        TextView name,location,contact;
        ImageView profilePic = holder.profilePic;
        CardView btn;

        name = holder.name;
        location = holder.location;
        contact = holder.contact;

        profilePic.setImageResource(profile.getProfilePic());
        name.setText(profile.getName());
        location.setText(profile.getLocation());
        contact.setText(profile.getContact());


    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,location,contact;
        ImageView profilePic;
        CardView btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            location = (TextView) itemView.findViewById(R.id.locationTextView);
            contact = (TextView) itemView.findViewById(R.id.contactTextView);
            profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
            btn = (CardView) itemView.findViewById(R.id.agentCardView);
        }
        public void onClick(final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}