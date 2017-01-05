package snow.com.zoomimage;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import snow.com.zoomimage.view.ZoomImage;

public class MainActivity extends AppCompatActivity {

    private ZoomImage imageview;
    private ViewPager mViewPager;

    private int[] imgs = new int[]{
            R.drawable.git,
            R.drawable.iii,
            R.drawable.m};
    private ImageView[] mImgs = new ImageView[imgs.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);


        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                imageview = new ZoomImage(getApplicationContext());
                imageview.setImageResource(imgs[position]);
                container.addView(imageview);
                mImgs[position] = imageview;
                return imageview;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(mImgs[position]);
            }

            @Override
            public int getCount() {
                return mImgs.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }
}
