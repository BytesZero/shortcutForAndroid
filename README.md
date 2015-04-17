# shortcutForAndroid
shortcutForAndroid android创建快捷方式
###主要代码如下
```java
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
```
