package geek.space.tmmuse.Adapter.TestAdapterViewPager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import geek.space.tmmuse.Model.TestModelViewPager.TestModelViewPager;
import geek.space.tmmuse.R;

public class TestViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<TestModelViewPager> testModelViewPagers;

    public TestViewPagerAdapter(Context context, ArrayList<TestModelViewPager> testModelViewPagers) {
        this.context = context;
        this.testModelViewPagers = testModelViewPagers;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return testModelViewPagers.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.img_carusel_adapter, null);
        TestModelViewPager testModelViewPager = testModelViewPagers.get(position);
        assert view != null;
        final RoundedImageView imageView = (RoundedImageView) view
                .findViewById(R.id.iv_carousel_image);
        Glide.with(context)
                .load(testModelViewPager.getImg_url())
                .into(imageView);

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
