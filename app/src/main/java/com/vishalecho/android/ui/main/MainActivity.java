package com.vishalecho.android.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.vishalecho.android.R;
import com.vishalecho.android.data.DataManager;
import com.vishalecho.android.data.network.model.Jock;
import com.vishalecho.android.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainViewModel> {

    @BindView(R.id.recycler_view_jocks_list)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_general_info)
    TextView infoTextView;

    private RandomJocksAdapter jocksAdapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = this;

        jocksAdapter = new RandomJocksAdapter();
        recyclerView.setAdapter(jocksAdapter);

        viewModel.getLoadingStatus().observe(this, new LoadingObserver());
        viewModel.getJock().observe(this, new JockObserver());
    }

    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        MainViewModelFactory factory = new MainViewModelFactory(DataManager.getInstance().getJockService());
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }

    @OnClick(R.id.btn_get_jocks)
    void onFetchRandomJockBtnClick() {
        viewModel.loadJock();
    }
    /**
     * Progress Bar Loading Observer
     * */
    private class LoadingObserver implements Observer<Boolean> {

        @Override
        public void onChanged(@Nullable Boolean isLoading) {
            if (isLoading == null) return;

            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Random Jock Call Observer
     * */
    private class JockObserver implements Observer<Jock> {

        @Override
        public void onChanged(@Nullable Jock jock) {
            if (jock == null) {
                infoTextView.setVisibility(View.VISIBLE);
                infoTextView.setText(R.string.error_msg);
            } else {
                infoTextView.setVisibility(View.GONE);
                new AlertDialog.Builder(context)
                        .setTitle(R.string.dialog_title)
                        .setMessage(jock.getJoke())
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with add jock operation
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            }
        }
    }
}
