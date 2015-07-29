package com.example.jerryyin.pagetansformer3ddemo01.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jerryyin.pagetansformer3ddemo01.R;

/**
 * Created by JerryYin on 7/29/15.
 */
public class LogoPagerFragment extends Fragment{

    /**values*/
    private int POSITION = 0;
    private final int[] pages = {R.layout.logo_page1, R.layout.logo_page2, R.layout.logo_page3};

    /**Views*/
    private View mcontentView;

    /**constants*/
    private Activity myself;

    public LogoPagerFragment(int position){
        this.POSITION = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mcontentView == null){
            myself = getActivity();
            mcontentView = inflater.inflate(pages[POSITION], container, false);
            setupViews();
        }
//        else {
//            ViewGroup vg = (ViewGroup) mcontentView.getParent();
//            vg.removeView(mcontentView);
//        }

        return mcontentView;
    }

    public void setupViews(){

    }
}
