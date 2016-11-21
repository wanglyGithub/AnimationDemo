package com.wangly.loading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.iv_loading)
    ImageView iv_loading;
    @Bind(R.id.rl_content)
    RelativeLayout rl_content;

    boolean isCheck = false;
    private Animation operatingAnim;
    private Animation operatingAnim1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //----开始动画------
        AnimationUtil animationStart = new AnimationUtil.Builder()
                .withContext(this)
                .withAnimID(R.anim.start_roate_anim)
                .withFillAfter()
                .withInterpolator()
                .build();
        operatingAnim = animationStart.getAnimation();

        //----关闭动画------
        AnimationUtil animationCancle = new AnimationUtil.Builder()
                .withContext(this)
                .withAnimID(R.anim.cancle_roate_anim)
                .withFillAfter()
                .withInterpolator()
                .build();
        operatingAnim1 = animationCancle.getAnimation();

    }

    @OnClick(R.id.iv_loading)
    public void showAlert(View view) {
//        Toast.makeText(this, "点击了耶···", Toast.LENGTH_SHORT).show();
        if (isCheck == false) {
            startAnimation();
        } else {
            cancleAnimation();
        }
    }

    @OnClick(R.id.rl_content)
    public void clickContent(View view){
        cancleAnimation();
    }

    /**
     * 开启动画
     */
    private void startAnimation(){
        iv_loading.startAnimation(operatingAnim);
        rl_content.setVisibility(View.VISIBLE);
        isCheck = true;
    }

    /**
     * 关闭动画
     */
    private void cancleAnimation(){
        rl_content.setVisibility(View.GONE);
        iv_loading.startAnimation(operatingAnim1);
        isCheck = false;
    }





}
