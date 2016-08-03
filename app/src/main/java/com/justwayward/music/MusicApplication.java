package com.justwayward.music;

import android.app.Application;

import com.justwayward.music.module.MusicApiModule;
import com.justwayward.music.module.AppModule;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
public class MusicApplication extends Application {

    private static MusicApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        initCompoent();
    }

    public static MusicApplication getsInstance() {
        return sInstance;
    }

    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .musicApiModule(new MusicApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}