package document.igt.com.androidnewrecycler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.Constants.ApiConstants;
import document.igt.com.androidnewrecycler.adapters.MyViewPagerAdapter;
import document.igt.com.androidnewrecycler.fragments.ApplicationDownloadOffers;
import document.igt.com.androidnewrecycler.fragments.DrawerLayoutFragment;
import document.igt.com.androidnewrecycler.fragments.RechargeFragment;
import document.igt.com.androidnewrecycler.layouts.SlidingTabLayout;
import document.igt.com.androidnewrecycler.models.ApplicationData;


public class MainActivity extends AppCompatActivity implements ApplicationDownloadOffers.OnFragmentInteractionListener,DrawerLayoutFragment.ActivityCallback,
                                                                    RechargeFragment.RechargeFragmentListener {

    private Toolbar mToolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private MyViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


        mToolbar=(Toolbar)findViewById(R.id.tool_bar);
        mPager=(ViewPager)findViewById(R.id.viewPager);
        ArrayList<ApplicationData> appData=getAllApps();
        mAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),appData);
        mPager.setAdapter(mAdapter);
        mTabs=(SlidingTabLayout)findViewById(R.id.tabView);
        mTabs.setViewPager(mPager);
        mTabs.setBackgroundColor(getResources().getColor(R.color.btn_color));
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(android.R.color.white);
            }
        });

                setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayoutFragment fragment=(DrawerLayoutFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);



        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getResources().getDrawable(R.drawable.ficon));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setBackgroundDrawable(getResources().getDrawable(R.drawable.circle ))
                .setContentView(icon)

                .build();

        ImageView icon1=new ImageView(this);
        icon1.setImageResource(android.R.drawable.ic_delete);
        ImageView icon2=new ImageView(this);
        icon2.setImageDrawable(getResources().getDrawable(R.drawable.profile));
        ImageView icon3=new ImageView(this);
        icon3.setImageResource(android.R.drawable.ic_btn_speak_now);
        ImageView icon4=new ImageView(this);
        icon4.setImageResource(android.R.drawable.ic_input_add);
        ImageView icon5=new ImageView(this);
        icon5.setImageResource(android.R.drawable.ic_menu_camera);
        ImageView icon6=new ImageView(this);
        icon6.setImageResource(android.R.drawable.ic_menu_gallery);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton button1 = itemBuilder.setContentView(icon1).build();
        button1.setPadding(5,5,5,5);
        SubActionButton button2 = itemBuilder.setContentView(icon2).build();
        button2.setPadding(5,5,5,5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),SignUpActivity.class));
                overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
            }
        });
        SubActionButton button3 = itemBuilder.setContentView(icon3).build();
        button3.setPadding(5,5,5,5);
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<ApplicationData> getAllApps()
    {
        ArrayList<ApplicationData> appData=new ArrayList<ApplicationData>();
        ApplicationData data=new ApplicationData("Udemy","Join Over 50 millions users around the globe and explore latest videos.",3,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","IRCTC authorized train reservations, flights and hotels.",4,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("Udemy","Join Over 50 millions users around the globe and explore latest videos.",3,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","IRCTC authorized train reservations, flights and hotels.",4,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("Udemy","Join Over 50 millions users around the globe and explore latest videos.",3,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","IRCTC authorized train reservations, flights and hotels.",4,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("Udemy","Join Over 50 millions users around the globe and explore latest videos.",3,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","IRCTC authorized train reservations, flights and hotels.",4,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("Udemy","Join Over 50 millions users around the globe and explore latest videos.",3,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("ClearTrip","IRCTC authorized train reservations, flights and hotels.",4,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        data=new ApplicationData("FreeCharge","Freecharge Deals(FRC) as the name goes is an app to recharge for free.",1,android.R.drawable.ic_menu_zoom);
        appData.add(data);
        return appData;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setViewPager(int groupPosition, int childPosition) {

        switch(groupPosition)
        {
            case 0:
                Intent intent=new Intent(getBaseContext(),RechargeAllActivity.class);
                Bundle bundle=null;
                switch(childPosition)
                {
                    case 0:break;
                    case 1:
                        bundle=new Bundle();
                        bundle.putInt(ApiConstants.RECHARGE_TYPE,ApiConstants.DTH);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 2:
                        bundle=new Bundle();
                        bundle.putInt(ApiConstants.RECHARGE_TYPE,ApiConstants.DATA_CARD);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        bundle=new Bundle();
                        bundle.putInt(ApiConstants.RECHARGE_TYPE,ApiConstants.LANDLINE);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        bundle=new Bundle();
                        bundle.putInt(ApiConstants.RECHARGE_TYPE,ApiConstants.ELECTRICITY);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        bundle=new Bundle();
                        bundle.putInt(ApiConstants.RECHARGE_TYPE,ApiConstants.GAS);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
                break;

            case 1:
                mPager.setCurrentItem(groupPosition);
                break;

            case 2:
                Intent newIntent=new Intent(getBaseContext(),OffersAllActivity.class);
                startActivity(newIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            default:break;
        }
    }

    @Override
    public void onRechargeFragment() {


    }
}
