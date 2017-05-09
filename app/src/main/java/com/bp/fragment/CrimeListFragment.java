package com.bp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.bp.criminalintent.CrimeActivity;
import com.bp.criminalintent.CrimePagerActivity;
import com.bp.criminalintent.R;
import com.bp.model.Crime;
import com.bp.model.CrimeLab;

import java.util.ArrayList;

/**
 * Created by BP on 2017/4/25.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    private static final String TAG ="CrimeListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        /**
         * getActivity()
         * 获取activity
         */
        getActivity().setTitle(R.string.crimes_title);
        /**
         * 先获取crimelab单例，再获取列表
         */
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        /**
         * Adapter
         */
//        ArrayAdapter<Crime> adapter =
//                new ArrayAdapter<Crime>(
//                        getActivity(),
//                        android.R.layout.simple_list_item_1,
//                        mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
//        Crime c = (Crime)(getListAdapter()).getItem(position);
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        /**
         * 点击启动CrimeActivity
         */
//        Intent i = new Intent(getActivity(), CrimeActivity.class);
        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getId());
        startActivity(i);
        Log.d(TAG,c.getTitle() + "was clicked");
    }

    /**
     * 视图切换后model保存了数据
     */
    @Override
    public void onResume(){
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }


    /**
     * 内部类
     * 知道如何和crime交互
     */
    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public  CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), 0, crimes);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);
            }

            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dataTextView);
            dateTextView.setText(c.getDate().toString());

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }
}
