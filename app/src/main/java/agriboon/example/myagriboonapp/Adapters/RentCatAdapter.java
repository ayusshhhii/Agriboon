package agriboon.example.myagriboonapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import agriboon.example.myagriboonapp.Model.RentCatModel;
import agriboon.example.myagriboonapp.R;

public class RentCatAdapter extends RecyclerView.Adapter<RentCatAdapter.PlateViewHolder> {

    private List<RentCatModel> rentcatModelList;
    private Context context;

    public RentCatAdapter(List<RentCatModel> rentcatModelList, Context context) {
        this.rentcatModelList = rentcatModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rentcategory, viewGroup, false);

        return new PlateViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        RentCatModel rentCatModel = rentcatModelList.get(position);

        holder.rentcategoryTxt.setText(rentCatModel.getRent_cat_title());
        Glide.with(context).load(rentCatModel.getRent_cat_img() ).placeholder(R.drawable.tintlogo).into(holder.rentcategoryImg);


    }

    @Override
    public int getItemCount() {
        return rentcatModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        private ImageView rentcategoryImg;
        private TextView rentcategoryTxt;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);

            rentcategoryImg = (ImageView) itemView.findViewById(R.id.category_rentimg);
            rentcategoryTxt = (TextView) itemView.findViewById(R.id.category_renttext);
        }
    }
}

