package agriboon.example.myagriboonapp.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import agriboon.example.myagriboonapp.Adapters.BannerAdapter;
import agriboon.example.myagriboonapp.Adapters.PlateAdapter;
import agriboon.example.myagriboonapp.Adapters.SimpleVerticalAdapter;
import agriboon.example.myagriboonapp.Model.BannerModel;
import agriboon.example.myagriboonapp.Model.CategoryModel;
import agriboon.example.myagriboonapp.Model.SimpleVerticalModel;
import agriboon.example.myagriboonapp.R;
import agriboon.example.myagriboonapp.RentdetailActivity;
import agriboon.example.myagriboonapp.SigninActivity;


/**
 * A simple {@link Fragment} subclass.**/

public class OrdersFragment extends Fragment implements View.OnClickListener{

    Activity context;
    FragmentManager fragmentManager;
    TextView badgeCounter;
    int pendingNotifications =0;
    MenuItem menuItem;

    public OrdersFragment() {
        // Required empty public constructor
    }

    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    private View view;
    private RelativeLayout loginSignup, bookmarks, gold;
    private TextView your_orders, fav_orders, address_book, online_ordering_help, send_feedback, report_safety, rateus;


    //////////category slider starts//////////

    private RecyclerView recyclerViewCategory;
    private PlateAdapter plateAdapter;
    private List<CategoryModel> categoryModelList;

    //////////category slider ends//////////


    //////////banner slider starts//////////

    private RecyclerView recyclerViewBanner;
    private BannerAdapter bannerAdapter;
    private List<BannerModel> bannerModelList;

    //////////banner slider ends////////////

    //////////simple vertical slider starts//////////

    private RecyclerView recyclerViewSimple;
    private SimpleVerticalAdapter simpleVerticalAdapter;
    private List<SimpleVerticalModel> simpleVerticalModelList;

    //////////simple vertical slider ends////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        onSetNavigationDrawerEvents();

        init();
        return view;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        menuItem = menu.findItem(R.id.nav_notification);
        if (pendingNotifications==0)
        {
            menuItem.setActionView(null);
        }
        else{
            menuItem.setActionView(R.layout.notification_badge);
            View view = menuItem.getActionView();
            badgeCounter = view.findViewById(R.id.badge_counter);
            badgeCounter.setText(String.valueOf(pendingNotifications));
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void init() {

        ///////////////////////////////////category model starts//////////////////////////
        recyclerViewCategory = (RecyclerView) view.findViewById(R.id.recyclerViewCategory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewCategory.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(R.drawable.seedsnew,"Seeds"));
        categoryModelList.add(new CategoryModel(R.drawable.fertilizers,"Fertilizers"));
        categoryModelList.add(new CategoryModel(R.drawable.weeds,"Weedicides"));
        categoryModelList.add(new CategoryModel(R.drawable.pesticides,"Pesticides"));
        categoryModelList.add(new CategoryModel(R.drawable.transport,"Transport on rent"));
        categoryModelList.add(new CategoryModel(R.drawable.equipmentsonrent,"Equipments on rent"));

        plateAdapter = new PlateAdapter(categoryModelList, getContext());
        recyclerViewCategory.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();



        /////////////////////////////category model ends///////////////////////////

        /////////////////////////////banner model starts///////////////////////////

        recyclerViewBanner = (RecyclerView) view.findViewById(R.id.recyclerViewBanner);
        LinearLayoutManager layoutManagerBanner = new LinearLayoutManager(getContext());
        layoutManagerBanner.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewBanner.setLayoutManager(layoutManagerBanner);

        bannerModelList = new ArrayList<>();
        bannerModelList.add(new BannerModel(R.drawable.sale3));
        bannerModelList.add(new BannerModel(R.drawable.sale1));
        bannerModelList.add(new BannerModel(R.drawable.sale2));
        bannerModelList.add(new BannerModel(R.drawable.sale3));
        bannerModelList.add(new BannerModel(R.drawable.sale2));
        bannerModelList.add(new BannerModel(R.drawable.sale1));


        bannerAdapter = new BannerAdapter(bannerModelList,getContext());
        recyclerViewBanner.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();


        /////////////////////////////banner model ends///////////////////////////

        ///////////////////////////// simple vertical slider model starts///////////////////////////

        recyclerViewSimple = (RecyclerView) view.findViewById(R.id.recyclerViewSimple);
        LinearLayoutManager layoutManagerSimpleVerticalSlider = new LinearLayoutManager(getContext());
        layoutManagerSimpleVerticalSlider.setOrientation(RecyclerView.VERTICAL);
        recyclerViewSimple.setLayoutManager( layoutManagerSimpleVerticalSlider);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Tata Tractor", "renting monthly", 4000, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Sprayer", "renting monthly", 2500, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Baler", "renting monthly", 3045, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Harrow", "renting monthly", 1248, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Plow", "renting monthly", 6000, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Manure spreader", "renting monthly", 7000, "20% OFF", "Well Sanitized ", "3.5" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.tintlogo, " " ,"Tiller", "renting monthly", 4505, "20% OFF", "Well Sanitized ", "3.5" ));





        simpleVerticalAdapter = new SimpleVerticalAdapter(simpleVerticalModelList, getContext());
        recyclerViewSimple.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();




        ///////////////////////////// simple vertical slider model ends///////////////////////////
        

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
                //Toast.makeText(getContext(), "orders", Toast.LENGTH_SHORT).show();

                your_orders.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), RentdetailActivity.class);
                        startActivity(intent);
                    }
                });

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
                //Toast.makeText(getContext(), "loginsignup", Toast.LENGTH_SHORT).show();

                loginSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), SigninActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.relativeLayout3 :
                Toast.makeText(getContext(), "bookmark", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout4 :
                //Toast.makeText(getContext(), "gold", Toast.LENGTH_SHORT).show();


                break;

        }
    }

}