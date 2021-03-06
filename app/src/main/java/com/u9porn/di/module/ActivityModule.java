package com.u9porn.di.module;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.u9porn.di.ActivityContext;
import com.u9porn.utils.AppCacheUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author flymegoc
 * @date 2018/2/4
 */
@Module
public class ActivityModule {
    private AppCompatActivity mAppCompatActivity;

    public ActivityModule(AppCompatActivity mAppCompatActivity) {
        this.mAppCompatActivity = mAppCompatActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mAppCompatActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mAppCompatActivity;
    }

    @Provides
    File providesVideoCacheDir(@ActivityContext Context context) {
        return AppCacheUtils.getVideoCacheDir(context);
    }

    @Provides
    List<Fragment> providesFragmentList() {
        return new ArrayList<>();
    }

    @Provides
    FragmentManager providesSupportFragmentManager(AppCompatActivity mAppCompatActivity) {
        return mAppCompatActivity.getSupportFragmentManager();
    }

    @Provides
    LifecycleProvider<Lifecycle.Event> providerLifecycleProvider(AppCompatActivity mAppCompatActivity) {
        return AndroidLifecycle.createLifecycleProvider(mAppCompatActivity);
    }
}
