package hv.dev4u.org.contratado_app;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity {



    public final int MAIN_PAGES = 3;

    BottomNavigationViewEx bottomNavigation;
    ArrayList<Badge> badges;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation_main);
        initBadgets();
        setBadgetValueAt(0,9999);
        setBadgetValueAt(1,1);
        setBadgetValueAt(2,2);

        Button btnPruebas = findViewById(R.id.btnPruebas);
        btnPruebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeBadgeAtt(c);
                c++;
                if(c>=3 && c<6){
                    badges.get(c-3).setBadgeNumber(12+c);
                }else{
                    badges.get(1).setBadgeNumber(c);
                }
            }
        });

    }
    private void initBadgets(){
        badges = new ArrayList<>();
        for(int i=0;i< MAIN_PAGES;i++){
            badges.add(
                new QBadgeView(this)
                .setBadgeGravity(Gravity.END|Gravity.TOP)
                .setGravityOffset(28, 1, true)
                .bindTarget(bottomNavigation.getBottomNavigationItemView(i))
            );
        }
    }
    private void setBadgetValueAt(int position, int number) {
        badges.get(position).setBadgeNumber(number);
    }

    private void removeBadgeAtt(int position){
        if(position<badges.size()) badges.get(position).hide(true);
    }


}
