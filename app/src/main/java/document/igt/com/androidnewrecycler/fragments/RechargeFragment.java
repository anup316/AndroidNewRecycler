package document.igt.com.androidnewrecycler.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.adapters.OfferViewPagerAdapter;
import document.igt.com.androidnewrecycler.layouts.CustomText;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RechargeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RechargeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class RechargeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RechargeFragmentListener mListener;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RechargeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RechargeFragment newInstance(String param1, String param2) {
        RechargeFragment fragment = new RechargeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RechargeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_recharge, container, false);
        String listOperators[]={"Airtel","Reliance","Aircel","BSNL","Vodafone"};
        ViewPager pager=(ViewPager)view.findViewById(R.id.offerPager);
        Spinner selectOperator=(Spinner)view.findViewById(R.id.spnOperator);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,listOperators);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectOperator.setAdapter(adapter);
       /* String code="+91";
        phNotext.setCompoundDrawablesWithIntrinsicBounds(new CustomText(code), null, null, null);
        phNotext.setCompoundDrawablePadding(code.length()*25);
        phNotext.setPadding(10,10,10,10);*/
       OfferViewPagerAdapter mAdapter=new OfferViewPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(mAdapter);
        return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (RechargeFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement RechargeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface RechargeFragmentListener {
        // TODO: Update argument type and name
        public void onRechargeFragment();
    }

}
