package com.example.zhuwojia.glidedownpicdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private File currentFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void onClick(View view) {
        onDownLoad("http://60.205.190.130/zwjapp/data/upload/room_picture/33f7930ca807ed68857c5848f4d45df1.jpeg");
    }
    private void onDownLoad(String url) {
        DownLoadImageService service = new DownLoadImageService(getApplicationContext(),
                url,
                new ImageDownLoadCallBack() {
                    @Override
                    public void onDownLoadSuccess(File file) {
                        Log.e("====ssss",file.getAbsolutePath());
                    }
                    @Override
                    public void onDownLoadSuccess(Bitmap bitmap) {
                        // 在这里执行图片保存方法
                    }

                    @Override
                    public void onDownLoadFailed() {
                        // 图片保存失败
                    }

                    @Override
                    public void onDownLoadPath(String path) {
                        Log.e("====ssss",path);
                    }
                });
        //启动图片下载线程
        new Thread(service).start();
    }
}
