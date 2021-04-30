package com.example.myapplication.ui.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReminderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReminderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReminderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReminderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReminderFragment newInstance(String param1, String param2) {
        ReminderFragment fragment = new ReminderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_reminder, container, false);
        ViewGroup reminderList = root.findViewById(R.id.reminderList);
        for (HashMap.Entry<String,Reminders> entry : MainActivity.reminders.entrySet()) {
            View reminderChunk = getLayoutInflater().inflate(R.layout.chunk_reminder, reminderList, false);
            TextView reminderName = reminderChunk.findViewById(R.id.reminderName);
            reminderName.setText(entry.getValue().getName());
            reminderList.addView(reminderChunk);
            ImageButton editButton = root.findViewById(R.id.editReminder);


            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditReminderFragment fragment = new EditReminderFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", entry.getKey());
                    //bundle.putString("name",entry.getValue().getName());
                    fragment.setArguments(bundle);

                    FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                    fr.replace(R.id.reminderfrag, fragment);
                    fr.commit();



                }
            });

        }

        Button btnadd_new = root.findViewById(R.id.btnAddNew);
        btnadd_new.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.reminderfrag,new EditReminderFragment());
                fr.commit();
            }
        });
        return root;
    }
}