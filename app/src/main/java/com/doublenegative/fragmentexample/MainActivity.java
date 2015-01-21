package com.doublenegative.fragmentexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by thomasclowes on 18/01/2015.
 * Demo app to complement http://doublenegative.com/android-fragments-and-memory/
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    static String TAG = "ACTIVITY";

    Boolean addToBackstack = false;

    FragmentManager fm;

    ExampleFragment fragmentReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        Button removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(this);
        Button attachButton = (Button) findViewById(R.id.attachButton);
        attachButton.setOnClickListener(this);
        Button detachButton = (Button) findViewById(R.id.detachButton);
        detachButton.setOnClickListener(this);
        Button showButton = (Button) findViewById(R.id.showButton);
        showButton.setOnClickListener(this);
        Button hideButton = (Button) findViewById(R.id.hideButton);
        hideButton.setOnClickListener(this);
        Button popButton = (Button) findViewById(R.id.popButton);
        popButton.setOnClickListener(this);

        CheckBox addToBackstackCheckbox = (CheckBox) findViewById(R.id.backstackCheckbox);
        addToBackstackCheckbox.setOnCheckedChangeListener(this);

        fm = getSupportFragmentManager();

        /*Log.i(TAG, "Remove Transaction Start");
        FragmentTransaction ft2 = fm.beginTransaction();
        ft2.remove(fragment);
        ft2.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Remove Transaction End");*/
    }


    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        switch (viewId) {
            case R.id.addButton:
                addFragment();
                break;
            case R.id.removeButton:
                removeFragment();
                break;
            case R.id.attachButton:
                attachFragment();
                break;
            case R.id.detachButton:
                detachFragment();
                break;
            case R.id.showButton:
                showFragment();
                break;
            case R.id.hideButton:
                hideFragment();
                break;
            case R.id.popButton:
                doPop();
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        addToBackstack = isChecked;
    }


    public void addFragment() {

        Log.i(TAG, "Add Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        fragmentReference = new ExampleFragment();
        ft.add(R.id.fragmentContainer, fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameAdd");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Add Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));


    }


    public void removeFragment() {

        Log.i(TAG, "Remove Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        ExampleFragment fragment = new ExampleFragment();
        ft.remove(fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameRemove");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Remove Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));


    }


    public void attachFragment() {

        Log.i(TAG, "Attach Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        ft.attach(fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameAttach");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Attach Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));


    }


    public void detachFragment() {

        Log.i(TAG, "Detach Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        ft.detach(fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameDetach");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Detach Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));

    }


    public void showFragment() {

        Log.i(TAG, "Show Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameShow");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Show Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));


    }


    public void hideFragment() {

        Log.i(TAG, "Hide Transaction Start");
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(fragmentReference);

        if (addToBackstack) {
            ft.addToBackStack("backstackNameHide");
        }

        ft.commit();

        fm.executePendingTransactions();

        Log.i(TAG, "Hide Transaction End");
        Log.i(TAG, "Fragment is null? " + (fragmentReference == null));


    }

    public void doPop() {

        Log.i(TAG, "Start Pop Backstack " + fm.getBackStackEntryCount());
        fm.popBackStack();
    }
}
