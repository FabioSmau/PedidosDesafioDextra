package com.desafio.dextra.sandwichlist.apagar;

import android.arch.lifecycle.MutableLiveData;

import com.desafio.dextra.remote.RetrofitSingleton;
import com.desafio.dextra.sandwichlist.SandwishAPI;

import retrofit2.Retrofit;

public class SandwichRemoteRepository  {

//    @Override
//    public List<Sandwich> getSandwichs() {
//        getSandwichsFromApi();
//        return new ArrayList<>();
//    }

    public MutableLiveData<SandwichApiResponse> getSandwichsFromApi() {
        MutableLiveData<SandwichApiResponse> sandwichsLiveData = new MutableLiveData<>();

        Retrofit retrofit = RetrofitSingleton.getInstance();
        SandwishAPI sandwishAPI = retrofit.create(SandwishAPI.class);

//        sandwishAPI.getSandwichs().enqueue(new Callback<List<SandwichDto>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<SandwichDto>> call, @NonNull Response<List<SandwichDto>> response) {
//                Log.i(getClass().getSimpleName(), "Sucesso!");
//                sandwichsLiveData.setValue(new SandwichApiResponse(response.body()));
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<SandwichDto>> call, @NonNull Throwable t) {
//                Log.e(getClass().getSimpleName(), t.getMessage());
//                sandwichsLiveData.setValue(new SandwichApiResponse(t));
//            }
//        });

        return sandwichsLiveData;
    }

//    private List<SandwichDto> getSandwichs(){
//
//        Retrofit retrofit = RetrofitSingleton.getInstance();
//        SandwishAPI sandwishAPI = retrofit.create(SandwishAPI.class);
//
//        sandwishAPI.getSandwichs().enqueue(new Callback<List<SandwichDto>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<SandwichDto>> call, @NonNull Response<List<SandwichDto>> response) {
//                sandwichsLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<SandwichDto>> call, Throwable t) {
//
//            }
//        });
//        return data;
//    }
}
