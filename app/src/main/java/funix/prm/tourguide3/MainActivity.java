package funix.prm.tourguide3;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        if (findViewById(R.id.contentFrame) != null) {
            // Found the ID of only one Fragment ==> Portrait mode
            // Remove the existing fragment before add new one
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
                if (fragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragmentById).commit();
                }
            }

            // Add new one
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, firstFragment).commit();
        } else {
            // Landscape mode
            // Remove the existing fragments before add new one
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment firstFragmentById = getSupportFragmentManager().findFragmentById(R.id.firstFrame);
                if (firstFragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(firstFragmentById).commit();
                }
                Fragment secondFragmentById = getSupportFragmentManager().findFragmentById(R.id.secondFrame);
                if (secondFragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(secondFragmentById).commit();
                }
            }

            // Add new one
            getSupportFragmentManager().beginTransaction().add(R.id.firstFrame, firstFragment).commit();
        }
    }



    @Override
    public void onItemPressed(int content) {
        SecondFragment secondFragment = SecondFragment.newInstance(content);
        if (findViewById(R.id.contentFrame) != null) {
            // Found the ID of only one Fragment ==> Portrait mode
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentFrame, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            // Landscape mode
            getSupportFragmentManager().beginTransaction().replace(R.id.secondFrame, secondFragment).commit();
        }
    }


}