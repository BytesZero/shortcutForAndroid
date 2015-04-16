package com.zhengsonglan.shortcutforandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{
    Button bt_shortcut;
    String shortcut_name="快捷方式";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        bt_shortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createShortCut();
            }
        });
    }

    /**
     * 创建快捷方式
     */
    private void createShortCut() {
        // 创建快捷方式的Intent
        Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        // 不允许重复创建
        shortcutIntent.putExtra("duplicate", false);
        // 快捷方式的名字
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,shortcut_name);
        // 快捷方式icon
        Parcelable icon = Intent.ShortcutIconResource.fromContext(
                MainActivity.this, R.mipmap.shortcut);
        //设置icon
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        // 点击快捷图片，运行的程序主入口
        Intent intent = new Intent(MainActivity.this,
                MainActivity.class);

        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        // 发送广播,创建快捷方式
        sendBroadcast(shortcutIntent);

        Toast.makeText(MainActivity.this,"快捷方式创建",Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        bt_shortcut= (Button) findViewById(R.id.main_bt_create_shaortcut);
    }

}
