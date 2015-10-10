package document.igt.com.androidnewrecycler.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Anup.Lal on 09-06-2015.
 */


public class MyVolleySingleton {

    private static MyVolleySingleton mSingletonInstance;
    private RequestQueue mRequestQueue;


    public MyVolleySingleton()
    {
        mRequestQueue= Volley.newRequestQueue(MyApplication.getContext());

    }

    public static MyVolleySingleton getInstance()
    {
        if(mSingletonInstance==null)
        {
            mSingletonInstance=new MyVolleySingleton();
        }
        return mSingletonInstance;

    }
    public RequestQueue getmRequestQueue()
    {
        return mRequestQueue;
    }

}
