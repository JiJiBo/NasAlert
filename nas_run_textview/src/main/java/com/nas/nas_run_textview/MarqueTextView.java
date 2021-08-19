package com.nas.nas_run_textview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * 自定义TextView 重写isFocused()函数，让他放回true也就是一直获取了
 * 焦点效果自然也就出来了，如果这都不能解决那肯定就不是焦点问题了。
 * 那就要找到问题，在想办法解决
 */
public class MarqueTextView extends AppCompatTextView {

    public MarqueTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MarqueTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueTextView(Context context) {
        this(context, null);
    }

    @Override

    public boolean isFocused() {
        return true;
    }

    private void init() {
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setFocusableInTouchMode(true);
        setMarqueeRepeatLimit(-1);
        setSingleLine(true);
    }
}