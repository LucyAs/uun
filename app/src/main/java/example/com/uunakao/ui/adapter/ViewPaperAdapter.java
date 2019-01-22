package example.com.uunakao.ui.adapter;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

public class ViewPaperAdapter extends PagerAdapter {
    private List<View> views = null;

    public ViewPaperAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {

    }

    @Override
    public int getCount() {

        return views.size();
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {

        ((ViewPager) arg0).addView(views.get(arg1), 0);
        return views.get(arg1);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {

        return arg0 == arg1;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {

    }

    @Override
    public Parcelable saveState() {

        return null;
    }

    @Override
    public void startUpdate(View arg0) {

    }

}
