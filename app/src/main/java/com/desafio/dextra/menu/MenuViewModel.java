package com.desafio.dextra.menu;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.SingleLiveEvent;
import com.desafio.dextra.promotion.PromotionListFragment;
import com.desafio.dextra.sandwich.SandwichListFragment;

public class MenuViewModel extends ViewModel {

    private SingleLiveEvent<Fragment> fragmentLiveData = new SingleLiveEvent<>();

    public MutableLiveData<Fragment> getFragmentLiveData() {
        return fragmentLiveData;
    }

    public void start(){
        if (fragmentLiveData.getValue() == null){
            fragmentLiveData.setValue(new SandwichListFragment());
        }
    }

    public boolean onItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case R.id.tab_sandwiches:
                fragmentLiveData.setValue(new SandwichListFragment());
                return true;
            case R.id.tab_promotions:
                fragmentLiveData.setValue(new PromotionListFragment());
                return true;
            default:
                return false;
        }
    }


}
