package com.vishalecho.android.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JockResponse {

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("value")
    @Expose
    public Jock jock;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Jock getJock() {
        return jock;
    }

    public void setJock(Jock jock) {
        this.jock = jock;
    }
}
