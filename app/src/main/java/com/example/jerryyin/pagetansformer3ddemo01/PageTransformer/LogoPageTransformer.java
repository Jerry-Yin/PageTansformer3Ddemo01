package com.example.jerryyin.pagetansformer3ddemo01.PageTransformer;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.jerryyin.pagetansformer3ddemo01.R;

/**
 * Created by JerryYin on 7/29/15.
 */
public class LogoPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {

        //视差效果，让布局里面的子控件都给一个加速偏移量 [-1, 1]
        if (position > -1 && position < 1){
            ViewGroup relatlayout = (ViewGroup) view.findViewById(R.id.relativelayout);

            for (int i = 0; i < relatlayout.getChildCount(); i++){
                View child = relatlayout.getChildAt(i);
                float factor = (float) (Math.random()*4);

                if (child.getTag() == null){
                    child.setTag(factor);
                }else {
                    factor = (float) child.getTag();
                }
                //getwidth() 是控件的宽度。也就是控件开始的位置，再次基础上再加上偏移量
                child.setTranslationX(position*factor*child.getWidth());
            }

            //缩放 （0-1）
//            relatlayout.setScaleX(1 - Math.abs(position));
//            relatlayout.setScaleY(1 - Math.abs(position));

            relatlayout.setScaleX(Math.max(0.8f, 1 - Math.abs(position)));
            relatlayout.setScaleY(Math.max(0.8f, 1 - Math.abs(position)));

            //3D翻转
            relatlayout.setPivotX(position > 0f ? 0 : relatlayout.getWidth());
            relatlayout.setPivotY(relatlayout.getHeight()*0.3f);
            relatlayout.setRotationY(position*90);
        }
    }


}
