package com.example.myapplication.ui.friends;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class SearchFriendsFragment extends Fragment {

    private SearchFriendsViewModel searchFriendsViewModel;
    private List<Friend> people_list = new ArrayList<>();
    private MyDatabaseHelper dbHelper;
    private SearchFriendAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

//        dbHelper= new MyDatabaseHelper(container.getContext(), "Users.db", null, 1);
//        dbHelper.getWritableDatabase();

        searchFriendsViewModel =
                new ViewModelProvider(this).get(SearchFriendsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_find_new_friends, container, false);

        Button back2following_btn = (Button) root.findViewById(R.id.back_to_following_btn);
        back2following_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_search_new_friend_Id, new FriendsFragment())
//                        .addToBackStack(null)
                        .commit();
            }
        });

        EditText edittext = (EditText) root.findViewById(R.id.search_friend_input);
        edittext.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if(!s.equals("") ) {
                    //do your work here
                    myAdapter.getFilter().filter(s);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });

        Button search_btn = (Button) root.findViewById(R.id.search_friend_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text_input = (EditText) root.findViewById(R.id.search_friend_input);
                myAdapter.getFilter().filter(text_input.getText().toString());
            }
        });

        HashMap<String, Friend> friendHashMap = ((MainActivity) getActivity()).friendHashMap;
        Iterator iterator = friendHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Friend> entry = (Map.Entry) iterator.next();
            if(!entry.getValue().isFollowed()){
                people_list.add(new Friend(entry.getValue().getName(), entry.getValue().getLevel(), false));
            }
        }
        Collections.sort(this.people_list, (f1, f2) -> (f2.getLevel() - f1.getLevel()));


        ListView listView = root.findViewById(R.id.search_friend_list);

        myAdapter = new SearchFriendAdapter(people_list, container.getContext(), friendHashMap);
        listView.setAdapter(myAdapter);


        return root;
    }



}