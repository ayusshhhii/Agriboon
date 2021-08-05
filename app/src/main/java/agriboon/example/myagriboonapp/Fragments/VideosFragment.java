package agriboon.example.myagriboonapp.Fragments;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import agriboon.example.myagriboonapp.R;

public class VideosFragment extends Fragment implements View.OnClickListener {

    public VideosFragment() {
        // Required empty public constructor
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    private View view;
    private RelativeLayout loginSignup, bookmarks, gold;
    private TextView your_orders, fav_orders, address_book, online_ordering_help, send_feedback, report_safety, rateus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_videos, container, false);
        onSetNavigationDrawerEvents();
        return view;

    }
    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);

        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);

        loginSignup = (RelativeLayout) view.findViewById(R.id.relativeLayout2);
        bookmarks = (RelativeLayout) view.findViewById(R.id.relativeLayout3);
        gold = (RelativeLayout) view.findViewById(R.id.relativeLayout4);

        your_orders = (TextView) view.findViewById(R.id.your_orders);
        fav_orders = (TextView) view.findViewById(R.id.fav_orders);
        address_book = (TextView) view.findViewById(R.id.address_book);
        online_ordering_help = (TextView) view.findViewById(R.id.online_ordering_help);
        send_feedback = (TextView) view.findViewById(R.id.send_feedback);
        report_safety = (TextView) view.findViewById(R.id.report_safety);
        rateus = (TextView) view.findViewById(R.id.rateus);

        navigationBar.setOnClickListener(this);
        loginSignup.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        gold.setOnClickListener(this);
        your_orders.setOnClickListener(this);
        fav_orders.setOnClickListener(this);
        address_book .setOnClickListener(this);
        send_feedback.setOnClickListener(this);
        report_safety.setOnClickListener(this);
        rateus.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.your_orders:
                Toast.makeText(getContext(), "your_orders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fav_orders:
                Toast.makeText(getContext(), "fav_orders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.address_book:
                Toast.makeText(getContext(), "address_book", Toast.LENGTH_SHORT).show();
                break;
            case R.id.online_ordering_help:
                Toast.makeText(getContext(), "online_ordering_help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_feedback:
                Toast.makeText(getContext(), "send_feedback", Toast.LENGTH_SHORT).show();
                break;
            case R.id.report_safety:
                Toast.makeText(getContext(), "report_safety", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rateus :
                Toast.makeText(getContext(), "rateus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout2 :
                Toast.makeText(getContext(), "loginsignup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout3 :
                Toast.makeText(getContext(), "bookmark", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout4 :
                Toast.makeText(getContext(), "gold", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

