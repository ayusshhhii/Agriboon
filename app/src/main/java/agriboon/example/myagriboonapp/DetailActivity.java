package agriboon.example.myagriboonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import agriboon.example.myagriboonapp.Model.SimpleVerticalModel;

public class DetailActivity extends AppCompatActivity {
    private ImageView mImage;
    private TextView mItemName;
    private TextView mPrice;
    private TextView mItemRating;
    private TextView mItemRatDesc;
    private TextView mItemDesc;
    private Button mAddToCart;
    private Button mBuyBtn;
    SimpleVerticalModel simpleVerticalModel= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SimpleVerticalModel simpleVerticalModel= (SimpleVerticalModel) getIntent().getSerializableExtra("detail");
        mImage= findViewById(R.id.item_img);
        mItemName= findViewById(R.id.item_name);
        mPrice= findViewById(R.id.item_price);
        mItemRating= findViewById(R.id.item_rating);
        mItemRatDesc= findViewById(R.id.item_rat_des);
        mItemDesc= findViewById(R.id.item_des);
        mAddToCart= findViewById(R.id.item_add_cart);
        mBuyBtn= findViewById(R.id.item_buy_now);

        Glide.with(getApplicationContext()).load(simpleVerticalModel.getPro_img()).into(mImage);
        mItemName.setText(simpleVerticalModel.getSimple_title());
        mPrice.setText(String.valueOf(simpleVerticalModel.getSimple_coupon()));
        mItemRating.setText(simpleVerticalModel.getSimple_rating());
        mItemRatDesc.setText(simpleVerticalModel.getSimple_description());
        mAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetailActivity.this, AddAddressActivity.class);
                if(simpleVerticalModel!=null){
                    intent.putExtra("detail", simpleVerticalModel);
                }

                startActivity(intent);
            }
        });
    }
}