package agriboon.example.myagriboonapp.Adapters; //this is for layout_category1 (slider at start)

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import agriboon.example.myagriboonapp.ItemActivity;
import agriboon.example.myagriboonapp.Model.CategoryModel;
import agriboon.example.myagriboonapp.R;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateViewHolder> {

    private List<CategoryModel> categoryModelList;
    private Context context;

    public PlateAdapter(List<CategoryModel> categoryModelList, Context context) {
        this.categoryModelList = categoryModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_category, parent, false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        CategoryModel categoryModel = categoryModelList.get(position);

        holder.categoryTxt.setText(categoryModel.getCat_title());
        Glide.with(context).load(categoryModel.getCat_img()).placeholder(R.drawable.tintlogo).into(holder.categoryImg);
        holder.categoryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ItemActivity.class);
                intent.putExtra("type",categoryModelList.get(position).getCat_title());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }


    public class PlateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView categoryImg;
        private TextView categoryTxt;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImg = (ImageView) itemView.findViewById(R.id.category_img);
            categoryTxt = (TextView) itemView.findViewById(R.id.category_text);

            itemView.setOnClickListener(this);

    }

        @Override
        public void onClick(View v) {


            
        }
    }
 }
