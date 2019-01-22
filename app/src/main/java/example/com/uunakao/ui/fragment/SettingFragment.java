package example.com.uunakao.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.uunakao.R;
import example.com.uunakao.ui.activity.BaseFragment;
import example.com.uunakao.ui.activity.setting.AboutActivity;

public class SettingFragment extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.layout_about).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            default:
                break;
        }
    }
}
