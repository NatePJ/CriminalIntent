package com.bp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by BP on 2017/4/25.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    /**
     * 返回的是一个对象
     * @param c
     * @return
     */
    public static CrimeLab get(Context c){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab((c.getApplicationContext()));
        }
        return sCrimeLab;
    }

    /**
     * 返回数组列表
     * @return
     */
    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    /**
     * 带有指定id的Crime对象
     * @param id
     * @return
     */
    public Crime getCrime(UUID id){
        for(Crime c:mCrimes){
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }

}
