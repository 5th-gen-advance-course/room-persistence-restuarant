package com.example.ratha.rathanarestuarant.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ratha.rathanarestuarant.R;
import com.example.ratha.rathanarestuarant.entity.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ratha on 11/23/2017.
 */

public class CreateCategoryDialog extends DialogFragment {
    CallBack callBack;
    String[] items={"food","drink"};
    static int typeIndex;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack= (CallBack) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("create new Category");

        final View view = LayoutInflater.from(getActivity()).inflate(R.layout.create_category_dialog_layout,null);
        final ViewHolder holder=new ViewHolder(view);

        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);
        holder.spCategoryType.setAdapter(adapter);
        holder.spCategoryType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeIndex=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        builder.setView(view);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Category category=new Category(
                        holder.etCategoryTitle.getText().toString(),
                        items[typeIndex]
                );

                callBack.onSaveListener(category);

            }
        });
        return builder.create();
    }

    public static class ViewHolder{
        @BindView(R.id.categoryTitle)
        EditText etCategoryTitle;
        @BindView(R.id.categoryDesc)
        EditText etCategoryDesc;
        @BindView(R.id.categoryType)
        Spinner spCategoryType;
        public ViewHolder(View viewItem){
            ButterKnife.bind(this,viewItem);
        }

    }

    public interface CallBack{
        void onSaveListener(Category category);
        void onCategoryItemClicked(Category category);
    }
}
