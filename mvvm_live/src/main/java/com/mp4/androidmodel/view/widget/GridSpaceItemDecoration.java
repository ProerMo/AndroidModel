package com.mp4.androidmodel.view.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mopengfei on 2018-07-23.
 */

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public GridSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((parent.getChildAdapterPosition(view) + 1) % ((GridLayoutManager) layoutManager).getSpanCount() == 0) {
                outRect.right = space;
            }
            if (parent.getChildAdapterPosition(view) < ((GridLayoutManager) layoutManager).getSpanCount()) {
                outRect.top = space;
            }
            outRect.left = space;
            outRect.bottom = space;
        }
    }
}
