package document.igt.com.androidnewrecycler.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import document.igt.com.androidnewrecycler.DataItem.ListItem;
import document.igt.com.androidnewrecycler.R;

import java.util.List;

/**
 * Created by Anup.Lal on 18-05-2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<ListItem> mListData;

    public RecyclerViewAdapter(Context context, List listData) {
        this.mContext = context;
        this.mListData = listData;
        mInflater = LayoutInflater.from(context);
        this.mListData = listData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //holder.imageView.setImageResource(mListData.get(position).getResourceId());
        holder.textView.setText(mListData.get(position).getResourceText());
        holder.textView.setTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_item);
            textView = (TextView) itemView.findViewById(R.id.txv_item);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            deleteItemFromList(getAdapterPosition());
        }
    }

    private void deleteItemFromList(int adapterPosition) {

        mListData.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

}
