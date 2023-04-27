package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {

    Button btnStatus;
    Button btnExit;
    ListView lvOrderHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);

        btnStatus = findViewById(R.id.btnStatus);
        btnExit = findViewById(R.id.btnExit);
        lvOrderHistory = findViewById(R.id.lvOrderHistory);

        // Lấy dữ liệu từ Intent (nếu có)
        Intent intent = getIntent();
        int orderCode = intent.getIntExtra("orderCode", 0);
        double totalAmount = intent.getDoubleExtra("totalAmount", 0.0);
        // ...

        // Tạo danh sách món ăn (có thể lấy từ Intent hoặc từ nguồn dữ liệu khác)
        List<Food> foodList = new ArrayList<>();
        // Thêm các món ăn vào danh sách
        foodList.add(new Food("Cơm Tấm", R.drawable.com_tam, 25000,3));
        foodList.add(new Food("Cơm Gà", R.drawable.com_tam, 25000,1));
        foodList.add(new Food("Bún Bò", R.drawable.com_tam, 25000,2));

        // Tạo adapter cho lvOrderHistory
        FoodListInOrderDetailAdapter adapter = new FoodListInOrderDetailAdapter(this, foodList);
        lvOrderHistory.setAdapter(adapter);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}
