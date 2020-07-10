package com.lgt.nimbus.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.nimbus.Model.DashItems;
import com.lgt.nimbus.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ItemHolder> {
    private List<DashItems> mData;
    private Context mContext;

    public HomeAdapter(List<DashItems> mData,Context context) {
        this.mData = mData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_dashboard_items, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        //holder.iv_categoru_icon.setImageResource(mData.get(position).getColor());
        holder.tv_category.setText(mData.get(position).getTitle());
        holder.iv_categoru_icon.setVisibility(View.VISIBLE);
        if (position==0){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.one));
        }
        if (position==1){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.two));
        }
        if (position==2){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.three));
        }
        if (position==3){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.four));
        }
        if (position==4){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.five));
        }
        if (position==5){
            holder.cv_itemContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.six));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView tv_category, tv_scoreView, tv_extratext, textextratwo;
        ImageView iv_categoru_icon;
        LinearLayout ll_container;
        CardView cv_itemContainer;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_scoreView = itemView.findViewById(R.id.tv_scoreView);
            ll_container = itemView.findViewById(R.id.ll_container);
            iv_categoru_icon = itemView.findViewById(R.id.iv_categoru_icon);
            cv_itemContainer = itemView.findViewById(R.id.cv_itemContainer);
        }

        void setDataToView(){

        }
    }
}
