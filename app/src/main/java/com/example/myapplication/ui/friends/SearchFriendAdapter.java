package com.example.myapplication.ui.friends;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.myapplication.MyDatabaseHelper;
import com.example.myapplication.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SearchFriendAdapter extends BaseAdapter {
    private List<Friend> data;
    private Context context;
    private HashMap<String, Friend> friendHashMap;

    public SearchFriendAdapter(List<Friend> data, Context context, HashMap<String,Friend> fakeFiendHashmap) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.search_friend_item, parent, false);
        }
        Log.e("leo", "getView: " + position);
        TextView userName = convertView.findViewById(R.id.name_found);
        userName.setText(data.get(position).getName());

        Button follow_btn = (Button) convertView.findViewById(R.id.follow_button);
        follow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendHashMap.get(data.get(position).getName()).setFollowed(true);
                data.remove(position); // remove the item from the data list
                notifyDataSetChanged();
            }
        });
        return convertView;
//        return null;
    }
}
