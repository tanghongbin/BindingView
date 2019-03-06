package com.binding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by tanghongbin on 2017/4/15.
 */

public class DefaultErrorView extends ClickableView {
    private View view;
    private TextView no_content;
    private ImageView no_content_image;

    public DefaultErrorView(Context context) {
        super(context);
        initDefault(context);
    }


    public DefaultErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDefault(context);
    }


    @Override
    public void setNoContentClickListener(OnClickListener onClickListener) {
        no_content.setOnClickListener(onClickListener);
        no_content_image.setOnClickListener(onClickListener);
    }


    private void initDefault(Context context) {
        view = View.inflate(context, R.layout.nearby_no_content, this);
        no_content = (TextView) view.findViewById(R.id.no_content);
        no_content_image = (ImageView) view.findViewById(R.id.no_content_image);

    }

    public void setErrorImage(Drawable drawable) {
        no_content_image.setImageDrawable(drawable);
    }

    public void setErrorImage(int resId) {
        no_content_image.setImageResource(resId);
    }

    public void setErrorImage(Bitmap bitmap) {
        no_content_image.setImageBitmap(bitmap);
    }

    public void setErrorImage(String url) {
        //// TODO: 2017/7/24 暂时默认图没有实现网络下载显示

    }

    public void setErrorMessage(String message) {
        no_content.setText(message);
    }
}
