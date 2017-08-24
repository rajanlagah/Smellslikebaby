package com.exapmle.rajan.smellslikebaby;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class DirectionFragment extends Fragment {
    public boolean checked[];
    public boolean current[];
    public CheckBox mCheckBox[];
    public static final String key="array_boolean";
    @Override
    public void onSaveInstanceState(Bundle outState) {
        for(int i=0;i<mCheckBox.length;i++){
            checked[i]=mCheckBox[i].isChecked();
        }
        outState.putBooleanArray(key,checked);
        super.onSaveInstanceState(outState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle b1=getArguments();
        int index=b1.getInt("Ingeredient_key");

        String direction[]=Recipies.directions[index].split("`");
        checked=new boolean[direction.length];
        mCheckBox=new CheckBox[direction.length];
        current=new boolean[direction.length];

        View view=inflater.inflate(R.layout.activity_direction_fragment,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.DirectionLinear);
        if(savedInstanceState!=null && savedInstanceState.getBooleanArray(key)!=null) {
            current=savedInstanceState.getBooleanArray(key);
        }
        addCheckBoxes(linearLayout, direction, current);

        return view;
    }
    private void addCheckBoxes(LinearLayout linearLayout, String[] direction, boolean[] booleanArray) {
        // if(savedInstanceState!=null)
        for(int i = 0; i<direction.length; i++){
            mCheckBox[i]=new CheckBox(getActivity());
            mCheckBox[i].setText(direction[i]);
            mCheckBox[i].setPadding(10,10,10,10);
            mCheckBox[i].setTextSize(20f);
            if(booleanArray[i]) {
                mCheckBox[i].toggle();

            }
            linearLayout.addView(mCheckBox[i], i);
        }
    }
}
