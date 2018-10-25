package hv.dev4u.org.contratado_app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.github.alexjlockwood.kyrie.KyrieDrawable;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    ImageView imgView;
    AnimatedVectorDrawableCompat animVect;
    KyrieDrawable kyrieAnim;
    ViewFlipper viewFlip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imgView     = findViewById(R.id.imgAnim);
        viewFlip    = findViewById(R.id.loginViewFlipper);

        animVect    = AnimatedVectorDrawableCompat.create(this, R.drawable.min_anim_logo);
        kyrieAnim   = KyrieDrawable.create(this,R.drawable.min_anim_logo);


        imgView.setImageDrawable(kyrieAnim);






        kyrieAnim.addListener(new KyrieDrawable.Listener() {
            @Override
            public void onAnimationStart(KyrieDrawable drawable) {

            }

            @Override
            public void onAnimationUpdate(KyrieDrawable drawable) {
                final float playTime = drawable.getCurrentPlayTime();
                final float totalDuration = drawable.getTotalDuration();
                final float t = (int)(totalDuration/3);

                //System.out.println("t "+t);
                System.out.println(playTime);
                if( playTime >= 2000 && playTime<=2050){
                    System.out.println("Tiempo 1 "+playTime+" duracion "+totalDuration);
                }
                if( playTime >= 4000 && playTime<=4050 ){
                    System.out.println("Tiempo 2 "+playTime+" duracion "+totalDuration);
                }
                if( playTime == 6000 && playTime<=6050 ){
                    System.out.println("Tiempo 3 "+playTime+" duracion "+totalDuration);
                }

            }

            @Override
            public void onAnimationPause(KyrieDrawable drawable) {

            }

            @Override
            public void onAnimationResume(KyrieDrawable drawable) {

            }

            @Override
            public void onAnimationCancel(KyrieDrawable drawable) {

            }

            @Override
            public void onAnimationEnd(KyrieDrawable drawable) {
                drawable.start();
            }
        });



        //esconde la barra
        getSupportActionBar().hide();

        /*
        //repetir la animacion
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        animVect.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {

            @Override
            public void onAnimationEnd(final Drawable drawable) {
                mainHandler.post(() -> {
                        viewFlip.stopFlipping();
                        animVect.start();
                    System.out.println(Arrays.toString(animVect.getState()));
                    }
                );
            }
            @Override
            public void onAnimationStart(Drawable drawable) {
                super.onAnimationStart(drawable);

                viewFlip.setDisplayedChild(0);
                viewFlip.startFlipping();
            }
        });

        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        kyrieAnim.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        kyrieAnim.stop();
    }



}

