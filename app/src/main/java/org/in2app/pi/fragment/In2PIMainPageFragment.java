package org.in2app.pi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import org.in2app.pi.MainActivity;
import org.in2app.pi.R;

/**
 * Created by jaychung on 1/16/16.
 */
public class In2PIMainPageFragment extends Fragment {
    public static In2PIMainPageFragment newInstance() {
        In2PIMainPageFragment fragment = new In2PIMainPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_in2main, container, false);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        ((MainActivity) getActivity()).setDrawerState(true);
    }
}
