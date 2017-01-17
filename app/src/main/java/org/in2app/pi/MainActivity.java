package org.in2app.pi;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.FacebookSdk;

import org.in2app.DefaultSubscriber;
import org.in2app.pi.data.FeedDataMapper;
import org.in2app.pi.fragment.AboutPIFragment;
import org.in2app.pi.fragment.CommunicationFragment;
import org.in2app.pi.fragment.EvangelismFragment;
import org.in2app.pi.fragment.In2PIMainPageFragment;
import org.in2app.pi.fragment.NurtureFragment;
import org.in2app.pi.fragment.SocialsFragment;
import org.in2app.pi.fragment.WorshipFragment;
import org.in2app.pi.ui.model.FeedUIData;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        FeedDataMapper feedDataMapper = new FeedDataMapper();
//        App.getRestClient()
//                .getFacebookGraphApi()
//                .getPublicFeed(
//                getResources().getString(R.string.facebook_access_token),
//                "type, message, created_time")
//                .map(feeds -> feedDataMapper.transform(feeds))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new FacebookQuerySubscriber());

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showInitialPage(savedInstanceState == null);
    }

    private final class FacebookQuerySubscriber extends DefaultSubscriber<FeedUIData> {

        @Override public void onCompleted() {
            Log.d("complete", "completed");
        }

        @Override public void onError(Throwable e) {
            Log.d("error", "completed");
        }

        @Override public void onNext(FeedUIData feedUIData) {
            Log.d("done", feedUIData.getCategory());
        }
    }

    private void showInitialPage(boolean isFirstTime) {
        if (isFirstTime) {
            Fragment in2PIMainPageFragment
                    = In2PIMainPageFragment.newInstance();
            Navigator.moveToFragment(this, in2PIMainPageFragment);
        }
    }

    @Override
    public void onBackPressed() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_nurture) {
            Fragment aboutPiFragment = NurtureFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);

        } else if (id == R.id.nav_worship) {
            Fragment aboutPiFragment = WorshipFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);

        } else if (id == R.id.nav_communicatino) {
            Fragment aboutPiFragment = CommunicationFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);

        } else if (id == R.id.nav_evangelism) {
            Fragment aboutPiFragment = EvangelismFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);

        } else if (id == R.id.nav_socials) {
            Fragment aboutPiFragment = SocialsFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);

        } else if (id == R.id.nav_about_pi) {
            Fragment aboutPiFragment = AboutPIFragment.newInstance();
            Navigator.moveToFragment(this, aboutPiFragment);
        } else if (id == R.id.nav_gallery) {

        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setDrawerState(boolean isEnabled) {
        if (isEnabled) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerToggle.syncState();
        } else {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            mDrawerToggle.setToolbarNavigationClickListener(v -> onBackPressed());
            mDrawerToggle.syncState();
        }
    }

}
