package com.example.myapplication.ui.friends;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.MyDatabaseHelper;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class FriendsFragment extends Fragment {
    private FriendsViewModel friendsViewModel;
    private List<Friend> following = new ArrayList<>();
    private Button find_friend_btn;
    private MyDatabaseHelper dbHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

//        dbHelper= new MyDatabaseHelper(container.getContext(), "Users.db", null, 1);
//        dbHelper.getWritableDatabase();

        friendsViewModel =
                new ViewModelProvider(this).get(FriendsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_friends, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        friendsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        find_friend_btn = (Button) root.findViewById(R.id.find_friend_btn);
        find_friend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.friend_fragment_Id, new SearchFriendsFragment())
//                        .addToBackStack(null)
                        .commit();
            }
        });

        HashMap<String, Friend> friendHashMap = ((MainActivity) getActivity()).friendHashMap;
        Iterator iterator = friendHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Friend> entry = (Map.Entry) iterator.next();
            if(entry.getValue().isFollowed()){
                following.add(new Friend(entry.getValue().getName(), entry.getValue().getLevel(), true));
            }
        }
        Collections.sort(this.following, (f1, f2) -> (f2.getLevel() - f1.getLevel()));

        ListView listView = root.findViewById(R.id.friendList);

        BaseAdapter myAdapter = new FriendAdapter(following, container.getContext(), friendHashMap);
        listView.setAdapter(myAdapter);

        return root;
    }



}