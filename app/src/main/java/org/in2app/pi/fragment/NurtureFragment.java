package org.in2app.pi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.in2app.pi.R;

/**
 * Created by jaychung on 10/29/16.
 */
public class NurtureFragment extends BaseFragment{
    public static NurtureFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NurtureFragment fragment = new NurtureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nurture, container, false);
    }
}
