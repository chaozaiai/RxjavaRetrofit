package com.techidea.data;

import android.app.Application;

import com.techidea.data.net.CustomTrust;
import com.techidea.data.net.HttpMethods;

/**
 * Created by zchao on 2016/5/19.
 */
public class ApplicationStub extends Application {

    public ApplicationStub() {
        CustomTrust.getInstance().init(null);
        HttpMethods.setBaseUrl("");
    }
}