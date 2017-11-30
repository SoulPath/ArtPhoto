package com.example.jannu.artphoto.ui.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.ArtPicture;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jannu on 4/11/17.
 */

public class ArtListAdapter extends BaseAdapter {
    private final List<ArtPicture> mData;
    private final LayoutInflater mLayoutInflater;

    public ArtListAdapter(Context context, @NonNull ArrayList<ArtPicture> data) {
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.fragment_art_item, parent, false);
            viewHolder = onCreateViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        onBindViewHolder(viewHolder, position);
        return convertView;
    }

    private ViewHolder onCreateViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }



    static class ViewHolder {
        @BindView(R.id.fragment_art_lblTitle)
        TextView fragmentArtLblTitle;
        @BindView(R.id.fragment_art_lblAuthor)
        TextView fragmentArtLblAuthor;
        @BindView(R.id.fragment_art_lblYear)
        TextView fragmentArtLblYear;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


        public void bind(final ArtPicture artPicture) {
            fragmentArtLblTitle.setText(artPicture.getTitle());
            fragmentArtLblAuthor.setText(artPicture.getAuthor());
            fragmentArtLblYear.setText(artPicture.getYear());

            //todo set data to the list
        }

    }

}
