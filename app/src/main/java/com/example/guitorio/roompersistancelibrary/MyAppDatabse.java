package com.example.guitorio.roompersistancelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabse extends RoomDatabase{

    public abstract MyDao myDao();

}
