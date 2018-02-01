package com.example.ahmedetman.quiz.views.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.views.fragments.LoginFragment;
import com.example.ahmedetman.quiz.views.fragments.RegisterFragment;

import java.util.ArrayList;
import java.util.List;


public class ActHome extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.homeViewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.homeTabs);
        tabLayout.setupWithViewPager(viewPager);


        /*User  user = new User();
        user.setLastName("etman");
        user.setFirstName("ahmed");
        user.setMobileNumber("010170");
        user.setPassword("passwrod");
        user.setUserType(Constants.UserType.Private.toString());

        //User.UserCrud.createUser(user);

        User.UserCrud.retrieveAllUsers();*/
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "Login");
        adapter.addFragment(new RegisterFragment(), "Register");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}