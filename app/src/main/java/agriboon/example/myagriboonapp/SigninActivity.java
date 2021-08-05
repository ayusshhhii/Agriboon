package agriboon.example.myagriboonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import agriboon.example.myagriboonapp.Fragments.OrdersFragment;
import agriboon.example.myagriboonapp.Model.Users;

public class SigninActivity extends AppCompatActivity {
    private Button loginbtn;
    private EditText InputNumber, InputPassword;
    private ProgressDialog loadingBar;
    private String ParentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ///////////status hide starts////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
///////////status hide ends//////////////

        loginbtn = (Button) findViewById(R.id.buttonlogin);  //signup button
        InputNumber = (EditText) findViewById(R.id.number_login);
        InputPassword = (EditText) findViewById(R.id.password_login);
        loadingBar = new ProgressDialog(this);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }

            private void loginUser()
            {
                String password = InputPassword.getText().toString();
                String phone = InputNumber.getText().toString();

                 if (TextUtils.isEmpty(phone)){
                        Toast.makeText(SigninActivity.this, "Please enter your Email Id...", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(password)){
                        Toast.makeText(SigninActivity.this, "Please enter your password...", Toast.LENGTH_SHORT).show();
                    }
                    else {
                     loadingBar.setTitle("Login Account");
                     loadingBar.setMessage("Please wait, while we are checking your credentials");
                     loadingBar.setCanceledOnTouchOutside(false);
                     loadingBar.show();

                     AllowAccessToAccount(phone, password);
                 }
            }

            private void AllowAccessToAccount(String phone, String password)
            {
                final DatabaseReference RootRef;
                RootRef = FirebaseDatabase.getInstance().getReference();

                RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(ParentDbName).child(phone).exists())
                        {

                            Users usersData = dataSnapshot.child(ParentDbName).child(phone).getValue(Users.class);

                            if (usersData.getPhone().equals(phone))
                            {
                                if (usersData.getPassword().equals(password))
                                {
                                    Toast.makeText(SigninActivity.this, "logged In Succesfully...", Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();

                                    Intent intent = new Intent (SigninActivity.this, HomeActivity.class);
                                    startActivity(intent);

                                }
                            }

                        }
                        else
                        {
                            Toast.makeText(SigninActivity.this, "Account with this" + phone + "number do not exists.", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    public void goToRegister(View view) {

        Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
        startActivity(intent);
        finish();
    }
}