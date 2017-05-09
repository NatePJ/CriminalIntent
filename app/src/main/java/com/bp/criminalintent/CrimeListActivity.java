package com.bp.criminalintent;

import android.support.v4.app.Fragment;

import com.bp.fragment.CrimeListFragment;
import com.bp.my_abstract.SingleFragmentActivity;

/**
 * Created by BP on 2017/4/25.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
