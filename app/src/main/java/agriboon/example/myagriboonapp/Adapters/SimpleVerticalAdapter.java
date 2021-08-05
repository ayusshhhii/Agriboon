package agriboon.example.myagriboonapp.Adapters;

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

import agriboon.example.myagriboonapp.DetailActivity;
import agriboon.example.myagriboonapp.Model.SimpleVerticalModel;
import agriboon.example.myagriboonapp.R;

public class SimpleVerticalAdapter extends RecyclerView.Adapter<SimpleVerticalAdapter.PlateViewHolder> {

    public int counter = 0;
    private List<SimpleVerticalModel> simpleVerticalModelList;
    private Context context;

    public SimpleVerticalAdapter(List<SimpleVerticalModel> simpleVerticalModelList, Context context) {
        this.simpleVerticalModelList = simpleVerticalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_vertical_slides, viewGroup, false);

        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        SimpleVerticalModel simpleVerticalModel = simpleVerticalModelList.get(position);

        Glide.with(context).load(simpleVerticalModel.getPro_img()).into(holder.proImg);
        holder.pro_id.setText(simpleVerticalModel.getSimple_id());
        holder.pro_title.setText(simpleVerticalModel.getSimple_title());
        holder.pro_desc.setText(simpleVerticalModel.getSimple_description());
        holder.pro_quantity.setText(simpleVerticalModel.getSimple_quantity());
        holder.pro_coupon.setText(String.valueOf(simpleVerticalModel.getSimple_coupon()));
        holder.pro_status.setText(simpleVerticalModel.getSimple_status());
        holder.pro_rating.setText(simpleVerticalModel.getSimple_rating());
        holder.proImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, DetailActivity.class);
                intent.putExtra("detail", simpleVerticalModelList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return simpleVerticalModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder{

        private ImageView proImg;
        private TextView pro_title, pro_desc, pro_quantity, pro_coupon, pro_status, pro_rating, pro_id;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);

            pro_id = (TextView) itemView.findViewById(R.id.uniqueitemid);
            proImg = (ImageView) itemView.findViewById(R.id.imageView2);
            pro_title = (TextView) itemView.findViewById(R.id.textView);
            pro_desc = (TextView) itemView.findViewById(R.id.textView2);
            pro_quantity = (TextView) itemView.findViewById(R.id.textView3);
            pro_coupon = (TextView) itemView.findViewById(R.id.textView4);
            pro_status = (TextView) itemView.findViewById(R.id.textView5);
            pro_rating = (TextView) itemView.findViewById(R.id.textView6);
        }

    }
}
