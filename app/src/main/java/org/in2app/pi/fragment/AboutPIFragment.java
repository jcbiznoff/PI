package org.in2app.pi.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.in2app.pi.NoScrollViewPager;
import org.in2app.pi.R;

import butterknife.Bind;

/**
 * Created by jaychung on 1/16/16.
 */
public class AboutPIFragment extends BaseFragment {

    private In2IntroFragment mIn2Intro;
    private YoungAdultsIntroFragment mYoungAdultsIntro;
    private GreetingsIntroFragment mGreetingsIntro;
    private LocationInfoFragment mLocationInfo;


    public static AboutPIFragment newInstance() {
        AboutPIFragment fragment = new AboutPIFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIn2Intro = In2IntroFragment.newInstance();
        mYoungAdultsIntro = YoungAdultsIntroFragment.newInstance();
        mGreetingsIntro = GreetingsIntroFragment.newInstance();
        mLocationInfo = LocationInfoFragment.newInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_pi, container, false);
    }

    @Bind(R.id.vpIntro)
    NoScrollViewPager viewPager;

    @Bind(R.id.tabsInfo)
    TabLayout tabLayout;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(NoScrollViewPager viewPager) {
        viewPager.setAdapter(new ContentSwitcherAdapter(getChildFragmentManager()));
        viewPager.setPagingEnabled(false);
    }


    public class ContentSwitcherAdapter extends FragmentStatePagerAdapter {
        private final int NUM_TABS = 4;

        public ContentSwitcherAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mIn2Intro;
                case 1:
                    return mYoungAdultsIntro;
                case 2:
                    return mGreetingsIntro;
                case 3:
                    return mLocationInfo;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_TABS;
        }


        private final String[] tabTitles = {
                "In2",
                "청년부",
                "인삿말",
                "위치"
        };

        @Override
        public CharSequence getPageTitle(int position) {
            SpannableString sb = new SpannableString(tabTitles[position]);
            return sb;
        }
    }


}
