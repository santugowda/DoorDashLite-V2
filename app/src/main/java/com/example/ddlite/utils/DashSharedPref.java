package com.example.ddlite.utils;

import android.content.Context;

public class DashSharedPref extends  SharedPrefManager{

    private static final String DASH_CONFIG = "DASH_CONFIG";
    private static final String BANNER_TO_SHOW = "BANNER_TO_SHOW";

    
    protected DashSharedPref(Context context, String prefName) {
        super(context, DASH_CONFIG);
    }

    public DashSharedPref(Context context) {
        super(context, DASH_CONFIG);
    }
    
    public void setBannerToShow(boolean showBanner) {
        setBooleanPolicy(BANNER_TO_SHOW, showBanner);
    }

    public boolean showBanner(){
        return getBooleanPolicy(BANNER_TO_SHOW, true);
    }
}
