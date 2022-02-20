package geek.space.tmmuse.Adapter.GalleryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import geek.space.tmmuse.Common.Constant;
import geek.space.tmmuse.Model.AllProfile.ImgProfile;
import geek.space.tmmuse.Model.TestModelViewPager.TestModelViewPager;
import geek.space.tmmuse.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ImgProfile> imgProfiles;

    public GalleryAdapter(Context context, ArrayList<ImgProfile> imgProfiles) {
        this.context = context;
        this.imgProfiles = imgProfiles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.products_gallery_item, parent, false);
        return new GalleryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {

        Glide.with(context).load(Constant.BASE_URL_IMAGE +imgProfiles.get(position).getLarge_image()).into(holder.gallery_img);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return imgProfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView gallery_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gallery_img = itemView.findViewById(R.id.gallery_img);
        }
    }
}
