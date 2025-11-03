package com.example.recyclerview_nguyenhuudinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements androidVersionAdapter.ItemClicked {

    RecyclerView recyclerView1, recyclerView2, recyclerView3;
    androidVersionAdapter adapter1, adapter2, adapter3;
    ArrayList<androidVersion> list1, list2, list3;
    MaterialButton btadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        recyclerView1 = findViewById(R.id.recyclerViewHorizontal);
        recyclerView2 = findViewById(R.id.recyclerViewHorizontal1);
        recyclerView3 = findViewById(R.id.recyclerViewHorizontal2);
        btadd = findViewById(R.id.btadd);

        // Cấu hình RecyclerView
        setupRecyclerView(recyclerView1, 1);
        setupRecyclerView(recyclerView2, 2);
        setupRecyclerView(recyclerView3, 3);

        // Sự kiện cho nút thêm item
        btadd.setOnClickListener(view -> {
            if (list1 != null && adapter1 != null) {
                list1.add(new androidVersion("Android Pie", "9.0", "pie"));
                adapter1.notifyItemInserted(list1.size() - 1);
                recyclerView1.smoothScrollToPosition(list1.size() - 1);
                Toast.makeText(this, "Đã thêm Android Pie!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView(RecyclerView recyclerView, int listNumber) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        ArrayList<androidVersion> dataList = new ArrayList<>();

        if (listNumber == 1) {
            dataList.add(new androidVersion("iPhone 15 Pro", "$999", "iphone"));
            dataList.add(new androidVersion("Samsung Galaxy S24", "$899", "samsung"));
            dataList.add(new androidVersion("Xiaomi 14 Ultra", "$799", "xiaomi"));
            this.list1 = dataList;
        } else if (listNumber == 2) {
            dataList.add(new androidVersion("MacBook Air M3", "$1199", "macbook"));
            dataList.add(new androidVersion("Dell XPS 13", "$1099", "dell"));
            dataList.add(new androidVersion("HP Spectre x360", "$1299", "hp"));
            this.list2 = dataList;
        } else {
            dataList.add(new androidVersion("iPad Pro M4", "$999", "ipad"));
            dataList.add(new androidVersion("Galaxy Tab S9", "$899", "tab"));
            dataList.add(new androidVersion("Lenovo Yoga Tab", "$699", "lenovo"));
            this.list3 = dataList;
        }

        androidVersionAdapter adapter = new androidVersionAdapter(this, dataList);

        // Gán adapter cho từng danh sách
        if (listNumber == 1) adapter1 = adapter;
        else if (listNumber == 2) adapter2 = adapter;
        else adapter3 = adapter;

        recyclerView.setAdapter(adapter);
    }

    public void onItemClicked(int index) {
        if (list1 != null && index < list1.size()) {
            androidVersion clicked = list1.get(index);
            Toast.makeText(this,
                    "Bạn chọn: " + clicked.getName() + " - Giá: " + clicked.getVersion(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
