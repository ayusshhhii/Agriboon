package agriboon.example.myagriboonapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {
    EditText inputphonenumber, inputpassword, inputname;
    private Button homebtn1;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);



        ///////////status hide starts////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
///////////status hide ends//////////////

       inputname = (EditText) findViewById(R.id.name);
       inputpassword = (EditText) findViewById(R.id.password);
       inputphonenumber = (EditText) findViewById(R.id.phonenumber);
       loadingBar = new ProgressDialog(this);

       homebtn1 = (Button) findViewById(R.id.buttonsignup);  //signup button
       homebtn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               CreateAccount();
           }

           private void CreateAccount()
           {
               String name = inputname.getText().toString();
               String password = inputpassword.getText().toString();
               String phone = inputphonenumber.getText().toString();
               
               if (TextUtils.isEmpty(name))
               {
                   Toast.makeText(SignupActivity.this, "Please enter your name...", Toast.LENGTH_SHORT).show();
               }
              else if (TextUtils.isEmpty(phone)){
                   Toast.makeText(SignupActivity.this, "Please enter your Email Id...", Toast.LENGTH_SHORT).show();
               }
              else if (TextUtils.isEmpty(password)){
                   Toast.makeText(SignupActivity.this, "Please enter your password...", Toast.LENGTH_SHORT).show();
               }
              else {
                    loadingBar.setTitle("Create Account");
                    loadingBar.setMessage("Please wait, while we are checking your credentials");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();

                    ValidatephoneNumber(name, phone, password);
               }

           }

           private void ValidatephoneNumber(String name, String phone, String password) {

               final DatabaseReference RootRef;
               RootRef = FirebaseDatabase.getInstance().getReference();
               RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                   {
                       if (!(dataSnapshot.child("Users").child(phone).exists()))
                       {
                           HashMap<String, Object> userdataMap = new HashMap<>();
                           userdataMap.put("phone",phone);
                           userdataMap.put("password",password);
                           userdataMap.put("name",name);

                           RootRef.child("Users").child(phone).updateChildren(userdataMap)
                                   .addOnCompleteListener(new OnCompleteListener<Void>() {
                                       @Override
                                       public void onComplete(@NonNull Task<Void> task) {

                                           if (task.isSuccessful())
                                           {
                                               Toast.makeText(SignupActivity.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();
                                               loadingBar.dismiss();

                                               Intent intent = new Intent (SignupActivity.this, HomeActivity.class);
                                               startActivity(intent);
                                           }
                                           else
                                           {
                                               loadingBar.dismiss();
                                               Toast.makeText(SignupActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                                           }

                                       }
                                   });
                       }
                       else
                       {
                           Toast.makeText(SignupActivity.this, "This" + phone + "already exists.", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();
                           Toast.makeText(SignupActivity.this, "Please try again using another phone numeber.", Toast.LENGTH_SHORT).show();

                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

           }
       });


    }

    public void goToLogin(View view) {

        Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
        startActivity(intent);
        finish();
    }
}

