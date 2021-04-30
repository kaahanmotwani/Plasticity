package com.example.myapplication.ui.log;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.HashMap;
import java.util.Objects;

public class LogFragment extends Fragment {

    private LogViewModel logViewModel;
    private TextView count;
    private TextView grams;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //logViewModel =
        //new ViewModelProvider(this).get(LogViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.fragment_log, container, false);
        ViewGroup itemList = root.findViewById(R.id.itemList);

        for (HashMap.Entry<String, Integer> entry : MainActivity.itemInfo.entrySet()) {
            View itemChunk = getLayoutInflater().inflate(R.layout.chunk_log, itemList, false);
            TextView itemName = itemChunk.findViewById(R.id.itemName);
            itemName.setText(entry.getKey());

            count = itemChunk.findViewById(R.id.count);
            count.setText(entry.getValue().toString());

            grams = itemChunk.findViewById(R.id.grams);

            if (entry.getKey().equals("Grocery Bag")) {
                String GBmass = 10 * entry.getValue() + "g";
                grams.setText(GBmass);
            } else if (entry.getKey().equals("Plastic Cutlery")) {
                String PCmass = 20 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Plastic Wrap")) {
                String PCmass = 30 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Dental Floss")) {
                String PCmass = 40 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Bottled Soap")) {
                String PCmass = 50 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Toothpaste")) {
                String PCmass = 60 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Balloon")) {
                String PCmass = 70 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Tape")) {
                String PCmass = 80 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Wrapping Paper")) {
                String PCmass = 90 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Water Bottle")) {
                String PCmass = 100 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Food Wrapper")) {
                String PCmass = 10 * entry.getValue() + "g";
                grams.setText(PCmass);
            } else if (entry.getKey().equals("Plastic Lid")) {
                String PCmass = 120 * entry.getValue() + "g";
                grams.setText(PCmass);
            }

            ImageButton editButton = (ImageButton) itemChunk.findViewById(R.id.edit);


            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog(entry.getKey());
//                    LogFragment fragment = new LogFragment();
//
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.detach(fragment).attach(fragment).commit();
                }
            });

            itemList.addView(itemChunk);
        }




        //final TextView textView = root.findViewById(R.id.log_button);

//        logViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }


    public void openDialog(String itemName) {
        EditLog editLog = new EditLog();
        editLog.setItemName(itemName);
        editLog.show(getParentFragmentManager(), "Edit");
    }

//    @Override
//    public void applyText(String c, String g) {
//        count.setText(c);
//        grams.setText(g);
//    }
}