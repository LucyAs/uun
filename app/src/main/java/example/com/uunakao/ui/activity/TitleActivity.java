package example.com.uunakao.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import example.com.uunakao.R;

public class TitleActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTitleTextView;
    private Button mBackwardButton;
    private Button mForwardButton;
    private FrameLayout mContentLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_backward:
                onBackward(v);
                break;
            case R.id.button_forward:
                onForward(v);
                break;
            default:
                break;
        }
    }

    protected void showBackwardView(int backwardResid, boolean show){
        if(mBackwardButton != null){
            if(show){
                mBackwardButton.setText(backwardResid);
                mBackwardButton.setVisibility(View.VISIBLE);
            }else{
                mBackwardButton.setVisibility(View.INVISIBLE);
            }
        }
    }

    protected void showForwardView(int forwardResId, boolean show){
        if(mForwardButton != null){
            if(show){
                mForwardButton.setText(forwardResId);
                mForwardButton.setVisibility(View.VISIBLE);
            }else{
                mForwardButton.setVisibility(View.INVISIBLE);
            }
        }
    }

    protected void onForward(View forwardView) {

    }

    protected void onBackward(View backwardView) {
        finish();
    }

    @Override
    public void setTitle(int titleId) {
        mTitleTextView.setText(titleId);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitleTextView.setText(title);
    }

    @Override
    public void setTitleColor(int textColor) {
        mTitleTextView.setText(textColor);
    }

    @Override
    public void setContentView(int layoutResID) {
        mContentLayout.removeAllViews();
        View.inflate(this, layoutResID, mContentLayout);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view);
        onContentChanged();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view,params);
        onContentChanged();
    }
    

    private void setupViews() {
        super.setContentView(R.layout.activity_title);

        mTitleTextView = (TextView) findViewById(R.id.text_title);
        mContentLayout = (FrameLayout) findViewById(R.id.layout_content);

        mBackwardButton = (Button) findViewById(R.id.button_backward);
        mForwardButton = (Button) findViewById(R.id.button_forward);
    }


}

