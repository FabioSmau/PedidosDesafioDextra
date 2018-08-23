package com.desafio.dextra.sandwichlist.apagar;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SandwichViewModel extends ViewModel {



    private SandwichRemoteRepository repository = new SandwichRemoteRepository();
    private MediatorLiveData<SandwichApiResponse> mediatorSandwich = new MediatorLiveData<>();
//    private MediatorLiveData<SandwichApiResponse> mediatorSandwich = new MediatorLiveData<>();




    private MutableLiveData<Throwable> error = new MutableLiveData<>();


//    public MutableLiveData<List<Sandwich>> getSandwichs() {
//        if (sandwichs == null) {
//            sandwichs = new MutableLiveData<>();
//            sandwichs.setValue(getData().getValue());
//        }
//        return sandwichs;
//    }




//    public LiveData<List<Sandwich>> getData() {
//        mediatorSandwich.addSource(repository.getSandwichsFromApi(), new Observer<SandwichApiResponse>() {
//            @Override
//            public void onChanged(@Nullable SandwichApiResponse sandwichApiResponse) {
//
//            }
//        }
//    });
//        return mediatorSandwich;
//    }

//    private void setupTimerTeste(){
//        Timer time = new Timer();
//        time.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                sandwichs.
//            }
//        },5000);
//    }


}
