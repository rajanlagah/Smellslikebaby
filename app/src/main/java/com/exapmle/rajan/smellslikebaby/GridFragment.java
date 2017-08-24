package com.exapmle.rajan.smellslikebaby;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rajan on 24-08-2017.
 */

public class GridFragment extends Fragment {
    public GridFragment(){}
    android.support.v4.app.FragmentManager mFragmentManager;
    public RecyclerView mRecyclerView;
    public GridFragment(android.support.v4.app.FragmentManager supportFragmentManager){
        mFragmentManager=supportFragmentManager;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //false becuse fragment is automatically attach to view group if we set it true the fragment will b added twice
        View v=inflater.inflate(R.layout.fragment_list,container,false);

        mRecyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);
        adapter ad=new adapter(getActivity(),mFragmentManager);
        mRecyclerView.setAdapter(ad);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        return v;
    }

}
