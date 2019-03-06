package com.binding.newbindview;

import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

public class ViewConverter {

    private ViewGroup mConvertedContainer;

    public void setConvertedContainer(ViewGroup mConvertedContainer) {
        this.mConvertedContainer = mConvertedContainer;
    }

    /**
     * 保存状态view的map
     */
    private Map<ContentStates,View> mStatusMap;

    /**
     * 上一次替换的view状态标识
     */
    private ContentStates mLastState;

    public void setStatusMap(Map<ContentStates, View> statusMap) {
        this.mStatusMap = statusMap;
    }

    public void convertView(ContentStates contentStates){
        if (!mStatusMap.containsKey(contentStates)){
            throw new IllegalArgumentException("没有定义这个枚举:" + contentStates);
        }

        // 如果两次状态相同，不用替换
        if (contentStates == mLastState) {
            return;
        }

        View replaceView = mStatusMap.get(contentStates);
        removeParentView(replaceView);
        mConvertedContainer.removeAllViews();
        mConvertedContainer.addView(replaceView);
        mLastState = contentStates;
    }

    /**
     * 如果有父view，则移除它
     * @param replaceView
     */
    private void removeParentView(View replaceView) {
        if (replaceView.getParent() == null)
            return;
        ViewGroup parent = (ViewGroup) replaceView.getParent();
        parent.removeView(replaceView);
    }


    public enum ContentStates{
        EMPTY, // 内容为空
        NORMAL, // 有内容，内容正常
        NET_ERROR, // 网络错误
        PRE_LOAD // 预加载
    }
}
