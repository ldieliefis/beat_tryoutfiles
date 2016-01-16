package beat.myfirstapp;

import android.app.ActionBar;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class BeaTBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public ActionBar actionBar;
    DrawerLayout drawer;

    protected void onCreateDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getActionBar();

        drawer = (DrawerLayout) findViewById(R.id.base_activity);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_drawer);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID){
        super.setContentView(R.layout.base_activity);
        getLayoutInflater().inflate(layoutResID, (FrameLayout) findViewById(R.id.frame_content), true);
        onCreateDrawer();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_speel) {
            // Handle the action
        } else if (id == R.id.menu_account) {

        } else if (id == R.id.menu_vraagToevoegen) {

        } else if (id == R.id.menu_mijnVragen) {

        } else if (id == R.id.menu_instructies) {
            BeatPopup.Help_Pages(this, 0);
        } else if (id == R.id.menu_credits) {
            BeatPopup.Credits(this);
        } else if (id == R.id.menu_uitloggen) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
