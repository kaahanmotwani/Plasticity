package com.example.myapplication.ui.add.add;
import com.example.myapplication.R;

import android.view.View;
import android.widget.TextView;

public class ItemViewHolder {

    TextView itemTitle;
    ItemViewHolder(View v)
    {
        itemTitle = v.findViewById(R.id.textView);
    }
}
