package com.mp4.androidmodel.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mp4.androidmodel.databinding.ItemPicBinding;

/**
 * TODO adapter还没完成
 * Created by mopengfei on 2018-05-17.
 */

public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicViewHolder> {

    @NonNull
    @Override
    public PicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPicBinding binding = ItemPicBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PicViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PicViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PicViewHolder extends RecyclerView.ViewHolder {

        public PicViewHolder(View itemView) {
            super(itemView);
        }
    }
}
