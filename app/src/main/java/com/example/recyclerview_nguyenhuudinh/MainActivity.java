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
            dataList.add(new androidVersion("Kitkat", "4.4-4.4.4", "kitkat"));
            dataList.add(new androidVersion("Lollipop", "5.0-5.1.1", "lollipop"));
            dataList.add(new androidVersion("Marshmallow", "6.0-6.0.1", "marshmallow"));
            this.list1 = dataList;
        } else if (listNumber == 2) {
            dataList.add(new androidVersion("Gingerbread", "2.3-2.3.7", "gingerbread"));
            dataList.add(new androidVersion("Honeycomb", "3.0-3.2.6", "honeycomb"));
            dataList.add(new androidVersion("Ice Cream Sandwich", "4.0-4.0.4", "icecreamsandwich"));
            this.list2 = dataList;
        } else {
            dataList.add(new androidVersion("Cupcake", "1.5", "cupcake"));
            dataList.add(new androidVersion("Donut", "1.6", "donut"));
            dataList.add(new androidVersion("Eclair", "2.0-2.1", "eclair"));
            this.list3 = dataList;
        }

        androidVersionAdapter adapter = new androidVersionAdapter(this, dataList);

        // Gán adapter cho từng danh sách
        if (listNumber == 1) adapter1 = adapter;
        else if (listNumber == 2) adapter2 = adapter;
        else adapter3 = adapter;

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int index) {
        // Khi click vào item (ở đây chỉ demo cho list1)
        if (list1 != null && index < list1.size()) {
            androidVersion clickedItem = list1.get(index);
            Toast.makeText(this,
                    "Bạn đã chọn: " + clickedItem.getName() +
                            " (Phiên bản: " + clickedItem.getVersion() + ")",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
