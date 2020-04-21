package com.vishalecho.android.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Jock implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("joke")
    @Expose
    public String joke;

    @SerializedName("categories")
    @Expose
    public List<Object> categories = null;

    protected Jock(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.joke = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.categories, (java.lang.Object.class.getClassLoader()));
    }

    public final static Parcelable.Creator<Jock> CREATOR = new Creator<Jock>() {
        public Jock createFromParcel(Parcel in) {
            return new Jock(in);
        }
        public Jock[] newArray(int size) {
            return (new Jock[size]);
        }
    };

    public Jock() {
        //Empty constructor
    }

    public Jock(Integer id, String joke, List<Object> categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(joke);
        dest.writeList(categories);
    }

    public int describeContents() {
        return 0;
    }
}
