package example.com.uunakao.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.uunakao.R;
import example.com.uunakao.ui.activity.BaseFragment;

public class ProfileFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
