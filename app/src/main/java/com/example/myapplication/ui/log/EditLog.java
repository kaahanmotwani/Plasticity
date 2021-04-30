package com.example.myapplication.ui.log;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class EditLog extends AppCompatDialogFragment {
    private EditText editTextCount;
    //private EditText editTextGrams;
    private String e_itemName;
    private LogDialogListener listener;

    public void setItemName(String itemName) {
        this.e_itemName = itemName;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Edit")
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.itemInfo.remove(e_itemName);
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String count = editTextCount.getText().toString();
                        //String grams = editTextGrams.getText().toString();
                        //listener.applyText(count, grams);

                        MainActivity.itemInfo.put(e_itemName, Integer.parseInt(count));
                    }
                });
        editTextCount = view.findViewById(R.id.edit_count);
        //editTextGrams = view.findViewById(R.id.edit_grams);

        return builder.create();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        try {
//            listener = (LogDialogListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + " must implement LogDialogListener");
//        }
//    }

    public interface LogDialogListener{
        void applyText(String count, String grams);
    }

}
