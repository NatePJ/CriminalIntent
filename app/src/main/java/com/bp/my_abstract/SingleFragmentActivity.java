package com.bp.my_abstract;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.bp.criminalintent.R;

/**
 * Created by BP on 2017/4/25.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if(fragment == null){
            fragment = createFragment();
            /**
             * 创建了一个fragment事务
             * beginTransaction()创建并返回FragmentTransaction实例，可得到FragmentTransaction队列
             * 创建一个新的事务，加入一个添加操作，然后提交该事务
             * add()
             *  + 容器视图资源id，新创建的CrimeFragment
             *
             */
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
