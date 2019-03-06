package com.binding.adapter;

import android.support.annotation.Nullable;

import com.binding.interfaces.BindNetAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public abstract class BaseRecycleAapter<T> extends BaseQuickAdapter<T,BaseViewHolder>
 implements BindNetAdapter {
    public BaseRecycleAapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    public void notifyMetaDataChange() {
        notifyDataSetChanged();
    }
}
