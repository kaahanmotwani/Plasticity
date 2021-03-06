package com.example.myapplication.ui.goals;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddGoalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddGoalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddGoalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddGoalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddGoalFragment newInstance(String param1, String param2) {
        AddGoalFragment fragment = new AddGoalFragment();
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

        View root = inflater.inflate(R.layout.fragment_add_goal, container, false);
        Button submitGoal = root.findViewById(R.id.submitGoal);
        EditText goalName = root.findViewById(R.id.setGoalName);
        EditText goalNotes = root.findViewById(R.id.setGoalNotes);

        String currentGoalName = "";

        try {
            Bundle bundle = this.getArguments();
            goalName.setText(bundle.getString("name"));
            goalNotes.setText(bundle.getString("notes"));
            currentGoalName = bundle.getString("name");
        } catch (Exception ignored) {

        }

        // Onclick for add button
        String copyCurrentGoalName = currentGoalName;
        submitGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoalsFragment fragment = new GoalsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.addGoalLayout, fragment);
                fragmentTransaction.commit();

                if (!copyCurrentGoalName.equals(goalName.getText().toString())) {
                    MainActivity.goals.remove(copyCurrentGoalName);
                }

                MainActivity.goals.put(goalName.getText().toString(), new Goal(goalName.getText().toString(), goalNotes.getText().toString()));
            }
        });

        Button cancelGoal = root.findViewById(R.id.cancelGoal);

        // Onclick for add button
        cancelGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoalsFragment fragment = new GoalsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.addGoalLayout, fragment);
                fragmentTransaction.commit();

                MainActivity.goals.remove(goalName.getText().toString());
            }
        });

        // Inflate the layout for this fragment
        return root;
    }
}