package document.igt.com.androidnewrecycler.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.fragments.ApplicationDownloadOffers;
import document.igt.com.androidnewrecycler.fragments.OffersAllFragment;
import document.igt.com.androidnewrecycler.fragments.RechargeFragment;
import document.igt.com.androidnewrecycler.fragments.TabFragment1;
import document.igt.com.androidnewrecycler.models.ApplicationData;

/**
 * Created by Anup.Lal on 21-05-2015.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<ApplicationData> appData;

    String mTabs[]={"Recharge","Offers","Deals","Electronics","Books"};
   public MyViewPagerAdapter(FragmentManager fm,ArrayList<ApplicationData> appData)
   {
       super(fm);
       this.appData=appData;
   }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                RechargeFragment tabFragment = RechargeFragment.newInstance("Anup", "Lal");
                return tabFragment;
            case 1:
                ApplicationDownloadOffers appAllFragment = ApplicationDownloadOffers.newInstance(appData);
                return appAllFragment;
            default:
                return OffersAllFragment.newInstance();
        }
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
