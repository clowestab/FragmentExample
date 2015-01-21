package com.doublenegative.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by thomasclowes on 18/01/2015.
 * Demo app to complement http://doublenegative.com/android-fragments-and-memory/
 */
public class ExampleFragment extends Fragment {

    static String TAG = "FRAGMENT";

    String instanceVariable;

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach");

        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");

        //Uncomment this appropriately to play with setRetainState
        //setRetainInstance(true);

        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");


        View view = inflater.inflate(R.layout.example_fragment, container, false);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");

        super.onActivityCreated(savedInstanceState);

        if (instanceVariable == null) {
            instanceVariable = "" + System.nanoTime();
        }

        Log.i(TAG, "Variable from " + instanceVariable);
    }


    @Override
    public void onStart() {
        Log.i(TAG, "onStart");

        super.onStart();

    }


    @Override
    public void onResume() {
        Log.i(TAG, "onResume");

        super.onResume();

    }


    @Override
    public void onPause() {
        Log.i(TAG, "onPause");

        super.onPause();

    }


    @Override
    public void onStop() {
        Log.i(TAG, "onStop");

        super.onStop();

    }


    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView");

        super.onDestroyView();

    }


    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");

        super.onDestroy();

    }


    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach");

        super.onDetach();

    }


}
