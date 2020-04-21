package com.vishalecho.android.data;

import com.vishalecho.android.data.network.services.JockService;

public class DataManager {

    private static DataManager mInstance;

    private DataManager() {
        //Empty non-public constructor
    }

    public static synchronized DataManager getInstance() {
        if (mInstance == null) {
            mInstance = new DataManager();
        }
        return mInstance;
    }

    public JockService getJockService() {
        return JockService.getInstance();
    }
}
