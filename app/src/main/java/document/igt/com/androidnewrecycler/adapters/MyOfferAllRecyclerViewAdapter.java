package document.igt.com.androidnewrecycler.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import document.igt.com.androidnewrecycler.DataItem.OffersItem;
import document.igt.com.androidnewrecycler.R;

/**
 * Created by Anup.Lal on 27-06-2015.
 */
public class MyOfferAllRecyclerViewAdapter extends RecyclerView.Adapter<MyOfferAllRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<OffersItem> mOfferData;
    private LayoutInflater mInflater;
    public MyOfferAllRecyclerViewAdapter(Context context,ArrayList<OffersItem> offerData)
    {
        mContext=context;
        mOfferData=offerData;
        mInflater=LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View holderView=mInflater.inflate(R.layout.offerall_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(holderView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        OffersItem item=mOfferData.get(position);
        holder.discountText.setText(item.getmLabel());
        holder.priceText.setText("Rs"+ " "+String.valueOf(item.getmPrice()));
        holder.itemImage.setBackground(item.getmLogo());
    }

    @Override
    public int getItemCount() {
        return mOfferData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout itemImage;
        private TextView discountText;
        private TextView priceText;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage = (RelativeLayout) itemView.findViewById(R.id.lyt_offerAll_itemImage);
            itemImage.setOnClickListener(this);
            discountText = (TextView) itemView.findViewById(R.id.txv_offerAll_discRate);
            priceText = (TextView) itemView.findViewById(R.id.txv_offerAll_price);
        }

        @Override
        public void onClick(View view) {



        }
    }
}
