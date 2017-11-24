package com.example.ratha.rathanarestuarant.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.rathanarestuarant.R;
import com.example.ratha.rathanarestuarant.entity.Category;
import com.example.ratha.rathanarestuarant.ui.dialog.CreateCategoryDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ratha on 11/23/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private Context context;
    private List<Category> list;
    CreateCategoryDialog.CallBack callBack;
    public CategoryAdapter(Context context,List<Category> list){
        this.context=context;
        this.list=list;
        callBack= (CreateCategoryDialog.CallBack) context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup viewGroup=(ViewGroup) LayoutInflater.from(context).inflate(R.layout.category_item_layout,parent,false);
        return new ViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(null!=list){
            holder.categoryTitle.setText(list.get(position).getName());
            if(list.get(position).getType().equalsIgnoreCase("food")){
                holder.categoryImage.setImageResource(R.drawable.ic_covered_food_black_24dp);
            }else{
                holder.categoryImage.setImageResource(R.drawable.ic_drink_black_24dp);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.categoryImage)
        ImageView categoryImage;
        @BindView(R.id.categoryTitle)
        TextView categoryTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onCategoryItemClicked(list.get(getAdapterPosition()));
                }
            });
        }
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

}
