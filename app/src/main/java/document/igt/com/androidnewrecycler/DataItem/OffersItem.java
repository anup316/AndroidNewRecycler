package document.igt.com.androidnewrecycler.DataItem;

import android.graphics.drawable.Drawable;

/**
 * Created by Anup.Lal on 27-06-2015.
 */
public class OffersItem {

    public String getmLabel() {
        return mLabel;
    }

    public void setmLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }



    public Drawable getmLogo() {
        return mLogo;
    }

    public void setmLogo(Drawable mLogo) {
        this.mLogo = mLogo;
    }

    private Drawable mLogo;
    private String mLabel;
    private int mPrice;
}
