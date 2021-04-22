package com.example.myapplication.ui.friends;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.MyDatabaseHelper;
import com.example.myapplication.R;

import java.util.HashMap;
import java.util.List;

public class FriendAdapter extends BaseAdapter {
    private List<Friend> data;
    private Context context;
    private HashMap<String, Friend> friendHashMap;

    public FriendAdapter(List<Friend> data, Context context, HashMap<String,Friend> fakeFiendHashmap) {
        this.data = data;
        this.context = context;
        this.friendHashMap = fakeFiendHashmap;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.my_friend_item, parent, false);
        }
        Log.e("leo", "getView: " + position);
        TextView userName = convertView.findViewById(R.id.name);
        TextView userLevel = convertView.findViewById(R.id.level);
        userName.setText(data.get(position).getName());
        userLevel.setText("L" + data.get(position).getLevel());

        Button unfollow_btn = (Button) convertView.findViewById(R.id.unfollow_btn);
        unfollow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendHashMap.get(data.get(position).getName()).setFollowed(false);
                data.remove(position); // remove the item from the data list
                notifyDataSetChanged();
            }
        });
        return convertView;
//        return null;
    }
}
