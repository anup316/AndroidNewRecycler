package document.igt.com.androidnewrecycler.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import document.igt.com.androidnewrecycler.R;

/**
 * Created by Anup.Lal on 22-06-2015.
 */
public class NavigationDrawerExpandableListAdapter extends BaseExpandableListAdapter {

    private LayoutInflater mInflater;
    private ArrayList<String> mParentItem;
    private Map<String,ArrayList<String>> allItems;


   public  NavigationDrawerExpandableListAdapter(Context context,ArrayList<String> parentItem,Map<String,ArrayList<String>> allItems)
    {
        mInflater=LayoutInflater.from(context);
        this.mParentItem =parentItem;
        this.allItems =allItems;
    }

    @Override
    public int getGroupCount() {
        return mParentItem.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return allItems.get(mParentItem.get(i)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return mParentItem.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return allItems.get(mParentItem.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerListName = (String) getGroup(groupPosition);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.group_item_exp_list, null);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.txv_group_header);
        textView.setText(headerListName);

        ImageView imgView=(ImageView)convertView.findViewById(R.id.img_indicator);
     if(isExpanded)
     {
         imgView.setImageResource(R.drawable.minus);
         textView.setTypeface(null, Typeface.BOLD);
         textView.setTextColor(Color.parseColor("#000000"));
     }
     else
     {
         imgView.setImageResource(R.drawable.add);
         textView.setTypeface(null, Typeface.NORMAL);
         textView.setTextColor(Color.parseColor("#777777"));
     }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)  {

        String childItem = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.child_item_exp_list, null);

        }

        TextView textView=(TextView)convertView.findViewById(R.id.txv_childItem);
        textView.setText(childItem);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
