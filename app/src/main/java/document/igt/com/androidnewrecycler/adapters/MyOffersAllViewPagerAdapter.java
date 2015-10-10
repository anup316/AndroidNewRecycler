package document.igt.com.androidnewrecycler.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.fragments.OffersAllFragment;
import document.igt.com.androidnewrecycler.fragments.TabFragment1;
import document.igt.com.androidnewrecycler.models.ApplicationData;

/**
 * Created by Anup.Lal on 26-06-2015.
 */
public class MyOffersAllViewPagerAdapter extends FragmentPagerAdapter {

    String mTabs[] = {"New", "Popular", "Price"};

    public MyOffersAllViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return OffersAllFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
