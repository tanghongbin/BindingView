package com.binding.newbindview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.binding.R;
import com.binding.containerview.ExtendPullToRefreshRecycleView;
import com.binding.interfaces.NetRefreshViewInterface;

public class BindListContentView extends AbsBindContentView {

    private static final int DEFAULT_SPAN_COUNT = 4;
    private static final int DEFAULT_STRAGGRE_COUNT = 2;
    private ExtendPullToRefreshRecycleView extendPullToRefreshRecycleView;

    public BindListContentView(@NonNull Context context) {
        super(context);
    }

    public BindListContentView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        attrInit(context, attrs);
    }

    private void attrInit(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BindListContentView);
        int managerType = typedArray.getInt(R.styleable.BindListContentView_managerType, ManagerType.LIST.value);
        int spanCount = typedArray.getInt(R.styleable.BindListContentView_spanCount, DEFAULT_SPAN_COUNT);
        int staggeredType = typedArray.getInt(R.styleable.BindListContentView_staggeredType, DEFAULT_SPAN_COUNT);
        int staggeredCount = typedArray.getInt(R.styleable.BindListContentView_staggeredCount, DEFAULT_STRAGGRE_COUNT);

        typedArray.recycle();

        setupManager(managerType, spanCount, staggeredType,staggeredCount);


    }

    private void setupManager(int managerType, int spanCount, int staggeredType, int staggeredCount) {

        if (managerType == ManagerType.LIST.value) {
            extendPullToRefreshRecycleView.setManager(new LinearLayoutManager(mContext));
        } else if (managerType == ManagerType.GRID.value) {
            extendPullToRefreshRecycleView.setManager(new GridLayoutManager(mContext, spanCount));
        } else if (managerType == ManagerType.STICKY.value) {
            extendPullToRefreshRecycleView.setManager(new StaggeredGridLayoutManager(staggeredCount, staggeredType));
        }
    }

    @Override
    protected NetRefreshViewInterface generateBindView() {
        extendPullToRefreshRecycleView = new ExtendPullToRefreshRecycleView(mContext);
        return extendPullToRefreshRecycleView;
    }

    static enum ManagerType {
        LIST(1),
        GRID(2),
        STICKY(3);

        int value;

        ManagerType(int value) {
            this.value = value;
        }
    }
}
