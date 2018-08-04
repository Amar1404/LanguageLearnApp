package com.example.amarjeet.miwok;

/**
 * Created by amarjeet on 2/4/18.
 */

public class Word {
    private String mDefaultTranstion;
    private String mMiwokTanstion;
    private int mAudioResourceId;
    public static final int NO_Image_Resource =-1;
    private int mImageResourceId=NO_Image_Resource;
    public Word(String defaultTranstion, String miwokTanstion,int audioResourceId){
        mMiwokTanstion =miwokTanstion;
        mDefaultTranstion =  defaultTranstion;
        mAudioResourceId =audioResourceId;
    }
    public Word(String defaultTranstion, String miwokTanstion,int imageResourceId,int audioResourceId){
        mMiwokTanstion =miwokTanstion;
        mDefaultTranstion =  defaultTranstion;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }
    public String mMiwokTanstion (){
        return mMiwokTanstion;
    }
    public  String mDefaultTanstion(){
        return mDefaultTranstion;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    public boolean getImage(){ return mImageResourceId!=NO_Image_Resource;}
    public int getAudioResourceId(){return mAudioResourceId;}
}
