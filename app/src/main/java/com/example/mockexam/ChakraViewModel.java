package com.example.mockexam;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ChakraViewModel extends AndroidViewModel {

    private ChakraRepository mRepository;

    private LiveData<List<ChakraEntity>> mAllChakras;

    public ChakraViewModel (Application application) {
        super(application);
        mRepository = new ChakraRepository(application);
        mAllChakras = mRepository.getAllChakras();
    }

    LiveData<List<ChakraEntity>> getAllChakras() { return mAllChakras; }

    public void insert(ChakraEntity chakra) { mRepository.insert(chakra); }
    public void deleteAll() { mRepository.deleteAll(); }
}
