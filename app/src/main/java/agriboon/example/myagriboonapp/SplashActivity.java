package agriboon.example.myagriboonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ///////////status hide starts////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
///////////status hide ends//////////////


        //////////////////add handler starts/////////////////
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
        //////////////////add handler ends///////////////////
    }
}