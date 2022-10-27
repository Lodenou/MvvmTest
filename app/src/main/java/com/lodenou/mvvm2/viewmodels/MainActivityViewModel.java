package com.lodenou.mvvm2.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lodenou.mvvm2.models.NicePlace;
import com.lodenou.mvvm2.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mMutableLiveData;
    private NicePlaceRepository mNicePlaceRepository;

    public void init(){
        if(mMutableLiveData != null){
            return;
        }
        mNicePlaceRepository = NicePlaceRepository.getInstance();
        mMutableLiveData = mNicePlaceRepository.getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mMutableLiveData;
    }

    public void addPlace(NicePlace nicePlace){
        mNicePlaceRepository.addPlace(nicePlace);
    }
}
