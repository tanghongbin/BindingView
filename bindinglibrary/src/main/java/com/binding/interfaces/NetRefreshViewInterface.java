package com.binding.interfaces;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * Created by tanghongbin on 2017/9/9.
 */

public interface NetRefreshViewInterface {
    void setBindNetOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener);
    View getBindNetRefreshableView();
    void setBindNetOnRefreshListener(BindRefreshListener bindRefreshListener);
    void setBindNetLayoutParams(ViewGroup.LayoutParams params);
    View getBindView();
    void setBindNetAdapter(BindNetAdapter adapter);
    void setModeBoth();
    void setModePullFromUp();
    void setModePullFromDown();
    void setModeDisabled();

    void onBindNetRefreshComplete();

    BindNetMode getBindNetMode();
}
