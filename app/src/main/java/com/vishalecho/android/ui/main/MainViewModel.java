package com.vishalecho.android.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.vishalecho.android.data.network.model.Jock;
import com.vishalecho.android.data.network.model.JockResponse;
import com.vishalecho.android.data.network.services.JockService;
import com.vishalecho.android.ui.base.BaseViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<Jock> jockMutableLiveData;
    private MutableLiveData<Boolean> isLoadingMutableLiveData;

    private JockService jockService;

    MainViewModel(JockService jockService) {
        this.jockService = jockService;
        jockMutableLiveData = new MutableLiveData<>();
        isLoadingMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Jock> getJock() {
        return jockMutableLiveData;
    }

    public void setJock(Jock jock) {
        setLoadingStatus(true);
        this.jockMutableLiveData.postValue(jock);
    }

    public MutableLiveData<Boolean> getLoadingStatus() {
        return isLoadingMutableLiveData;
    }

    public void setLoadingStatus(boolean loading) {
        isLoadingMutableLiveData.postValue(loading);
    }

    void loadJock() {
        jockService.getJockApi().getRandomJock().enqueue(new JockCallback());
    }

    private class JockCallback implements Callback<JockResponse> {

        @Override
        public void onResponse(@NonNull Call<JockResponse> call, @NonNull Response<JockResponse> response) {
            JockResponse jockResponse = response.body();

            if (jockResponse != null) {
                setJock(jockResponse.getJock());
            } else {
                setJock(new Jock());
            }
        }

        @Override
        public void onFailure(Call<JockResponse> call, Throwable t) {
            setJock(new Jock());
        }
    }
}
