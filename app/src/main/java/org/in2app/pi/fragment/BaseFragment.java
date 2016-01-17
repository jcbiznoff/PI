package org.in2app.pi.fragment;

/**
 * Created by jaychung on 1/16/16.
 */

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.in2app.pi.MainActivity;
import org.in2app.pi.R;

import butterknife.ButterKnife;
/**
 * Base fragment for handling
 * what it does:
 * 1. binds butter knife for you
 * 2. adds toolbar for you
 * 3. set a back icon on the toolbar
 * 4. opens interface for changing the name of toolbar
 * Created by jaychung on 11/5/15.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        setToolbar();
    }

    private void setToolbar() {
        ((MainActivity) getActivity()).setDrawerState(false);

        @SuppressLint("PrivateResource")
        final Drawable upArrow = ContextCompat.getDrawable(getContext(), R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        int arrowColor = ContextCompat.getColor(getContext(), R.color.white);

        if (upArrow != null)
            upArrow.setColorFilter(arrowColor, PorterDuff.Mode.SRC_ATOP);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(upArrow);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().getSupportFragmentManager().popBackStack();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
