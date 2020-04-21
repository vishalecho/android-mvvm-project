package com.vishalecho.android.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.vishalecho.android.data.network.services.JockService;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final JockService jockService;

    public MainViewModelFactory(JockService jockService) {
        this.jockService = jockService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(jockService);
        }

        throw new IllegalArgumentException("Unknown VM Class");
    }
}
