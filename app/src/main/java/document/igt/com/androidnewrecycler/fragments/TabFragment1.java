package document.igt.com.androidnewrecycler.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.network.MyVolleySingleton;


public class TabFragment1 extends Fragment {

    private ImageView mView;

    public TabFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        mView = (ImageView) view.findViewById(R.id.btn_fragment);
        Bundle bundle = getArguments();

     /*   RequestQueue requestQueue = MyVolleySingleton.getInstance().getmRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET, "http://php.net/", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Toast.makeText(getActivity().getBaseContext(),"Success"+s.substring(0,200),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity().getBaseContext(),"ERROR :"+volleyError.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(request);
*/
        if (bundle != null) {
            int postion = bundle.getInt("position");
            if(postion==0)
                mView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.deal1));
                else if(postion==1)
                mView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.deal2));
                 else if(postion==2)
                mView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.deal3));
                 else if(postion==3)
                mView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.deal4));
                else
                mView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.deal5));
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public static TabFragment1 getInstance(int postion) {
        TabFragment1 fragment = new TabFragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("position", postion);
        fragment.setArguments(bundle);
        return fragment;
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

}
