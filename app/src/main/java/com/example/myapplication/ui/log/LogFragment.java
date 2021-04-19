package com.example.myapplication.ui.log;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class LogFragment extends Fragment {

    private LogViewModel logViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //logViewModel =
                //new ViewModelProvider(this).get(LogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_log, container, false);

        final TextView sHeader = root.findViewById(R.id.selected_header);
        final TextView rHeader = root.findViewById(R.id.recent_header);
        final TextView kHeader = root.findViewById(R.id.kitchen_header);
        final TextView bHeader = root.findViewById(R.id.bathroom_header);
        final TextView tHeader = root.findViewById(R.id.travel_header);
        final TextView hHeader = root.findViewById(R.id.home_header);

        final TableLayout sTable = root.findViewById(R.id.selected_table_layout);
        final TableLayout rTable = root.findViewById(R.id.recent_table_layout);
        final TableLayout kTable = root.findViewById(R.id.kitchen_table_layout);
        final TableLayout bTable = root.findViewById(R.id.bathroom_table_layout);
        final TableLayout tTable = root.findViewById(R.id.travel_table_layout);
        final TableLayout hTable = root.findViewById(R.id.home_table_layout);

        final TableRow sRow1 = root.findViewById(R.id.sRow1);
        final TableRow sRow2 = root.findViewById(R.id.sRow2);
        final TableRow sRow3 = root.findViewById(R.id.sRow3);

        final ImageButton plasticBag = root.findViewById(R.id.k_imageButton);

        //Adding Items to Selected
//        plasticBag.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (sTable.getChildCount() < 3) {
//                    ImageButton newPlasticBag = new ImageButton(plasticBag.getContext());
//                    sRow1.addView(newPlasticBag);
//                    plasticBag.setVisibility(View.GONE);
//                }
//            }
//        });

        //Hide / Show Tabs
        sHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sTable.getVisibility() == View.VISIBLE) {
                    sTable.setVisibility(View.GONE);
                }
                else if (sTable.getVisibility() == View.GONE) {
                    sTable.setVisibility(View.VISIBLE);
                }
            }
        });

        rHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rTable.getVisibility() == View.VISIBLE) {
                    rTable.setVisibility(View.GONE);
                }
                else if (rTable.getVisibility() == View.GONE) {
                    rTable.setVisibility(View.VISIBLE);
                }
            }
        });

        kHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kTable.getVisibility() == View.VISIBLE) {
                    kTable.setVisibility(View.GONE);
                }
                else if (kTable.getVisibility() == View.GONE) {
                    kTable.setVisibility(View.VISIBLE);
                }
            }
        });

        bHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bTable.getVisibility() == View.VISIBLE) {
                    bTable.setVisibility(View.GONE);
                }
                else if (bTable.getVisibility() == View.GONE) {
                    bTable.setVisibility(View.VISIBLE);
                }
            }
        });

        tHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tTable.getVisibility() == View.VISIBLE) {
                    tTable.setVisibility(View.GONE);
                }
                else if (tTable.getVisibility() == View.GONE) {
                    tTable.setVisibility(View.VISIBLE);
                }
            }
        });

        hHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hTable.getVisibility() == View.VISIBLE) {
                    hTable.setVisibility(View.GONE);
                }
                else if (hTable.getVisibility() == View.GONE) {
                    hTable.setVisibility(View.VISIBLE);
                }
            }
        });

        //final TextView textView = root.findViewById(R.id.log_button);

//        logViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

}