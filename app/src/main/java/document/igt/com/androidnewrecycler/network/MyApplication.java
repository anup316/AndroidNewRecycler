package document.igt.com.androidnewrecycler.network;

import android.app.Application;
import android.content.Context;

/**
 * Created by Anup.Lal on 09-06-2015.
 */
public class MyApplication extends Application {


    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;

    }

    public static  MyApplication getInstance()
    {
        return mInstance;
    }

    public static Context getContext()
    {
     return mInstance.getApplicationContext();
    }
}
