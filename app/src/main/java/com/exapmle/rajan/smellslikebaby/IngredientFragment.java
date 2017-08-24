package com.exapmle.rajan.smellslikebaby;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IngredientFragment extends Fragment {
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
        Toast.makeText(getActivity(),Integer.toString(index),Toast.LENGTH_LONG).show();
        View view=inflater.inflate(R.layout.activity_ingredient_fragment,container,false);

        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.ingredintLayout);
        String ingredient[]=Recipies.ingredients[index].split("`");

        checked=new boolean[ingredient.length];
        mCheckBox=new CheckBox[ingredient.length];
        current=new boolean[ingredient.length];

        TextView tv=new TextView(getActivity());
        CheckBox checkBox=new CheckBox(getActivity());

        if(savedInstanceState!=null && savedInstanceState.getBooleanArray(key)!=null) {
            current=savedInstanceState.getBooleanArray(key);
        }
        addCheckBoxes(linearLayout, ingredient, current);

        return view;
    }

    private void addCheckBoxes(LinearLayout linearLayout, String[] ingredient, boolean[] booleanArray) {
       // if(savedInstanceState!=null)
        for(int i = 0; i<ingredient.length; i++){
            mCheckBox[i]=new CheckBox(getActivity());
            mCheckBox[i].setText(ingredient[i]);
            mCheckBox[i].setPadding(10,10,10,10);
            mCheckBox[i].setTextSize(20f);
            if(booleanArray[i]) {
                mCheckBox[i].toggle();

            }
            linearLayout.addView(mCheckBox[i], i);
        }
    }
}
