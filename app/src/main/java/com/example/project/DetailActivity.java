package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Food Ordering App");

        DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type", 0)==1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.nameBox1.setText(name);
            binding.detailDescription.setText(description);

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }else {
            int id= getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderByid(id);
            int image = cursor.getInt(Integer.parseInt("4"));
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(Integer.parseInt("3"))));
            binding.nameBox1.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(Integer.parseInt("1")));
            binding.phoneBox.setText(cursor.getString(Integer.parseInt("2")));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isupdated = helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.nameBox1.getText().toString(),
                            1,
                            id
                            );
                    if(isupdated) {
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}