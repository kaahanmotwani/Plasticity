package com.example.myapplication.ui.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditReminderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditReminderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditReminderFragment() {
        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditReminderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditReminderFragment newInstance(String param1, String param2) {
        EditReminderFragment fragment = new EditReminderFragment();
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
        // Inflate the layout for this fragment
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.fragment_edit_reminder, container, false);
        Button btnSave = root.findViewById(R.id.save);
        Button btnDelete = root.findViewById(R.id.delete);
        TimePicker timePicker = root.findViewById(R.id.timepicker);
        EditText reminderName = root.findViewById(R.id.editText);

        String currentReminderName = "";

        try {
            Bundle bundle = this.getArguments();
            reminderName.setText(bundle.getString("name"));
            currentReminderName = bundle.getString("name");
        } catch (Exception e) {

        }

        String copyCurrentReminderName = currentReminderName;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.editLayout,new ReminderFragment());
                fr.commit();

                if (!copyCurrentReminderName.equals(reminderName.getText().toString())) {
                    MainActivity.reminders.remove(copyCurrentReminderName);
                }

                MainActivity.reminders.put(reminderName.getText().toString(), new Reminders(reminderName.getText().toString()));
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.editLayout,new ReminderFragment());
                fr.commit();
                MainActivity.reminders.remove(reminderName.getText().toString());
            }
        });
        return root;
    }

}