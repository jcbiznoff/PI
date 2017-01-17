package org.in2app.pi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.in2app.pi.R;

/**
 * Created by jaychung on 10/29/16.
 */
public class SocialsFragment extends BaseFragment{
    public static SocialsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SocialsFragment fragment = new SocialsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_socials, container, false);
    }
}
