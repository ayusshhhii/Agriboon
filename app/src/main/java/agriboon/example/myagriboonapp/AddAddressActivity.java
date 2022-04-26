package agriboon.example.myagriboonapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import agriboon.example.myagriboonapp.Model.SimpleVerticalModel;
import agriboon.example.myagriboonapp.Model.UserAd;

public class AddAddressActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mCity;
    private EditText mAddress;
    private EditText mCode;
    private EditText mNumber;
    private Button mAddAddressBtn;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    UserAd userAd;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        mName = findViewById(R.id.ad_name);
        mCity = findViewById(R.id.ad_city);
//        mAddress = findViewById(R.id.add_the_address);
        btnadd=findViewById(R.id.add_the_address);
        mCode = findViewById(R.id.ad_code);
        mNumber = findViewById(R.id.ad_phone);
        mAddAddressBtn = findViewById(R.id.check_out);
        database= FirebaseDatabase.getInstance();
        ref= database.getReference("Address");
        userAd= new UserAd();
    }

//    View.OnClickListener(vi)

    private void getValues(){
        userAd.setName(mName.getText().toString());
        userAd.setCity(mCity.getText().toString());
        userAd.setAddress(mAddress.getText().toString());
        userAd.setCode(mCode.getText().toString());
        userAd.setNumber(mNumber.getText().toString());
    }

    public void addtheaddress(View view) {


        Intent myIntent = new Intent(AddAddressActivity.this, PaymentActivity.class);
        AddAddressActivity.this.startActivity(myIntent);

//        Object obj= getIntent().getSerializableExtra("detail");
//        String name = mName.getText().toString();
//        String city = mCity.getText().toString();
//        String address = mAddress.getText().toString();
//        String code = mCode.getText().toString();
//        String number = mNumber.getText().toString();
//        if (TextUtils.isEmpty(name)) {
//            Toast.makeText(AddAddressActivity.this, "Please enter your name...", Toast.LENGTH_SHORT).show();
//        } else if (TextUtils.isEmpty(city)) {
//            Toast.makeText(AddAddressActivity.this, "Please enter your city...", Toast.LENGTH_SHORT).show();
//        } else if (TextUtils.isEmpty(address)) {
//            Toast.makeText(AddAddressActivity.this, "Please enter your address...", Toast.LENGTH_SHORT).show();
//        } else if (TextUtils.isEmpty(code)) {
//            Toast.makeText(AddAddressActivity.this, "Please enter your pin code...", Toast.LENGTH_SHORT).show();
//        } else if (TextUtils.isEmpty(number)) {
//            Toast.makeText(AddAddressActivity.this, "Please enter your phone number...", Toast.LENGTH_SHORT).show();
//        } else {
//            ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    getValues();
//                    ref.child("User Address").child(name).setValue(userAd);
//                    Toast.makeText(AddAddressActivity.this, "Address Added", Toast.LENGTH_SHORT).show();
//                    double amount=0.0;
//                    if(obj instanceof SimpleVerticalModel){
//                        SimpleVerticalModel f= (SimpleVerticalModel) obj;
//                        amount= f.getSimple_coupon();
//                    }
//
//                    myIntent.putExtra("amount", amount);
//
//
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//        }
    }
}