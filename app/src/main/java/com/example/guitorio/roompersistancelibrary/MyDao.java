package com.example.guitorio.roompersistancelibrary;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    //public LiveData<List<User>> getUsers();
    List<User> getUsers();

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);
}
