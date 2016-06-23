package com.example.balamurugan_se.learnincludeandmerge;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import view.UntouchableRelativeLayout;

public class ThirdActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int SPLASH_TIME_OUT = 5000;
    private UntouchableRelativeLayout mUntouchableRelativeLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_three);
        intiViews();
        hideProgressBar();
    }

    private void intiViews() {
        try {
            mProgressBar = (ProgressBar) findViewById(R.id.progress_view);
            mUntouchableRelativeLayout = (UntouchableRelativeLayout) findViewById(R.id.untouchable_layout);
            showProgress(true);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void hideProgressBar() {
        try {
            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    showProgress(false);
                    // close this activity
                }
            }, SPLASH_TIME_OUT);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    private void showProgress(final boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
            mUntouchableRelativeLayout.setTouchable(false);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mUntouchableRelativeLayout.setTouchable(true);
        }
    }


}
