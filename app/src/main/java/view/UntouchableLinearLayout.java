package view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.example.balamurugan_se.learnincludeandmerge.R;

/**
 * Created by balamurugan_se on 6/23/2016.
 */
public class UntouchableLinearLayout extends LinearLayout {
    private boolean isTouchable = false;

    public UntouchableLinearLayout(Context context) {
        this(context, null);
    }

    public UntouchableLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public UntouchableLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UntouchableLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !isTouchable;
    }

    public boolean isTouchable() {
        return isTouchable;
    }

    public void setTouchable(boolean touchable) {
        isTouchable = touchable;
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = null;
        boolean touchable = true;

        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.UntouchableLinearLayout);
            touchable = typedArray.getBoolean(R.styleable.UntouchableLinearLayout_touchable, true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }

        setTouchable(touchable);
    }
}
