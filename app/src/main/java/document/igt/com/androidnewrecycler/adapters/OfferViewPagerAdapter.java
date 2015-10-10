package document.igt.com.androidnewrecycler.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import document.igt.com.androidnewrecycler.fragments.TabFragment1;

/**
 * Created by Anup.Lal on 24-06-2015.
 */
public class OfferViewPagerAdapter extends FragmentPagerAdapter {

    public OfferViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {

                return TabFragment1.getInstance(position);
        }
    @Override
    public int getCount() {
        return 5;
    }
}