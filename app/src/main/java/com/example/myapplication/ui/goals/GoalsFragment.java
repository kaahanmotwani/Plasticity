package com.example.myapplication.ui.goals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class GoalsFragment extends Fragment {

    private GoalsViewModel goalsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        goalsViewModel =
                new ViewModelProvider(this).get(GoalsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_goals, container, false);

        ViewGroup goalsList = root.findViewById(R.id.goalsList);

        Button addGoals = root.findViewById(R.id.add_goal);
        addGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View goalChunk = getLayoutInflater().inflate(R.layout.chunk_goal, goalsList, false);
                TextView goalName = goalChunk.findViewById(R.id.goalName);
                goalName.setText("Test");

                goalsList.addView(goalChunk);
            }
        });
        return root;
    }
}