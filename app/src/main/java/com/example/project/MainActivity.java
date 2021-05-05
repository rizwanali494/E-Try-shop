package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.project.Adapters.MainAdapter;
import com.example.project.Models.MainModel;
import com.example.project.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Food Ordering App");

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizza1, "Cicken Pizza", "6", "Best Pizza with Extra Topping and with Extra cheese"));
        list.add(new MainModel(R.drawable.burgerdeal4, "Deal of 4", "16", "4 Chicken Burgers with Extra cheese with Souce and Frise"));
        list.add(new MainModel(R.drawable.burger1, "Special Burger", "6", "Chicken Special Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.zingerburger, "Zinger Burger", "7", "Chicken Zinger Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizzaburger, "Pizza Burger", "6", "Pizza Burger with pizza Flavour"));
        list.add(new MainModel(R.drawable.grilledpizzaburger, "Grilled Pizza Burger", "6", "Griled Pizza Burger with unique tast and pizza Flavour"));
        list.add(new MainModel(R.drawable.chickenshawarma, "Chicken Shawarma", "4", "Fresh Chicken Shawarma with fresh Meat and extra souce"));
        list.add(new MainModel(R.drawable.zingershawarma1, "Zinger Shawarma", "5", "Fresh Chicken Zinger Shawarma with fresh Meat and extra souce"));
        list.add(new MainModel(R.drawable.zshawarma, "3 Chicken Zinger Shawarma", "15", "3 Fresh Chicken zinger Shawarma with fresh Meat and extra souce"));
        list.add(new MainModel(R.drawable.fries1, "Fries", "3", "Hot Potato Fries and extra souce"));
        list.add(new MainModel(R.drawable.tomatoosouce, "Souce", "1", "Fresh Tomatoo souce"));
        list.add(new MainModel(R.drawable.chillisouce, "Chilli Souce", "1", "Fresh chilli souce"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}