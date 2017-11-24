package com.example.ratha.rathanarestuarant.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.rathanarestuarant.R;
import com.example.ratha.rathanarestuarant.entity.Category;
import com.example.ratha.rathanarestuarant.entity.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ratha on 11/23/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private Context context;
    private List<Product> list;
    private Category category;
    public FoodAdapter(Context context, List<Product> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup viewGroup=(ViewGroup) LayoutInflater.from(context).inflate(R.layout.food_item_layout,parent,false);
        return new FoodAdapter.ViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(null!=list){
            Product pro=list.get(position);
            if(null !=pro.getName()){

            }
            holder.categoryTitle.setText(null != category.getName() ? category.getName(): "");
            holder.foodImage.setImageResource(R.drawable.ic_covered_food_black_24dp);
            holder.foodTitle.setText(null != pro.getName() ? pro.getName():"");
            holder.tvFoodPrice.setText("-$"+list.get(position).getPrice());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.foodImage)
        ImageView foodImage;
        @BindView(R.id.tvfoodTitle)
        TextView foodTitle;
        @BindView(R.id.categoryTitle)
        TextView categoryTitle;
        @BindView(R.id.btnFavorite)
        ImageView btnFavorite;
        @BindView(R.id.tvFoodPrice)
        TextView tvFoodPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

    public void setList(List<Product> list) {
        this.list = list;
        Log.e("footList Size-> ",list.size()+"");
    }
    public void setCategory(Category category){
        this.category=category;
    }

}
