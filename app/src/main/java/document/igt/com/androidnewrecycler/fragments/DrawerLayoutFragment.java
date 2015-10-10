package document.igt.com.androidnewrecycler.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import document.igt.com.androidnewrecycler.DataItem.ListItem;
import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.adapters.NavigationDrawerExpandableListAdapter;
import document.igt.com.androidnewrecycler.adapters.RecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DrawerLayoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DrawerLayoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawerLayoutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ActivityCallback mListener;

    ArrayList<String> groupList;
    ArrayList<String> childList;
    Map<String, ArrayList<String>> allItems;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private List<ListItem> mDataList;
    private ExpandableListView mListView;

    public DrawerLayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            mListener=(ActivityCallback)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()
                    + " must implement ActivityCallback");


        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String [] rechargeModels={"Mobile","DTH","Data Card","Landline/Broadband","Electricity","Gas"};
        String [] offers={"All Deals","Most Popular Apps","Cheap & Best","Most discount"};
        String [] dealsModels={"All Deals","Most Popular","Food & Entertainment","Health & Wellness","Shopping","Travel"};
        String [] electronics={"The Electronic Store","Mobile & Accessories","Computers & Laptops" ,"Camera & Accesories"};
        String [] women={"The Women's Store","Clothing","Ethnic Wear" ,"Western Wear", "Sunglasses & Shades" ,"Bags & Purses"};
        String [] men={"The Men's Store","Clothing","Footwear" ,"Watches", "Sunglasses & Shades" ,"Bags & Luggages"};

        allItems = new LinkedHashMap<String, ArrayList<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("Recharge or Pay For")) {
                loadChild(rechargeModels);
            } else if (laptop.equals("Deals"))
                loadChild(dealsModels);
            else if (laptop.equals("Offers"))
                loadChild(offers);
            else if (laptop.equals("Electronics"))
                loadChild(electronics);
            else if (laptop.equals("Men"))
                loadChild(men);
            else
                loadChild(women);
            allItems.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }


    private void setGroupIndicatorToRight() {
		/* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        mListView.setIndicatorBounds(width - getDipsFromPixel(50), width
                - getDipsFromPixel(10));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }


    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Recharge or Pay For");
        groupList.add("Offers");
        groupList.add("Deals");
        groupList.add("Electronics");
        groupList.add("Men");
        groupList.add("Women");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_drawer_layout, container, false);
       /* mDataList=new ArrayList<ListItem>();
        ListItem item=new ListItem();
        item.setResourceId(android.R.drawable.ic_btn_speak_now);
        item.setResourceText("Recharge");
        mDataList.add(item);
        item=new ListItem();
        item.setResourceId(android.R.drawable.ic_menu_add);
        item.setResourceText("Offers");
        mDataList.add(item);
        item=new ListItem();
        item.setResourceId(android.R.drawable.ic_delete);
        item.setResourceText("Deals");
        mDataList.add(item);*/
       // mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        //RecyclerViewAdapter adapter=new RecyclerViewAdapter(getActivity().getBaseContext(),mDataList);
       // mRecyclerView.setAdapter(adapter);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        createGroupList();
        createCollection();


        mListView=(ExpandableListView)view.findViewById(R.id.expListMenu);
        setGroupIndicatorToRight();
        final NavigationDrawerExpandableListAdapter adapter=new NavigationDrawerExpandableListAdapter(getActivity().getBaseContext(),groupList,allItems);
        mListView.setAdapter(adapter);
        //setGroupIndicatorToRight();

        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) adapter.getChild(groupPosition, childPosition);
                mDrawerLayout.closeDrawers();
                mListener.setViewPager(groupPosition,childPosition);
                return true;
            }
        });



        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            public boolean onGroupClick(ExpandableListView parent, View v,  int groupPosition, long id)
            {



                return false;
            }
        });

        return view;
    }


    public void setUp(DrawerLayout drawerLayout, final Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface ActivityCallback
    {
        void setViewPager(int groupPosition,int childPosition);
    }


}
