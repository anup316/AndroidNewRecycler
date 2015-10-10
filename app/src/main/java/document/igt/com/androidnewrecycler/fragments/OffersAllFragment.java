package document.igt.com.androidnewrecycler.fragments;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.DataItem.OffersItem;
import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.adapters.MyOfferAllRecyclerViewAdapter;

public class OffersAllFragment extends Fragment {

    public static OffersAllFragment newInstance() {
        OffersAllFragment fragment = new OffersAllFragment();
        return fragment;
    }

    public OffersAllFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_offers_all, container, false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.offerAllRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SpacesItemDecoration(1));
        MyOfferAllRecyclerViewAdapter adapter=new MyOfferAllRecyclerViewAdapter(getActivity().getBaseContext(),getOfferData());
       recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private ArrayList<OffersItem> getOfferData()
    {
        ArrayList<OffersItem> allDealItem=new ArrayList<OffersItem>();

        OffersItem offerItem=new OffersItem();
        offerItem.setmLabel("25 % off on food bills");
        offerItem.setmPrice(10);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.ibibo));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("Get Rs 500 off at Vab Heusen");
        offerItem.setmPrice(6);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.vanheusen));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off on Pentaloons trowsers");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.pantaloons));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off at Richardo");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.ricardo));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("80 % off at Zomato");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.zomato));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off on Puma shoes");
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.deal3));
        offerItem.setmPrice(100);
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("25 % off on food bills");
        offerItem.setmPrice(10);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.ibibo));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("Get Rs 500 off at Vab Heusen");
        offerItem.setmPrice(6);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.vanheusen));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off on Pentaloons trowsers");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.pantaloons));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off at Richardo");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.ricardo));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("80 % off at Zomato");
        offerItem.setmPrice(100);
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.zomato));
        allDealItem.add(offerItem);

        offerItem=new OffersItem();
        offerItem.setmLabel("30 % off on Puma shoes");
        offerItem.setmLogo(ContextCompat.getDrawable(getActivity(), R.drawable.deal3));
        offerItem.setmPrice(100);

        allDealItem.add(offerItem);

        return allDealItem;

    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            int pos=parent.getChildAdapterPosition(view);

            if(pos%2==0)
            {
                outRect.right = space;
                outRect.bottom = space;
                outRect.top = space;

            }
            else
            {
                outRect.left = space;
                outRect.bottom = space;
                outRect.top = space;
            }

        }
    }

}
