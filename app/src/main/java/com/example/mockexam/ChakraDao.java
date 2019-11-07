package com.example.mockexam;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ChakraDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ChakraEntity chakra);

    @Query("DELETE FROM chakra_info")
    void deleteAll();

    @Query("SELECT * from CHAKRA_INFO ")
    LiveData<List<ChakraEntity>> getAllChakras();
}
