package view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.example.balamurugan_se.learnincludeandmerge.R;

/**
 * Created by balamurugan_se on 6/23/2016.
 */
public class UntouchableRelativeLayout extends RelativeLayout {
    private boolean isTouchable = false;

    public UntouchableRelativeLayout(Context context) {
        this(context, null);
    }

    public UntouchableRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public UntouchableRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UntouchableRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.UntouchableRelativeLayout);
            touchable = typedArray.getBoolean(R.styleable.UntouchableRelativeLayout_touchable, true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }

        setTouchable(touchable);
    }
}
