package com.fightitwithfitness.letsplayfragments.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fightitwithfitness.letsplayfragments.R;

/**
 * Created by jpriv on 8/12/2017.
 */

public class Fragment_1 extends Fragment implements View.OnClickListener{
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    public static Fragment newInstance() {
        return new Fragment_1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_1, container, false);

        b1 = (Button) v.findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) v.findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) v.findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) v.findViewById(R.id.button4);
        b4.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                mCallbacks.onItemSelected(1);
                break;
            case R.id.button2:
                mCallbacks.onItemSelected(2);
                break;
            case R.id.button3:
                mCallbacks.onItemSelected(3);
                break;
            case R.id.button4:
                mCallbacks.onItemSelected(4);
                break;
        }
    }

    /////////////////////
    private Callbacks mCallbacks;

    public interface Callbacks{
        void onItemSelected(int i);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_1:
                mCallbacks.onItemSelected(1);
                return true;
            case  R.id.item_2:
                mCallbacks.onItemSelected(2);
                return true;
            case R.id.item_3:
                mCallbacks.onItemSelected(3);
                return true;
            case R.id.item_4:
                mCallbacks.onItemSelected(4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    /////////////////////////

}
