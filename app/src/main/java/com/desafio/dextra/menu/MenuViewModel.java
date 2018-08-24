package com.desafio.dextra.menu;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.desafio.dextra.R;
import com.desafio.dextra.sandwichlist.SandwichListFragment;

public class MenuViewModel extends ViewModel {

    public MutableLiveData<Fragment> getFragmentLiveData() {
        return fragmentLiveData;
    }

    private MutableLiveData<Fragment> fragmentLiveData = new MutableLiveData<>();

    public boolean onItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case R.id.tab_sandwiches:
                fragmentLiveData.setValue(new SandwichListFragment());
                return true;
            case R.id.tab_promotions:
                return true;
            default:
                return false;
        }
    }

}
