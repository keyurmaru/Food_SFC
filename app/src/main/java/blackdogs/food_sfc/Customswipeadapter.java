package blackdogs.food_sfc;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by keyur on 17-07-2016.
 */

public class Customswipeadapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5,R.drawable.item6,
    R.drawable.item7};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public Customswipeadapter(Context ctx)
    {
        this.ctx =ctx;

    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view ==((LinearLayout)o);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageview= (ImageView) item_view.findViewById(R.id.image_View);
        TextView textView= (TextView) item_view.findViewById(R.id.image_counter);
        imageview.setImageResource(image_resources[position]);
        textView.setText("image :: "+position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }
}
