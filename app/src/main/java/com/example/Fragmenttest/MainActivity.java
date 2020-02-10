package com.example.Fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gragmenttest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        replaceFragment(new RightFragmet());
        button.setOnClickListener(this);
//        LeftFragmet leftFragmet = (LeftFragmet) getSupportFragmentManager().findFragmentById(R.id.fragemet_left);

    }

    private void replaceFragment(Fragment rightFragmet) { // replace 取代  ，替换
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();  // transaction 事务，交易，begin 开始 首先
        transaction.replace(R.id.frame_layout, rightFragmet);

        // 调用这个方提交一个没法，每当添加一个碎片的时候，就把自己碎片添加到 返回栈中
        //当按下  back 键的时候 ，返回到前一个碎片  当中，若没有调用则 直接 退出应用程序

        transaction.addToBackStack(null);
        transaction.commit();// commit 把..... 交托给

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new AnottherRightFragmet());
                break;
            default:
        }
    }
}
