package com.example.zhuwojia.glidedownpicdemo;

import android.graphics.Bitmap;

import java.io.File;

/**
 * author：shixinxin on 2017/4/24
 * version：v1.0
 */

public interface ImageDownLoadCallBack {
    void onDownLoadSuccess(File file);
    void onDownLoadSuccess(Bitmap bitmap);

    void onDownLoadFailed();
    void onDownLoadPath(String path);
}
