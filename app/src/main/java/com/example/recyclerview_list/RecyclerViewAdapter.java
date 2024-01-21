package com.example.recyclerview_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

//private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames ;
    private ArrayList<String> mImages;
    private ArrayList<String> mType;
    private Context mContext;
//    private ArrayList<String> mLinks;


    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> type) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        mType = type;
//        mLinks= links;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // Log.d(TAG, "onBindViewHolder: called.");


        holder.imageName.setText(mImageNames.get(position));
        holder.image_name2.setText(mType.get(position));
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle item click, for example, open a new activity or a link
//                String artistLink = getArtistLink(position);
//                openLink(artistLink);
//            }
//        });
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);


    }

//    private void openLink(String artistLink) {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        // Set the data (the URL) for the Intent
//        intent.setData(Uri.parse(artistLink));
//
//        // Check if there is an app to handle the Intent
//        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
//            // Start the activity with the Intent
//            mContext.startActivity(intent);
//        } else {
//            // If no app can handle the Intent, you may want to handle this case accordingly
//            // For example, show a toast or display a message to the user
//            Toast.makeText(mContext, "No app to handle the link", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName,image_name2;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            image_name2 = itemView.findViewById(R.id.image_name2);




        }
    }

//    private String getArtistLink(int position) {
//
//        return mLinks.get(position);
//    }
}