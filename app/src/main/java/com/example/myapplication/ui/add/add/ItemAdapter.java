package com.example.myapplication.ui.add.add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;


public class ItemAdapter extends ArrayAdapter<String> {
    Context context;
    String[] itemName;

    public ItemAdapter(Context context, String[] itemName) {
        super(context, R.layout.single_item, R.id.textView, itemName);
        this.context = context;
        this.itemName = itemName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        ItemViewHolder holder = null;
        if(singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item, parent, false);
            holder = new ItemViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else {
            holder = (ItemViewHolder) singleItem.getTag();
        }
        holder.itemTitle.setText(itemName[position]);

        View finalSingleItem = singleItem;
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TableRow sRow1 = finalSingleItem.getRootView().findViewById(R.id.sRow1);
                final TableRow sRow2 = finalSingleItem.getRootView().findViewById(R.id.sRow2);
                final TableRow sRow3 = finalSingleItem.getRootView().findViewById(R.id.sRow3);

                if (itemName[position].equals("Grocery Bag")) {

                    final ImageButton groceryBag = finalSingleItem.getRootView().findViewById(R.id.k_grocery_bag);
                    if (MainActivity.itemInfo.get("Grocery Bag") != null) {
                        MainActivity.itemInfo.put("Grocery Bag", MainActivity.itemInfo.get("Grocery Bag")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Grocery Bag", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Grocery Bag") == 1) {
                                MainActivity.itemInfo.remove("Grocery Bag");
                            }
                            else {
                                MainActivity.itemInfo.put("Grocery Bag", MainActivity.itemInfo.get("Grocery Bag")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Plastic Cutlery")) {
                    final ImageButton cutlery = finalSingleItem.getRootView().findViewById(R.id.k_cutlery);
                    if (MainActivity.itemInfo.get("Plastic Cutlery") != null) {
                        MainActivity.itemInfo.put("Plastic Cutlery", MainActivity.itemInfo.get("Plastic Cutlery")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Plastic Cutlery", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Plastic Cutlery") == 1) {
                                MainActivity.itemInfo.remove("Plastic Cutlery");
                            }
                            else {
                                MainActivity.itemInfo.put("Plastic Cutlery", MainActivity.itemInfo.get("Plastic Cutlery")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Plastic Wrap")) {

                    final ImageButton plasticWrap = finalSingleItem.getRootView().findViewById(R.id.k_plastic_wrap);
                    if (MainActivity.itemInfo.get("Plastic Wrap") != null) {
                        MainActivity.itemInfo.put("Plastic Wrap", MainActivity.itemInfo.get("Plastic Wrap")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Plastic Wrap", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Plastic Wrap") == 1) {
                                MainActivity.itemInfo.remove("Plastic Wrap");
                            }
                            else {
                                MainActivity.itemInfo.put("Plastic Wrap", MainActivity.itemInfo.get("Plastic Wrap")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });

                } else if (itemName[position].equals("Dental Floss")) {
                    final ImageButton dentalFloss = finalSingleItem.getRootView().findViewById(R.id.b_dental_floss);
                    if (MainActivity.itemInfo.get("Dental Floss") != null) {
                        MainActivity.itemInfo.put("Dental Floss", MainActivity.itemInfo.get("Dental Floss")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Dental Floss", 1);
                    }

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

                            if (MainActivity.itemInfo.get("Dental Floss") == 1) {
                                MainActivity.itemInfo.remove("Dental Floss");
                            }
                            else {
                                MainActivity.itemInfo.put("Dental Floss", MainActivity.itemInfo.get("Dental Floss")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Bottled Soap")) {
                    final ImageButton soapShampoo = finalSingleItem.getRootView().findViewById(R.id.b_soap_and_shampoo);
                    if (MainActivity.itemInfo.get("Bottled Soap") != null) {
                        MainActivity.itemInfo.put("Bottled Soap", MainActivity.itemInfo.get("Bottled Soap")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Bottled Soap", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Bottled Soap") == 1) {
                                MainActivity.itemInfo.remove("Bottled Soap");
                            }
                            else {
                                MainActivity.itemInfo.put("Bottled Soap", MainActivity.itemInfo.get("Bottled Soap")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Toothpaste")) {
                    final ImageButton toothpaste = finalSingleItem.getRootView().findViewById(R.id.b_toothpaste);
                    if (MainActivity.itemInfo.get("Toothpaste") != null) {
                        MainActivity.itemInfo.put("Toothpaste", MainActivity.itemInfo.get("Toothpaste")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Toothpaste", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Toothpaste") == 1) {
                                MainActivity.itemInfo.remove("Toothpaste");
                            }
                            else {
                                MainActivity.itemInfo.put("Toothpaste", MainActivity.itemInfo.get("Toothpaste")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Balloon")) {
                    final ImageButton balloon = finalSingleItem.getRootView().findViewById(R.id.h_balloon);
                    if (MainActivity.itemInfo.get("Balloon") != null) {
                        MainActivity.itemInfo.put("Balloon", MainActivity.itemInfo.get("Balloon")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Balloon", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Balloon") == 1) {
                                MainActivity.itemInfo.remove("Balloon");
                            }
                            else {
                                MainActivity.itemInfo.put("Balloon", MainActivity.itemInfo.get("Balloon")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Tape")) {
                    final ImageButton tape = finalSingleItem.getRootView().findViewById(R.id.h_tape);
                    if (MainActivity.itemInfo.get("Tape") != null) {
                        MainActivity.itemInfo.put("Tape", MainActivity.itemInfo.get("Tape")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Tape", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Tape") == 1) {
                                MainActivity.itemInfo.remove("Tape");
                            }
                            else {
                                MainActivity.itemInfo.put("Tape", MainActivity.itemInfo.get("Tape")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Wrapping Paper")) {
                    final ImageButton wrappingPaper = finalSingleItem.getRootView().findViewById(R.id.h_wrapping_paper);
                    if (MainActivity.itemInfo.get("Wrapping Paper") != null) {
                        MainActivity.itemInfo.put("Wrapping Paper", MainActivity.itemInfo.get("Wrapping Paper")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Wrapping Paper", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Wrapping Paper") == 1) {
                                MainActivity.itemInfo.remove("Wrapping Paper");
                            }
                            else {
                                MainActivity.itemInfo.put("Wrapping Paper", MainActivity.itemInfo.get("Wrapping Paper")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Water Bottle")) {
                    final ImageButton bottle = finalSingleItem.getRootView().findViewById(R.id.t_plastic_bottle);
                    if (MainActivity.itemInfo.get("Water Bottle") != null) {
                        MainActivity.itemInfo.put("Water Bottle", MainActivity.itemInfo.get("Water Bottle")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Water Bottle", 1);
                    }

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

                            if (MainActivity.itemInfo.get("Water Bottle") == 1) {
                                MainActivity.itemInfo.remove("Water Bottle");
                            }
                            else {
                                MainActivity.itemInfo.put("Water Bottle", MainActivity.itemInfo.get("Water Bottle")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Food Wrapper")) {
                    final ImageButton wrapper = finalSingleItem.getRootView().findViewById(R.id.t_plastic_wrapper);
                    if (MainActivity.itemInfo.get("Food Wrapper") != null) {
                        MainActivity.itemInfo.put("Food Wrapper", MainActivity.itemInfo.get("Food Wrapper")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Food Wrapper", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Food Wrapper") == 1) {
                                MainActivity.itemInfo.remove("Food Wrapper");
                            }
                            else {
                                MainActivity.itemInfo.put("Food Wrapper", MainActivity.itemInfo.get("Food Wrapper")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                } else if (itemName[position].equals("Plastic Lid")) {
                    final ImageButton lid = finalSingleItem.getRootView().findViewById(R.id.t_plastic_lids);
                    if (MainActivity.itemInfo.get("Plastic Lid") != null) {
                        MainActivity.itemInfo.put("Plastic Lid", MainActivity.itemInfo.get("Plastic Lid")+1);
                    }
                    else {
                        MainActivity.itemInfo.put("Plastic Lid", 1);
                    }

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
                            if (MainActivity.itemInfo.get("Plastic Lid") == 1) {
                                MainActivity.itemInfo.remove("Plastic Lid");
                            }
                            else {
                                MainActivity.itemInfo.put("Plastic Lid", MainActivity.itemInfo.get("Plastic Lid")-1);
                            }
                            ((TableRow)newItem.getParent()).removeView(newItem);
                        }
                    });


                }
            }
        });
        return singleItem;
    }
}
