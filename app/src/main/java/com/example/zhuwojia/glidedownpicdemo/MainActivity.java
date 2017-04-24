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
        onDownLoad("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493619258&di=ee9dcae9d3aa1f3c161642705660bce9&imgtype=jpg&er=1&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fc2fdfc039245d68833446282a6c27d1ed21b2456.jpg");
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
