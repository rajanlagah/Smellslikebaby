package com.exapmle.rajan.smellslikebaby;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class pagerFragment extends Fragment {
    private static final String INGEREDIENT_KEY = "Ingeredient_key";
    public int index;

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        index=getArguments().getInt("index");
        getActivity().setTitle(Recipies.names[index]);
        View v=inflater.inflate(R.layout.activity_pager_fragment,container,false);

        final IngredientFragment ingredientFragment=new IngredientFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(INGEREDIENT_KEY,index);

        ingredientFragment.setArguments(bundle);
        final DirectionFragment directionFragment=new DirectionFragment();
        bundle=new Bundle();
        bundle.putInt(INGEREDIENT_KEY,index);
        directionFragment.setArguments(bundle);

        ViewPager viewPager= (ViewPager) v.findViewById(R.id.fragNext);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return position==0 ?ingredientFragment:directionFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"ingredients":"diretions";

            }
        });

        TabLayout layout= (TabLayout) v.findViewById(R.id.tabLayOut);
        layout.setupWithViewPager(viewPager);

        return v;
    }
}
