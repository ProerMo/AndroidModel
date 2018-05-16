package com.mp4.androidmodel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mp4.androidmodel.data.source.remote.PictureNetService;
import com.mp4.androidmodel.data.source.remote.RemotePicReponsitory;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        RemotePicReponsitory reponsitory = new RemotePicReponsitory();
        Log.d("mmmm", "main: "+reponsitory.getRetrofit().create(PictureNetService.class));
        Log.d("mmmm", "main1: "+reponsitory.getRetrofit().create(PictureNetService.class));
        Log.d("mmmm", "main2: "+reponsitory.getRetrofit().create(PictureNetService.class));

    }
}
