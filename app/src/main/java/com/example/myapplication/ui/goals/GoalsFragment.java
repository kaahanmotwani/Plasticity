package com.example.myapplication.ui.goals;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.add.add.AddFragment;
import com.example.myapplication.ui.log.LogFragment;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class GoalsFragment extends Fragment {

    private GoalsViewModel goalsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.fragment_goals, container, false);
        ViewGroup goalsList = root.findViewById(R.id.goalsList);
//        goals.add("test");
//        View goalChunk = getLayoutInflater().inflate(R.layout.chunk_goal, goalsList, false);
//        TextView goalName = goalChunk.findViewById(R.id.goalName);
//        goalName.setText(goals.get(0));
//        goalsList.addView(goalChunk);
//        Log.i("tag", goals.get(0));

        for (HashMap.Entry<String,Goal> entry : MainActivity.goals.entrySet()) {
            View goalChunk = getLayoutInflater().inflate(R.layout.chunk_goal, goalsList, false);
            TextView goalName = goalChunk.findViewById(R.id.goalName);
            goalName.setText(entry.getValue().getName());
            goalsList.addView(goalChunk);

            ImageButton editButton = goalChunk.findViewById(R.id.edit);


            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddGoalFragment fragment = new AddGoalFragment();

                    Bundle bundle = new Bundle();
                    bundle.putString("name", entry.getKey());
                    bundle.putString("notes", entry.getValue().getNotes());
                    fragment.setArguments(bundle);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.goalsId, fragment);
                    fragmentTransaction.commit();



                }
            });

        }
        goalsViewModel =
                new ViewModelProvider(this).get(GoalsViewModel.class);


        //ViewGroup goalsList = root.findViewById(R.id.goalsList);

        Button addGoals = root.findViewById(R.id.add_goal);
        // Onclick for add button
        addGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddGoalFragment fragment = new AddGoalFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.goalsId, fragment);
                //fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
//                View goalChunk = getLayoutInflater().inflate(R.layout.chunk_goal, goalsList, false);
//                TextView goalName = goalChunk.findViewById(R.id.goalName);
//                goalName.setText("Test");
//
//                goalsList.addView(goalChunk);
            }
        });



        return root;
    }


}