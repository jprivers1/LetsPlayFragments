package com.fightitwithfitness.letsplayfragments.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fightitwithfitness.letsplayfragments.R;
import com.fightitwithfitness.letsplayfragments.fragments.Fragment_1;
import com.fightitwithfitness.letsplayfragments.fragments.Fragment_2;
import com.fightitwithfitness.letsplayfragments.fragments.Fragment_3;
import com.fightitwithfitness.letsplayfragments.fragments.Fragment_4;

public class MainActivity extends AppCompatActivity implements Fragment_1.Callbacks, Fragment_2.Callbacks, Fragment_3.Callbacks, Fragment_4.Callbacks{
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    protected Fragment createFragment(){
        return Fragment_1.newInstance();
    }

    @Override
    public void onItemSelected(int i){
        switch (i){
            case 1:
                Fragment one = Fragment_1.newInstance();
                fm.beginTransaction()
                        //.add(R.id.fragment_container, one)
                        .replace(R.id.fragment_container, one)
                        //.remove(R.id.fragment_container, one)
                        .addToBackStack(null)
                        .commit();
                break;
            case 2:
                Fragment two = Fragment_2.newInstance();
                fm.beginTransaction()
                        //.add(R.id.fragment_container, two)
                        .replace(R.id.fragment_container, two)
                        //.remove(R.id.fragment_container, two)
                        .addToBackStack(null)
                        .commit();
                break;
            case 3:
                Fragment three = Fragment_3.newInstance();
                        //fm.popBackStack();
                        fm.beginTransaction()
                        //.add(R.id.fragment_container, three)
                        .replace(R.id.fragment_container, three)
                        //.remove(R.id.fragment_container, three)
                        .addToBackStack(null)
                        .commit();
                break;
            case 4:
                Fragment four = Fragment_4.newInstance();
                fm.beginTransaction()
                        //.add(R.id.fragment_container, four)
                        .replace(R.id.fragment_container, four)
                        //.remove(R.id.fragment_container, four)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
