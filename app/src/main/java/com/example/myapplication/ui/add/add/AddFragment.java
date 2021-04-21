package com.example.myapplication.ui.add.add;

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

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //addViewModel =
        //new ViewModelProvider(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        //Headers
        final TextView sHeader = root.findViewById(R.id.selected_header);
        final TextView rHeader = root.findViewById(R.id.recent_header);
        final TextView kHeader = root.findViewById(R.id.kitchen_header);
        final TextView bHeader = root.findViewById(R.id.bathroom_header);
        final TextView tHeader = root.findViewById(R.id.travel_header);
        final TextView hHeader = root.findViewById(R.id.home_header);

        //Item Tables
        final TableLayout sTable = root.findViewById(R.id.selected_table_layout);
        final TableLayout rTable = root.findViewById(R.id.recent_table_layout);
        final TableLayout kTable = root.findViewById(R.id.kitchen_table_layout);
        final TableLayout bTable = root.findViewById(R.id.bathroom_table_layout);
        final TableLayout tTable = root.findViewById(R.id.travel_table_layout);
        final TableLayout hTable = root.findViewById(R.id.home_table_layout);

        //Static Rows
        final TableRow sRow1 = root.findViewById(R.id.sRow1);
        final TableRow sRow2 = root.findViewById(R.id.sRow2);
        final TableRow sRow3 = root.findViewById(R.id.sRow3);

        final TableRow rRow1 = root.findViewById(R.id.rRow1);
        final TableRow rRow2 = root.findViewById(R.id.rRow2);
        final TableRow rRow3 = root.findViewById(R.id.rRow3);

        //Item ImageButtons
        final ImageButton groceryBag = root.findViewById(R.id.k_grocery_bag);
        final ImageButton cutlery = root.findViewById(R.id.k_cutlery);
        final ImageButton plasticWrap = root.findViewById(R.id.k_plastic_wrap);
        final ImageButton dentalFloss = root.findViewById(R.id.b_dental_floss);
        final ImageButton soapShampoo = root.findViewById(R.id.b_soap_and_shampoo);
        final ImageButton toothpaste = root.findViewById(R.id.b_toothpaste);
        final ImageButton balloon = root.findViewById(R.id.h_balloon);
        final ImageButton tape = root.findViewById(R.id.h_tape);
        final ImageButton wrappingPaper = root.findViewById(R.id.h_wrapping_paper);
        final ImageButton bottle = root.findViewById(R.id.t_plastic_bottle);
        final ImageButton wrapper = root.findViewById(R.id.t_plastic_wrapper);
        final ImageButton lid = root.findViewById(R.id.t_plastic_lids);


        //Adding Items to Selected
        groceryBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(groceryBag.getContext());
                newItem.setLayoutParams(groceryBag.getLayoutParams());
                newItem.setImageDrawable(groceryBag.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        cutlery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(cutlery.getContext());
                newItem.setLayoutParams(cutlery.getLayoutParams());
                newItem.setImageDrawable(cutlery.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        plasticWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(plasticWrap.getContext());
                newItem.setLayoutParams(plasticWrap.getLayoutParams());
                newItem.setImageDrawable(plasticWrap.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0,0,0,0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        dentalFloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(dentalFloss.getContext());
                newItem.setLayoutParams(dentalFloss.getLayoutParams());
                newItem.setImageDrawable(dentalFloss.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        soapShampoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(soapShampoo.getContext());
                newItem.setLayoutParams(soapShampoo.getLayoutParams());
                newItem.setImageDrawable(soapShampoo.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        toothpaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(toothpaste.getContext());
                newItem.setLayoutParams(toothpaste.getLayoutParams());
                newItem.setImageDrawable(toothpaste.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0,0,0,0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        balloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(balloon.getContext());
                newItem.setLayoutParams(balloon.getLayoutParams());
                newItem.setImageDrawable(balloon.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        tape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(tape.getContext());
                newItem.setLayoutParams(tape.getLayoutParams());
                newItem.setImageDrawable(tape.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        wrappingPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(wrappingPaper.getContext());
                newItem.setLayoutParams(wrappingPaper.getLayoutParams());
                newItem.setImageDrawable(wrappingPaper.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0,0,0,0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(bottle.getContext());
                newItem.setLayoutParams(bottle.getLayoutParams());
                newItem.setImageDrawable(bottle.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(wrapper.getContext());
                newItem.setLayoutParams(wrapper.getLayoutParams());
                newItem.setImageDrawable(wrapper.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0, 0, 0, 0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });

        lid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton newItem = new ImageButton(lid.getContext());
                newItem.setLayoutParams(lid.getLayoutParams());
                newItem.setImageDrawable(lid.getDrawable());
                newItem.setBackground(null);
                newItem.setPadding(0,0,0,0);

                if (sRow1.getChildCount() < 3) { sRow1.addView(newItem); }
                else if (sRow2.getChildCount() < 3) { sRow2.addView(newItem); }
                else if (sRow3.getChildCount() < 3) { sRow3.addView(newItem); }

//                if (rRow1.getChildCount() < 3) { rRow1.addView(newPlasticBag); }
//                else if (rRow2.getChildCount() < 3) { rRow2.addView(newPlasticBag); }
//                else if (rRow3.getChildCount() < 3) { rRow3.addView(newPlasticBag); }

                newItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TableRow)newItem.getParent()).removeView(newItem);
                    }
                });
            }
        });


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

//        addViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

}