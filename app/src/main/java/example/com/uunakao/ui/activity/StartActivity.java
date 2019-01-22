package example.com.uunakao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.TextView;

import example.com.uunakao.R;
import example.com.uunakao.ui.fragment.ProfileFragment;
import example.com.uunakao.ui.fragment.SessionFragment;
import example.com.uunakao.ui.fragment.SettingFragment;
import example.com.uunakao.ui.fragment.SeviceFragment;
import example.com.uunakao.ui.widget.TabView;
import example.com.uunakao.util.DialogUtils;
import example.com.uunakao.util.FragmentUtils;

public class StartActivity extends FragmentActivity implements TabView.OnTabChangeListener, FragmentCallback {
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;
    private TabView mTabView;
    private TextView mTitleTextView;

    /** 上一次的状态 */
    private int mPreviousTabIndex = 1;
    /** 当前状态 */
    private int mCurrentTabIndex = 1;

    /** 再按一次退出程序*/
    private long exitTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        mCurrentTabIndex = 1;
        mPreviousTabIndex = 1;
        setupViews();
    }

    private void setupViews() {
        setContentView(R.layout.activity_start);
        mTitleTextView = (TextView) findViewById(R.id.text_title);
        mTabView = (TabView) findViewById(R.id.view_tab);
        mTabView.setOnTabChangeListener(this);
        mTabView.setCurrentTab(mCurrentTabIndex);
        mCurrentFragment = new SeviceFragment();
        FragmentUtils.replaceFragment(mFragmentManager, R.id.layout_content, SeviceFragment.class, null, false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {/*
            case BaseActivity.REQUEST_OK_LOGIN:
                if (resultCode == RESULT_OK) {
                    ApplicationUtils.showToast(this, R.string.text_loginsuccess);
                    mTitleTextView.setText(R.string.text_tab_profile);
                    final ProfileFragment profileFragment =
                            (ProfileFragment) mFragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
                    if (profileFragment != null) {
                        Log.d(TAG, "ProfileFragment is refreshing.");
                        profileFragment.refreshViews();
                    } else {
                        Log.e(TAG, "ProfileFragment is null.");
                    }
                } else {
                    // 返回原来的页面
                    mTabView.setCurrentTab(mPreviousTabIndex);
                    ApplicationUtils.showToast(this, R.string.toast_login_failed);
                }
                break;

            default:
                break;
        */
        }
    }

    @Override
    public void onFragmentCallback(Fragment fragment, int id, Bundle args) {
        mTabView.setCurrentTab(1);
    }


    @Override
    public void onTabChange(String tag) {
        if (tag != null) {
            if (tag.equals("message")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 0;
                mTitleTextView.setText(R.string.text_tab_message);
                replaceFragment(SessionFragment.class);
                // 检查，如果没有登录则跳转到登录界面
              /*  final UserConfigManager manager = UserConfigManager.getInstance();
                if (manager.getId() <= 0) {
                    startActivityForResult(new Intent(this, LoginActivity.class),
                            BaseActivity.REQUEST_OK_LOGIN);
                }*/
            }else if ("service".equals(tag)) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 1;
                mTitleTextView.setText(R.string.text_tab_service);
                replaceFragment(SeviceFragment.class);
            } else if (tag.equals("personal")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 2;
                mTitleTextView.setText(R.string.text_tab_profile);
                replaceFragment(ProfileFragment.class);
                // 检查，如果没有登录则跳转到登录界面
              /*  final UserConfigManager manager = UserConfigManager.getInstance();
                if (manager.getId() <= 0) {
                    startActivityForResult(new Intent(this, LoginActivity.class),
                            BaseActivity.REQUEST_OK_LOGIN);
                }*/
            } else if (tag.equals("settings")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 3;
                mTitleTextView.setText(R.string.text_tab_setting);
                replaceFragment(SettingFragment.class);
                // 检查，如果没有登录则跳转到登录界面
               /* final UserConfigManager manager = UserConfigManager.getInstance();
                if (manager.getId() <= 0) {
                    startActivityForResult(new Intent(this, LoginActivity.class),
                            BaseActivity.REQUEST_OK_LOGIN);
                }*/
            }
        }
    }

    private void replaceFragment(Class<? extends Fragment> newFragment) {

        mCurrentFragment = FragmentUtils.switchFragment(mFragmentManager,
                R.id.layout_content, mCurrentFragment,
                newFragment, null, false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                DialogUtils.showToast(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
