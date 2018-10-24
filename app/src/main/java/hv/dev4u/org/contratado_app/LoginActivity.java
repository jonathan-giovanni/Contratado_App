package hv.dev4u.org.contratado_app;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class LoginActivity extends AppCompatActivity {

    ImageView imgView;
    AnimatedVectorDrawableCompat animVect;
    ViewFlipper viewFlip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imgView     = findViewById(R.id.imgAnim);
        animVect    = AnimatedVectorDrawableCompat.create(this, R.drawable.min_anim_logo);
        viewFlip    = findViewById(R.id.loginViewFlipper);



        imgView.setImageDrawable(animVect);

        //esconde la barra
        getSupportActionBar().hide();



        //repetir la animacion
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        animVect.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {


            @Override
            public void onAnimationEnd(final Drawable drawable) {
                mainHandler.post(() -> {
                        viewFlip.stopFlipping();
                        animVect.start();
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        animVect.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        animVect.stop();
    }
}
