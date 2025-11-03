package com.example.recyclerview_nguyenhuudinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements androidVersionAdapter.ItemClicked {

    // Khai báo cho cả 3 RecyclerView
    RecyclerView recyclerView1, recyclerView2, recyclerView3;
    androidVersionAdapter adapter1, adapter2, adapter3;
    ArrayList<androidVersion> list1, list2, list3;

    Button btadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view từ layout
        recyclerView1 = findViewById(R.id.recyclerViewHorizontal);
        recyclerView2 = findViewById(R.id.recyclerViewHorizontal1);
        recyclerView3 = findViewById(R.id.recyclerViewHorizontal2);
        btadd = findViewById(R.id.btadd);

        // --- Cấu hình cho RecyclerView 1 ---
        setupRecyclerView(recyclerView1, 1);

        // --- Cấu hình cho RecyclerView 2 ---
        setupRecyclerView(recyclerView2, 2);

        // --- Cấu hình cho RecyclerView 3 ---
        setupRecyclerView(recyclerView3, 3);

        // Sự kiện cho nút Add - Ví dụ thêm item vào danh sách đầu tiên
        btadd.setOnClickListener(view -> {
            if (list1 != null && adapter1 != null) {
                list1.add(new androidVersion("Android Pie", "9.0", "pie"));
                adapter1.notifyItemInserted(list1.size() - 1);
                recyclerView1.smoothScrollToPosition(list1.size() - 1);
            }
        });
    }

    // Hàm trợ giúp để cấu hình RecyclerView (tránh lặp code)
    private void setupRecyclerView(RecyclerView recyclerView, int listNumber) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<androidVersion> dataList = new ArrayList<>();
        // Tạo dữ liệu khác nhau cho mỗi danh sách để dễ phân biệt
        if (listNumber == 1) {
            dataList.add(new androidVersion("Kitkat", "4.4-4.4.4", "kitkat"));
            dataList.add(new androidVersion("Lollipop", "5.0-5.1.1", "lollipop"));
            dataList.add(new androidVersion("Marshmallow", "6.0-6.0.1", "marshmallow"));
            this.list1 = dataList; // Lưu lại để dùng cho nút Add
        } else if (listNumber == 2) {
            dataList.add(new androidVersion("Gingerbread", "2.3-2.3.7", "gingerbread"));
            dataList.add(new androidVersion("Honeycomb", "3.0-3.2.6", "honeycomb"));
            dataList.add(new androidVersion("Ice Cream", "4.0-4.0.4", "icecreamsandwich"));
        } else {
            dataList.add(new androidVersion("Cupcake", "1.5", "cupcake"));
            dataList.add(new androidVersion("Donut", "1.6", "donut"));
            dataList.add(new androidVersion("Eclair", "2.0-2.1", "eclair"));
        }

        androidVersionAdapter adapter = new androidVersionAdapter(this, dataList);

        // Lưu lại adapter để có thể cập nhật sau này
        if (listNumber == 1) {
            this.adapter1 = adapter;
        } else if (listNumber == 2) {
            this.adapter2 = adapter;
        } else {
            this.adapter3 = adapter;
        }

        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClicked(int index) {
        // Vì tất cả adapter đều dùng chung một listener, bạn không thể biết
        // item được click đến từ danh sách nào chỉ với 'index'.
        // Một cách đơn giản là chỉ hiển thị thông báo chung.
        Toast.makeText(this, "An item was clicked!", Toast.LENGTH_SHORT).show();

        // Để xử lý chính xác, bạn cần sửa lại interface 'ItemClicked' để nó
        // trả về thêm thông tin về item hoặc danh sách.
    }
}
