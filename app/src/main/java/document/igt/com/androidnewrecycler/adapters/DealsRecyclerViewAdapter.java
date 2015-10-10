package document.igt.com.androidnewrecycler.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import document.igt.com.androidnewrecycler.DataItem.ListItem;
import document.igt.com.androidnewrecycler.R;
import document.igt.com.androidnewrecycler.animationUtils.AnimateViews;
import document.igt.com.androidnewrecycler.models.ApplicationData;

/**
 * Created by Anup.Lal on 15-06-2015.
 */
public class DealsRecyclerViewAdapter extends RecyclerView.Adapter<DealsRecyclerViewAdapter.MyViewHolder>  {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ApplicationData> mAppData;
    private int previousPosition=0;

    public DealsRecyclerViewAdapter(Context context, ArrayList<ApplicationData> appData) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mAppData = appData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.deals_list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ApplicationData appData=mAppData.get(position);
        if(appData.getAppName().equalsIgnoreCase("udemy"))
        {
            holder.appLogo.setBackground(mContext.getResources().getDrawable(R.drawable.udemy));
        }

        else if(appData.getAppName().equalsIgnoreCase("Freecharge"))
        {
            holder.appLogo.setBackground(mContext.getResources().getDrawable(R.drawable.freecharge));
        }
        else if(appData.getAppName().equalsIgnoreCase("ClearTrip"))
        {
            holder.appLogo.setBackground(mContext.getResources().getDrawable(R.drawable.cleartrip));
        }
        holder.appName.setText(appData.getAppName());
        holder.appDescription.setText(appData.getAppDescription());
        holder.appRating.setRating(new Float(appData.getAppRating()));

        if(position>previousPosition)
        {
            AnimateViews.animate(holder,true);
        }
        else
        {
            AnimateViews.animate(holder,false);
        }
        previousPosition=position;
    }

    @Override
    public int getItemCount() {
        return mAppData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView appLogo;
        private TextView appName;
        private TextView appDescription;
        private RatingBar appRating;

        public MyViewHolder(View itemView) {
            super(itemView);
            appLogo = (ImageView) itemView.findViewById(R.id.img_appLogo);
            appName = (TextView) itemView.findViewById(R.id.txv_appName);
            appDescription = (TextView) itemView.findViewById(R.id.txv_appDesc);
            appRating = (RatingBar) itemView.findViewById(R.id.rtg_appRating);
            appLogo.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

          //  deleteItemFromList(getAdapterPosition());


        }
    }
    public ApplicationData  getData()
    {
     return mAppData.get(0);
    }

}
