package com.ict650.hazardlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom  extends BaseAdapter {

    private ArrayList<Newslist> modelArrayList;
    private Context context;
    private int layout;
//generqate constructor

    public Custom(ArrayList<Newslist> modelArrayList, Context context, int layout) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return modelArrayList.size ();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get ( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //create view holder innter class
    private class ViewHolder{
        TextView idtxt,titletxt,bodytxt;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder ();
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        convertView=layoutInflater.inflate ( layout,null );
        //id type casting
        viewHolder.idtxt=convertView.findViewById ( R.id.idtxt );
        viewHolder.titletxt=convertView.findViewById ( R.id.titletxt );
        viewHolder.bodytxt=convertView.findViewById ( R.id.bodytxt );

        //set position
        Newslist model=modelArrayList.get ( position );
        viewHolder.idtxt.setText ( model.getTitle()+ "\n");
        viewHolder.titletxt.setText ( model.getContentDesc ()+"\n" );
        viewHolder.bodytxt.setText ( model.getDate () );
        return convertView;
    }
}
