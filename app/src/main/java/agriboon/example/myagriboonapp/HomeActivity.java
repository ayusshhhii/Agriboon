package agriboon.example.myagriboonapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import agriboon.example.myagriboonapp.Fragments.GoldFragment;
import agriboon.example.myagriboonapp.Fragments.OrdersFragment;
import agriboon.example.myagriboonapp.Fragments.RentInFragment;
import agriboon.example.myagriboonapp.Fragments.VideosFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
/////////////////changing status color/////////////

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        /////////////////ends////////////////

        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);

        ///////////////replacing by default fragment on home activity//////////////////

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new OrdersFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                   switch(item.getItemId())
                   {
                       case R.id.orders:
                           selectedFragment = new OrdersFragment();
                           break;

                       case R.id.rentin:
                           selectedFragment = new RentInFragment();
                           break;

                       case R.id.gold:
                           selectedFragment = new GoldFragment();
                           break;

                       case R.id.videos:
                           selectedFragment = new VideosFragment();
                           break;
                   }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment).commit();
                    return true;
                }
            };


}