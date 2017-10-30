package itesm.mx.mindset;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jibril on 10/29/17.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    private int numOfFrags = 3;//Change when adding more fragments.
    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //If more fragments are needed. Create here.
        Fragment frag = null;

        switch (position)
        {
            case 0:
                frag = new Fragment();//TODO: Change to AGENDA fragment class.
            case 1:
                frag = new Fragment();//TODO: Change to MEDITACION fragment class.
            case 2:
                frag = new Fragment();//TODO: Change to TIPS fragment class.
        }

        return frag;
    }

    @Override
    public int getCount() {
        return numOfFrags;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        switch (position)
        {
            case 0:
                title = "AGENDA";
            case 1:
                title = "MEDITACION";
            case 2:
                title = "TIPS";
        }

        return title;
    }
}
