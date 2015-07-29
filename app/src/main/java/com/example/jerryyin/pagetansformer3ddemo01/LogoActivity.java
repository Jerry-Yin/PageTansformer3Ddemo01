package com.example.jerryyin.pagetansformer3ddemo01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jerryyin.pagetansformer3ddemo01.Fragments.LogoPagerFragment;
import com.example.jerryyin.pagetansformer3ddemo01.PageTransformer.LogoPageTransformer;


public class LogoActivity extends ActionBarActivity {

    /**constant*/
    private final int PAGE_COUNT = 3;
    private final int LOGO_PAGE1 = 0;
    private final int LOGO_PAGE2 = 1;
    private final int LOGO_PAGE3 = 2;

    /**Views*/
    private ViewPager mviewPager;
    private LogoPagerFragment mLogoPageFragment;

    /**Values*/
    private PagerAdapter mviewPageAdapter;
    private FragmentManager mfragmentManager;
    private LogoPageTransformer mpageTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        initViewPager();
    }

    public void initViewPager(){
        mviewPager = (ViewPager) findViewById(R.id.viewpager);
        mfragmentManager = getSupportFragmentManager();
        mviewPageAdapter = new MyViewPagerAdapter(mfragmentManager);
        mpageTransformer = new LogoPageTransformer();
        mviewPager.setAdapter(mviewPageAdapter);
        mviewPager.setPageTransformer(true, mpageTransformer);
    }


    class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case LOGO_PAGE1:
                    return getLogoPagreFragment(position);

                case LOGO_PAGE2:
                    return getLogoPagreFragment(position);

                case LOGO_PAGE3:
                    return getLogoPagreFragment(position);

                default:
                    break;
            }
            return null;
        }
    }


    private LogoPagerFragment getLogoPagreFragment(int num){
        mLogoPageFragment = new LogoPagerFragment(num);
        return mLogoPageFragment;
    }
}
