package view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.balamurugan_se.learnincludeandmerge.R;

/**
 * Created by dhiman_da on 4/27/2016.
 */
public class UntouchableFrameLayout extends FrameLayout {
    private boolean isTouchable = false;

    public UntouchableFrameLayout(Context context) {
        this(context, null);
    }

    public UntouchableFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public UntouchableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UntouchableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.UntouchableFrameLayout);
            touchable = typedArray.getBoolean(R.styleable.UntouchableFrameLayout_touchable, true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }

        setTouchable(touchable);
    }
}
