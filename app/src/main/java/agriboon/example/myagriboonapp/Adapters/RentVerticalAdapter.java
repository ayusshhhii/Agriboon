package agriboon.example.myagriboonapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import agriboon.example.myagriboonapp.Model.RentVerticalModel;
import agriboon.example.myagriboonapp.R;

public class RentVerticalAdapter extends RecyclerView.Adapter<RentVerticalAdapter.PlateViewHolder> {


    private List<RentVerticalModel> rentVerticalModelList;
    private Context context;
    private Button getonrentbtn;

    public RentVerticalAdapter(List<RentVerticalModel> rentVerticalModelList, Context context) {
        this.rentVerticalModelList = rentVerticalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RentVerticalAdapter.PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_vertical_rentslides, viewGroup, false);

        return new RentVerticalAdapter.PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        RentVerticalModel rentVerticalModel = rentVerticalModelList.get(position);

        Glide.with(context).load(rentVerticalModel.getProrent_img()).into(holder.rentImg);
        holder.rent_id.setText(rentVerticalModel.getProrent_id());
        holder.rent_title.setText(rentVerticalModel.getProrent_title());
        holder.rent_desc.setText(rentVerticalModel.getProrent_description());
        holder.rent_price.setText(rentVerticalModel.getProrent_price());
        holder.rent_status.setText(rentVerticalModel.getProrent_status());

    }


    @Override
    public int getItemCount() {
        return rentVerticalModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder{

        private ImageView rentImg;
        private TextView rent_title, rent_desc, rent_price, rent_status, rent_id;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);

            rent_id = (TextView) itemView.findViewById(R.id.uniqueitemidrent);
            rentImg = (ImageView) itemView.findViewById(R.id.rentimg1);
            rent_title = (TextView) itemView.findViewById(R.id.textViewrent);
            rent_desc = (TextView) itemView.findViewById(R.id.textView7);
            rent_price = (TextView) itemView.findViewById(R.id.textView8);
            rent_status = (TextView) itemView.findViewById(R.id.textView9);
        }

    }
}
