package com.example.xiangmu.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiangmu.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class PingActivity extends AppCompatActivity {

    private ImageView ping_img1;
    private Intent intent1;
    private Bitmap bitmap1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ping);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    private void initView() {
        ping_img1 = findViewById(R.id.ping_img1);
        ping_img1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                intent1 = new Intent();
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                intent1.addCategory(Intent.CATEGORY_OPENABLE);
                intent1.setType("image/*");
                startActivityForResult(intent1, 111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 111:
                if (requestCode == RESULT_CANCELED) {
                    Toast.makeText(getApplication(), "点击取消从相册选择", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    Uri uri = data.getData();
                    Log.e("TAG", uri.toString());

                    String filePath = getRealPathFromURI(uri);
                    bitmap1 = getresizePhoto(filePath);
                    ping_img1.setImageBitmap(bitmap1);
                    if (bitmap1 != null) {
                        Log.e("aa", "bitmap1不为空！！！！！！！！！！");
                    } else {
                        Log.e("aa", "bitmap1为空！！！！！！！！！！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private String getRealPathFromURI(Uri uri) {
        Cursor cursor = null;
        try {

            String[] img = {MediaStore.Images.Media.DATA};

//由context.getContentResolver()获取contentProvider再获取cursor(游

//标）用游标获取文件路径返回
            cursor = this.getContentResolver().query(uri, img, null, null, null);
            cursor.moveToFirst();
            int column_indenx = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            cursor.getString(column_indenx);
        } finally {

            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    private Bitmap getresizePhoto(String ImagePath){
    if (ImagePath!=null){
                     BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(ImagePath,options);
                double ratio = Math.max(options.outWidth*1.0d/1024f,options.outHeight*1.0d/1024);
                options.inSampleSize = (int) Math.ceil(ratio);
                options.inJustDecodeBounds= false;
                Bitmap bitmap=BitmapFactory.decodeFile(ImagePath,options);
                return bitmap;
            }
                return null;
    }
    private void initData() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void EventBus(String pid){

        Toast.makeText(PingActivity.this,""+pid,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
