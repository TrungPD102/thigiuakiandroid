package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView txtName, txtEmail, txtPhone;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getExtras() != null) {
            Info info = (Info) getIntent().getExtras().get("info");
            initUI();
            txtName.setText(info.getName());
            txtEmail.setText(info.getEmail());
            txtPhone.setText(info.getPhone());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            CaptailAdapter captailAdapter = new CaptailAdapter(getListCaptial());
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(itemDecoration);
            recyclerView.setAdapter(captailAdapter);
        }

    }

    private void initUI() {
        txtName = findViewById(R.id.info_name);
        txtEmail = findViewById(R.id.info_email);
        txtPhone = findViewById(R.id.info_phone);
        recyclerView = findViewById(R.id.rcv_data);
    }

    private List<Capital> getListCaptial() {
        List<Capital> list = new ArrayList<>();
        list.add(new Capital("Moscow"));
        list.add(new Capital("Tokyo"));
        list.add(new Capital("HaNoi"));
        list.add(new Capital("PacKinh"));
        list.add(new Capital("Phnom Phenh"));
        return list;
    }
}