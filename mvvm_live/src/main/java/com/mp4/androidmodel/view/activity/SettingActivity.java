package com.mp4.androidmodel.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.databinding.ActivitySettingBinding;
import com.ygsoft.utilslib.utils.OnClickHandler;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingBinding binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setAboutUsClick(aboutUsClick);

    }

    private OnClickHandler aboutUsClick = new OnClickHandler() {
        @Override
        public void onClick() {
            super.onClick();
            Toast.makeText(SettingActivity.this, "嘻嘻嘻", Toast.LENGTH_LONG).show();
        }
    };
}
