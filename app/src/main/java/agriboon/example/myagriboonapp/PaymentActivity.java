package agriboon.example.myagriboonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {
    TextView mTotal;
    Button checkout;
//    double amount=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        amount=getIntent().getDoubleExtra("amount", 0.0);
        setContentView(R.layout.activity_payment);
        mTotal=findViewById(R.id.Sub_total);
        checkout=findViewById(R.id.check_out);
//        mTotal.setText("₹"+amount+"");
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startPayment();
                Intent myIntent = new Intent(PaymentActivity.this, done_payment.class);
                PaymentActivity.this.startActivity(myIntent);
            }

        });
    }
    public void startPayment() {

        Checkout checkout = new Checkout();
        final Activity activity= PaymentActivity.this;

        try{
            JSONObject options = new JSONObject();
            //set company name
            options.put("name", "TechTibet");
            //Ref no
            options.put("description", "Reference no. #123456");
            //image to be display
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id","order_9A33XWu170gUtm");
            //current type
            options.put("currency", "INR");
            //double total= Double.parseDouble(mAmountText.getText().toString());
            //multiply with 100 to get exact amount in rupee
//            amount= amount*100;
            //amount
//            options.put("amount", amount);
            JSONObject preFill= new JSONObject();
            //email
            preFill.put("email", "2as1931154@gmail.com");
            //contact
            preFill.put("contact", "8076921856");

            options.put("prefill", preFill);
        } catch (JSONException e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}