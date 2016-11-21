package com.wangly.loading;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

/**
 * Created by wangly on 2016/11/21.
 *
 * 采用Builder 的设计模式创建该动画示例
 * 在调用的时候可以根据实际的情况定制Animation
 * 因为该示例为Demo 样式，所以再调用的时候就没有进行区分(传参)
 *
 */

public class AnimationUtil {
    private boolean fillAfter;
    private boolean interpolator;
    private int animID;
    private Context mContext;



    private AnimationUtil(Builder builder) {

        this.fillAfter = builder.fillAfter;
        this.interpolator = builder.interpolator;
        this.animID = builder.animID;
        this.mContext = builder.mContext;
    }


    public Animation getAnimation() {

        Animation operatingAnim = AnimationUtils.loadAnimation(this.mContext, this.animID);
        LinearInterpolator lin = new LinearInterpolator();

        if (this.fillAfter) {
            operatingAnim.setFillAfter(true);
        }

        if (this.interpolator) {
            operatingAnim.setInterpolator(lin);
        }


        return operatingAnim;
    }


    public static class Builder {
        private Context mContext;
        private boolean fillAfter;
        private boolean interpolator;
        private int animID;

        public Builder() {

        }

        public Builder withAnimID(int animID) {
            this.animID = animID;
            return this;
        }


        public Builder withContext(Context mContext) {
            this.mContext = mContext;
            return this;
        }


        public Builder withFillAfter() {
            this.fillAfter = true;
            return this;
        }


        public Builder withInterpolator() {
            this.interpolator = true;
            return this;
        }


        public AnimationUtil build() {
            return new AnimationUtil(this);
        }


    }

}
