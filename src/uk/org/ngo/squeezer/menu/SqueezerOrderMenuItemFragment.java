package uk.org.ngo.squeezer.menu;

import uk.org.ngo.squeezer.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class SqueezerOrderMenuItemFragment extends Fragment {
    SqueezerOrderableListActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        activity = (SqueezerOrderableListActivity) getActivity();
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.ordermenuitem, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_item_sort:
            activity.showOrderDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void addTo(SqueezerOrderableListActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(0, new SqueezerOrderMenuItemFragment());
        fragmentTransaction.commit();
    }

    public interface SqueezerOrderableListActivity {
        public void showOrderDialog();
        FragmentManager getSupportFragmentManager();
    }

}
