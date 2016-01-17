package org.in2app.pi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.in2app.pi.R;

/**
 * Created by jaychung on 1/16/16.
 */
public class YoungAdultsIntroFragment extends Fragment {

    public static YoungAdultsIntroFragment newInstance() {
        YoungAdultsIntroFragment fragment = new YoungAdultsIntroFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_youngadult_intro, container, false );
    }
}
