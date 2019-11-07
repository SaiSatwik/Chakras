package com.example.mockexam;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "chakra_info")
public class ChakraEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @NonNull
    @ColumnInfo(name = "chakra_name")
    private String name;
    @NonNull
    @ColumnInfo(name = "chakra_info")
    private String info;
    @ColumnInfo(name = "favourite")
    private boolean fav;

    public ChakraEntity(@NonNull String name, @NonNull String info, boolean fav) {
        this.name = name;
        this.info = info;
        this.fav = fav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getInfo() {
        return info;
    }

    public void setInfo(@NonNull String info) {
        this.info = info;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
