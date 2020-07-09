package com.lgt.nimbus.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgt.nimbus.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<MenuModel> listDataHeader;
    private HashMap<MenuModel, List<MenuChildModel>> listDataChild;
    int[] imageId = {
            R.drawable.logout,
            R.drawable.logout,
            R.drawable.logout,
            R.drawable.logout,
            R.drawable.logout,
            R.drawable.logout,
            R.drawable.logout
    };
    public ExpandableListAdapter(Context context, List<MenuModel> listDataHeader,
                                 HashMap<MenuModel, List<MenuChildModel>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;


    }

    @Override
    public MenuChildModel getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = getChild(groupPosition, childPosition).menuName;
        //  final ImageView childImage = getChild(groupPosition, childPosition).menuImage;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Configuration config = context.getResources().getConfiguration();

            Log.d("ScreenSizeWidth",String.valueOf(config.smallestScreenWidthDp));

            if (config.smallestScreenWidthDp >= 600)
            {
                convertView = infalInflater.inflate(R.layout.list_group_child_tab, null);
            }else {
                convertView = infalInflater.inflate(R.layout.list_group_child, null);
            }


        }

        TextView txtListChild = convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if (this.listDataChild.get(this.listDataHeader.get(groupPosition)) == null)
            return 0;
        else
            return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                    .size();
    }

    @Override
    public MenuModel getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String headerTitle = getGroup(groupPosition).menuName;

        // headerImage=getGroup(groupPosition).menuImage;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            Configuration config = context.getResources().getConfiguration();

            Log.d("ScreenSizeWidth",String.valueOf(config.smallestScreenWidthDp));

            if (config.smallestScreenWidthDp >= 600)
            {
                convertView = infalInflater.inflate(R.layout.list_group_header_tab, null);
            }else {
                convertView = infalInflater.inflate(R.layout.list_group_header, null);
            }

        }

        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        ImageView imageView=convertView.findViewById(R.id.img);
        imageView.setImageResource(imageId[groupPosition]);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        lblListHeader.setText(headerTitle);
        // lbimage.setImage

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
