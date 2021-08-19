package com.nas.nas_step_view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.nas.nas_step_view.databinding.NasStepViewLayoutBinding;

public class NasStepView extends FrameLayout {

    public NasStepView(@NonNull Context context) {
        this(context, null);
    }

    public NasStepView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NasStepView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    protected void initView() {
        NasStepViewLayoutBinding bind = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.nas_step_view_layout, null, false);
        mBind = bind;
        addView(bind.getRoot());
        initClick(bind);
    }

    protected int num = 0;
    protected NasStepViewLayoutBinding mBind;

    protected int max = Integer.MAX_VALUE;
    protected int min = 0;

    protected void initClick(NasStepViewLayoutBinding bind) {
        bind.etNum.setText(num + "");
        bind.tvAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                if (num >= max) {
                    num = max;
                }
                bind.etNum.setText(num + "");
            }
        });
        bind.tvReduce.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if (num <= min) {
                    num = min;
                }
                bind.etNum.setText(num + "");
            }
        });
        bind.etNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (listener != null) {
                    try {
                        int parseInt = Integer.parseInt(bind.etNum.getText().toString());
                        listener.change(parseInt);
                        num = parseInt;

                    } catch (Exception e) {
                        e.printStackTrace();
                        setNum(0);
                    }

                }

            }
        });
    }

    protected Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setNum(int num) {
        this.num = num;
        mBind.etNum.setText(num + "");
    }

    public int getNum() {
        return num;
    }

    public interface Listener {
        void change(int num);
    }
}
