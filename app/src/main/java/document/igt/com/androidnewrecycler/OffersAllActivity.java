package document.igt.com.androidnewrecycler;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.adapters.MyOffersAllViewPagerAdapter;
import document.igt.com.androidnewrecycler.adapters.MyViewPagerAdapter;
import document.igt.com.androidnewrecycler.layouts.SlidingTabLayout;
import document.igt.com.androidnewrecycler.models.ApplicationData;


public class OffersAllActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private MyOffersAllViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_all);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar_offerAll);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mPager=(ViewPager)findViewById(R.id.viewPagerOfferAll);
        mAdapter=new MyOffersAllViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mTabs=(SlidingTabLayout)findViewById(R.id.tabViewOfferAll);
        mTabs.setViewPager(mPager);
        mTabs.setBackgroundColor(getResources().getColor(R.color.btn_color));
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(android.R.color.white);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offers_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id==android.R.id.home)
        {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }

        return super.onOptionsItemSelected(item);
    }
}
