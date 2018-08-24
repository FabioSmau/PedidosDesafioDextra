package com.desafio.dextra.promotion;

import android.arch.lifecycle.MutableLiveData;

import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.promotions.Promotion;
import com.desafio.dextra.data.model.promotions.PromotionConverter;
import com.desafio.dextra.promotion.recycler.PromotionDescriptor;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class PromotionViewModel extends BaseServiceViewModel {

    private MutableLiveData<List<PromotionDescriptor>> promotionsDescriptorLiveData = new MutableLiveData<>();
    private PromotionRepository repository = new PromotionCacheRepository();

    public MutableLiveData<List<PromotionDescriptor>> getPromotionsDescriptorLiveData() {
        return promotionsDescriptorLiveData;
    }

    public void start() {
        loadAllPromotions();
    }

    private void loadAllPromotions() {
//        if (promotionsDescriptorLiveData.getValue() == null) {
            Single<List<Promotion>> single = repository.getPromotions();

            Disposable disposable = single
                    .doOnSubscribe(disposable1 -> showProgress())
                    .doOnSubscribe(disposable12 -> hideDialogError())
                    .doAfterTerminate(this::hideProgress)
                    .map(promotions -> new PromotionConverter().convertPromotionsDescriptor(promotions))
                    .subscribe(
                            this::onReceivePromotions,
                            this::showDialogError

                    );
            DisposableManager.add(disposable);
//        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManager.dispose();
    }

    private void onReceivePromotions(List<PromotionDescriptor> promotions) {
        promotionsDescriptorLiveData.setValue(promotions);
    }

}
