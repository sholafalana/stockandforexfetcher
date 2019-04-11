package com.dexertencreatives.stockandforexfetcher.fragment;

/*
  Created by shola on 11/25/2018.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dexertencreatives.stockandforexfetcher.R;
import com.dexertencreatives.stockandforexfetcher.network.GraphFetcher;

public class PageOneFragment extends Fragment {
    LinearLayout lv;
    RelativeLayout rv;
    Activity activity;
    GraphFetcher fetch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pageone_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        lv = (LinearLayout) this.getView().findViewById(R.id.lv1);
        lv.setTag(getString(R.string.line_graph));
        rv = (RelativeLayout) this.getView().findViewById(R.id.rv1);
        //rv.setBackgroundColor(Color.BLACK);
        lv.setVisibility(View.GONE);
        fetch = new GraphFetcher(activity, lv, rv);
        fetch.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (fetch != null) {
            fetch.cancel(true);
        }


    }
}