package com.bp.model;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by BP on 2017/4/24.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private DateFormat mDateFormat;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        //生成唯一标识符
        mId = UUID.randomUUID();
        mDate = new Date();
        mDateFormat = new SimpleDateFormat("EE-MM-dd-2016");
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
//        return mDateFormat.format(mDate);
        return mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
    @Override
    public String toString(){
        return mTitle;
    }
}
