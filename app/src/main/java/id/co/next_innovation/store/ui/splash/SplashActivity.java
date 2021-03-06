package id.co.next_innovation.store.ui.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.sign.in.SignInActivity;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashMvpPresenter<SplashView> mPresenter;

    private static final int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        //startSplashAnimation();

        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(SplashActivity.this, SignInActivity.class);
            startActivity(i);

            // close this activity
            finish();
        }, SPLASH_TIME_OUT);
    }

//    @Override
//    public void startSplashAnimation() {
//        Object localObject = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "scaleX", 5.0F, 1.0F);
//        ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
//        ((ObjectAnimator)localObject).setDuration(1500L);
//        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "scaleY", 5.0F, 1.0F);
//        localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
//        localObjectAnimator1.setDuration(1500L);
//        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "alpha", 0.0F, 1.0F);
//        localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
//        localObjectAnimator2.setDuration(1500L);
//        AnimatorSet localAnimatorSet = new AnimatorSet();
//        localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
//        localAnimatorSet.setStartDelay(1500L);
//        localAnimatorSet.start();
//        findViewById(R.id.imagelogo).setAlpha(1.0F);
//        localObject = AnimationUtils.loadAnimation(this, R.anim.fade);
//        findViewById(R.id.imagelogo).startAnimation((Animation)localObject);
//    }


}
