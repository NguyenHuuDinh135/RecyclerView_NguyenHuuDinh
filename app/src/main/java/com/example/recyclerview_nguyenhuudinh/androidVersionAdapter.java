package com.example.recyclerview_nguyenhuudinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class androidVersionAdapter extends RecyclerView.Adapter < androidVersionAdapter.Viewholder > {
    // array list to store all items
    private ArrayList < androidVersion > androidList;
    // object of type ItemClicked to get our mainActivity using context passed in androidVersionAdapter
    ItemClicked activity;
    //set an interface
    public interface ItemClicked {
        void onItemClicked(int index);
    }
    //in this we will set our context i.e. mainActivity to activity object and arrayList
    public androidVersionAdapter(Context context, ArrayList < androidVersion > List) {
        androidList = List; //arrayList
        activity = (ItemClicked) context; //mainActivity reference
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView ivicon; //for imageView icon
        TextView tvnam, tvversion; //for textView name and version of android
        //declate viewholder
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvnam = itemView.findViewById(R.id.tvnam); //find and set android name TextView
            tvversion = itemView.findViewById(R.id.tvversion); //find and set android version textView
            ivicon = itemView.findViewById(R.id.ivicon); //find and set android icon ImageView
        }
    }
    //onCreateViewHolder method to return and set Viewholder
    @NonNull
    @Override
    public androidVersionAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new Viewholder(v); //return viewholder
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        androidVersion item = androidList.get(position);

        holder.tvnam.setText(item.getName());
        holder.tvversion.setText(item.getVersion());

        switch (item.getPrefer()) {
            case "iphone":
                holder.ivicon.setImageResource(R.drawable.iphone);
                break;
            case "samsung":
                holder.ivicon.setImageResource(R.drawable.samsung);
                break;
            case "macbook":
                holder.ivicon.setImageResource(R.drawable.macbook);
                break;
            case "hp":
                holder.ivicon.setImageResource(R.drawable.hp);
                break;
            case "xiaomi":
                holder.ivicon.setImageResource(R.drawable.xiaomi);
                break;
            case "dell":
                holder.ivicon.setImageResource(R.drawable.dell);
                break;
            case "ipad":
                holder.ivicon.setImageResource(R.drawable.ipad);
                break;
            case "tab":
                holder.ivicon.setImageResource(R.drawable.tab);
                break;
            case "lenovo":
                holder.ivicon.setImageResource(R.drawable.lenovo);
                break;
            default:
                holder.ivicon.setImageResource(R.drawable.android_donut); // icon mặc định
                break;
        }

        holder.itemView.setOnClickListener(v -> activity.onItemClicked(position));
    }

    //getItemCount method for returning the size of arrayList
    @Override
    public int getItemCount() {
        return androidList.size();
    }

}