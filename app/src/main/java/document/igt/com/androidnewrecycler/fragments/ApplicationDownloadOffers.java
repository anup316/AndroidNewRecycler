package document.igt.com.androidnewrecycler.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.adapters.DealsRecyclerViewAdapter;
import document.igt.com.androidnewrecycler.models.ApplicationData;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ApplicationDownloadOffers.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ApplicationDownloadOffers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplicationDownloadOffers extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DealsRecyclerViewAdapter adapter;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApplicationDownloadOffers.
     */
    // TODO: Rename and change types and number of parameters
    public static ApplicationDownloadOffers newInstance(ArrayList<ApplicationData> appData) {
        ApplicationDownloadOffers fragment = new ApplicationDownloadOffers();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("APPDATA", appData);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ApplicationDownloadOffers() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<ApplicationData> appData = new ArrayList<ApplicationData>();
        View view = inflater.inflate(R.layout.fragment_deals, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {

            appData = arguments.getParcelableArrayList("APPDATA");

        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listDeals);
        adapter=new DealsRecyclerViewAdapter(getActivity().getBaseContext(),appData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Button button=(Button)view.findViewById(R.id.clickMe);
        button.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.clickMe: callBack();
        }
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

    private void callBack()
    {
        ApplicationData data=adapter.getData();
        Toast.makeText(getActivity(),data.getAppName(),Toast.LENGTH_SHORT).show();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


}
