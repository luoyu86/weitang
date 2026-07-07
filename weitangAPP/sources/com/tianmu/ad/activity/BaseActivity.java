package com.tianmu.ad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tianmu.c.f.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public abstract int a();

    public void a(String str) {
        TextView textView = (TextView) findViewById(j.f11400a);
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
    }

    public void initAdapter() {
    }

    public void initData() {
    }

    public void initListener() {
    }

    public void initTransferData(Intent intent) {
    }

    public void initView() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initTransferData(getIntent());
        setContentView(a());
        getIntent();
        initView();
        initAdapter();
        initListener();
        initData();
    }
}
