package com.exapmle.rajan.smellslikebaby;





import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rajan on 17-08-2017.
 */

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> implements View.OnClickListener{
    private Activity mActivity;
    public static final String Viwer_Page="Viiew_recipie";

    public android.support.v4.app.FragmentManager mFragmentManager;


    public adapter(FragmentActivity activity, android.support.v4.app.FragmentManager fragmentManager) {
        mActivity=activity;
        mFragmentManager=fragmentManager;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.BindView(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(mActivity, Recipies.names[position], Toast.LENGTH_SHORT).show();
                    pagerFragment listFragment = new pagerFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("index",position);
                    listFragment.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager = mFragmentManager;
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.placeHolder,listFragment,Viwer_Page);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
            }
        });
    }



    @Override
    public int getItemCount() {
        return Recipies.names.length;
    }

    @Override
    public void onClick(View v) {

    }


    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        private TextView recipiName;
       private ImageView mImageView;
        private int mIndex=0;

        ViewHolder(View itemView) {
            super(itemView);
            recipiName=(TextView)itemView.findViewById(R.id.recipeName);
            mImageView=(ImageView)itemView.findViewById(R.id.image);
            mIndex=0;
        }

        void BindView(int position){
           // recipiName.setText("da");
            mIndex=position;
            recipiName.setText(Recipies.names[position]);
            mImageView.setImageResource(Recipies.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
