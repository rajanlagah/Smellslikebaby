package com.exapmle.rajan.smellslikebaby;


//u have to import same fragment and fragment manager to add "fragmentTransaction.addToBackStack(null);"
// we use support

// if we go to next fragment and rorate it app will crash so we use getFragmentByTag(,,[tagName])

// bundel is use to send non primitive data from one activity to another

//we use button click listener in bindViewMenthod

//to set title of new fragment to same as recipie name we first create bundel and put int(index) in it on OnClicklistener and listFragment.setArgumanet(bundel)
//on pagerFragment we getArgument(tag) and getAvtivity().setTitle(Recipes.Name[index])

// but the title in action bar remain same so to change that we override onStop method in fragment and setTitle to appName


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String Recipi_Name="Recipies";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTab=getResources().getBoolean(R.bool.is_tablet);

        //ListFragment listFragment= new ListFragment();
        //ListFragment listFragment=new ListFragment();
        Toast.makeText(this,"fsd", Toast.LENGTH_LONG).show();


        //for fragment not t b created again and again on rotation

        if(!isTab) {
            Fragment savedfragment= getSupportFragmentManager()
                    .findFragmentByTag(Recipi_Name);
            if (savedfragment == null) {
                fragmentList listFragment = new fragmentList(getSupportFragmentManager());
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, listFragment, Recipi_Name);
                fragmentTransaction.commit();
            }
        }
        else{
            Toast.makeText(MainActivity.this,"grid",Toast.LENGTH_LONG).show();
            GridFragment savedfragment= (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(Recipi_Name);

            if (savedfragment == null) {
                GridFragment listFragment = new GridFragment(getSupportFragmentManager());
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, listFragment, Recipi_Name);
                fragmentTransaction.commit();
            }

        }
    }
    public void OnListRecipeSelected(int index) {
        Toast.makeText(this, "sds", Toast.LENGTH_SHORT).show();

    }

}
