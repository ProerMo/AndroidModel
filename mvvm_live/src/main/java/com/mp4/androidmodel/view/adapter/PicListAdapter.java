package com.mp4.androidmodel.view.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.databinding.ItemPicBinding;

import java.util.List;

/**
 * TODO adapter还没完成
 * Created by mopengfei on 2018-05-17.
 */

public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicViewHolder> {
    private List<Picture> mPictureList;
    public static final int BINDING_TAG = 123;

    public PicListAdapter(@Nullable List<Picture> mPictureList) {
        if (mPictureList != null) {
            this.mPictureList = mPictureList;
        }

    }

    @NonNull
    @Override
    public PicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPicBinding binding = ItemPicBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.getRoot().setTag(BINDING_TAG, binding);
        return new PicViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PicViewHolder holder, int position) {
        ViewDataBinding mBinding = holder.getDataBinding();
        if (mBinding instanceof ItemPicBinding)
            ((ItemPicBinding) mBinding).setItem(getmPictureList().get(position));
    }

    @Override
    public int getItemCount() {
        if (mPictureList != null) {
            return mPictureList.size();
        } else return 0;
    }

    public List<Picture> getmPictureList() {
        return mPictureList;
    }

    public void setmPictureList(List<Picture> mPictureList) {
        this.mPictureList = mPictureList;
    }

    public class PicViewHolder extends RecyclerView.ViewHolder {

        public PicViewHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getDataBinding() {
            return (ViewDataBinding) itemView.getTag(BINDING_TAG);
        }
    }
}
