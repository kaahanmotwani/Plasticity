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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.myapplication.MainActivity;
import com.example.myapplication.MyDatabaseHelper;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchFriendAdapter extends BaseAdapter implements Filterable {
    private List<Friend> data;
    private List<Friend> dataFiltered;
    private Context context;
    private HashMap<String, Friend> friendHashMap;

    public SearchFriendAdapter(List<Friend> data, Context context, HashMap<String,Friend> fakeFiendHashmap) {
        this.data = data;
        this.dataFiltered = data;
        this.context = context;
        this.friendHashMap = fakeFiendHashmap;
    }

    private void getNewestData(){
        data.clear();
        Iterator iterator = friendHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Friend> entry = (Map.Entry) iterator.next();
            if(!entry.getValue().isFollowed()){
                data.add(new Friend(entry.getValue().getName(), entry.getValue().getLevel(), false));
            }
        }
        Collections.sort(this.data, (f1, f2) -> (f2.getLevel() - f1.getLevel()));
    }

    @Override
    public int getCount() {
        return dataFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return dataFiltered.get(position);
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
        userName.setText(dataFiltered.get(position).getName());

        Button follow_btn = (Button) convertView.findViewById(R.id.follow_button);
        follow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendHashMap.get(dataFiltered.get(position).getName()).setFollowed(true);
//                data.remove(position); // remove the item from the data list
                dataFiltered.remove(position); // remove the item from the data list
                notifyDataSetChanged();
            }
        });
        return convertView;
//        return null;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataFiltered = (List<Friend>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                getNewestData();

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = data.size();
                    filterResults.values = data;
                } else {
                    String searchStr = constraint.toString().toLowerCase();
                    List<Friend> resultData = new ArrayList<>();
                    for (Friend friend : data) {
                        if (friend.getName().toLowerCase().contains(searchStr)) {
                            resultData.add(friend);
                        }
                    }

                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }

                return filterResults;
            }
        };
        return filter;
    }
}
