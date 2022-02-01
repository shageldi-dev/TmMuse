package geek.space.tmmuse.Adapter.TestAdapterViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import geek.space.tmmuse.Model.TestModelViewPager.TestModelViewPager;
import geek.space.tmmuse.R;

public class TestAdapterViewPager extends RecyclerView.Adapter<TestAdapterViewPager.ViewHolder> {
    private Context context;
    private ArrayList<TestModelViewPager> testModelViewPagers;
    private ViewPager viewPager;
    private boolean isFirst=true;

    public TestAdapterViewPager(Context context, ArrayList<TestModelViewPager> testModelViewPagers, ViewPager viewPager) {
        this.context = context;
        this.testModelViewPagers = testModelViewPagers;
        this.viewPager = viewPager;
        viewPager.setAdapter(new TestViewPagerAdapter(context, testModelViewPagers));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_profile_rec_adapter, parent, false);
        return new TestAdapterViewPager.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        TestModelViewPager testModelViewPager = testModelViewPagers.get(position);
        if(isFirst){
            Glide.with(context).load(testModelViewPager.getImg_url()).into(holder.product_img);
            viewPager.setAdapter(new TestViewPagerAdapter(context, testModelViewPagers));
            isFirst=false;
        }
        holder.product_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(position);
            }
        });
        Glide.with(context).load(testModelViewPager.getImg_url()).into(holder.product_img);
    }

    @Override
    public int getItemCount() {
        return testModelViewPagers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView product_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            product_img = itemView.findViewById(R.id.product_img);
        }
    }
}
