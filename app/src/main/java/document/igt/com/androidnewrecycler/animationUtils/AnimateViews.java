package document.igt.com.androidnewrecycler.animationUtils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Anup.Lal on 25-06-2015.
 */
public class AnimateViews {


    public static void animate(RecyclerView.ViewHolder holder,boolean isScrollingDown) {

        AnimatorSet set=new AnimatorSet();

        ObjectAnimator animationTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",isScrollingDown==true?300:-300,0);
       //ObjectAnimator animationTranslateX= ObjectAnimator.ofFloat(holder.itemView,"translationX",-50,50,-30,30,-20,20,-10,10,-5,5,0);
        //animationTranslateX.setDuration(1000);
        animationTranslateY.setDuration(1000);
       animationTranslateY.start();
        //set.playTogether(animationTranslateX,animationTranslateY);
        //set.start();
    }
}
