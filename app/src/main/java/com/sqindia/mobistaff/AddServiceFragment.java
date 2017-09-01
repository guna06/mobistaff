package com.sqindia.mobistaff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sloop.fonts.FontsManager;

/**
 * Created by Ramya on 04-04-2017.
 */

public class AddServiceFragment extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {


    private static final int NUMBER_OF_PAGES = 3;
    private RadioGroup radioGroup;
    static ViewPager pager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_service, container, false);


        FontsManager.initFormAssets(getActivity(), "lato.ttf");
        FontsManager.changeFonts(getActivity());


        pager = (ViewPager) view.findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        pager.addOnPageChangeListener(this);

        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        return view;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * When a new page becomes selected
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:

                radioGroup.check(R.id.radioButton1);
                Log.e("tag", "A1");
                break;
            case 1:
                radioGroup.check(R.id.radioButton2);
                Log.e("tag", "A2");
                break;
            case 2:
            radioGroup.check(R.id.radioButton3);
            Log.e("tag", "A3");
            break;

            default:
                radioGroup.check(R.id.radioButton1);
        }
    }

    /**
     * When the pager is automatically setting to the current page
     *
     * @param position
     */
    @Override
    public void onPageScrollStateChanged(int position) {

    }

    /**
     * On checked listener to Radio Buttons.
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton1:
                pager.setCurrentItem(0);
                Log.e("tag", "@111");
                break;
            case R.id.radioButton2:
                pager.setCurrentItem(1);
                Log.e("tag", "@222");
                break;
            case R.id.radioButton3:
                pager.setCurrentItem(2);
                Log.e("tag", "@333");
                break;
        }
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        /**
         * Constructor
         *
         * @param fm
         */
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        /**
         * Return fragment based on the position.
         *
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Log.e("tag", "JJ");
                    return new AddServiceFrag1();
                case 1:
                    return new AddServiceFrag2();

                case 2:
                    return new AddServiceFrag3();

                default:
                    Log.e("tag", "MM");
                    return new AddServiceFrag1();
            }
        }


        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        /**
         * Return the number of pages.
         *
         * @return
         */
        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }


    }

}
