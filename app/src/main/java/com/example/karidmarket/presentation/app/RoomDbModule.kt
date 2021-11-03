package com.example.karidmarket.presentation.app

import android.content.Context
import androidx.room.Room
import com.example.karidmarket.data.db.Database
import dagger.Module
import dagger.Provides

@Module
class RoomDbModule constructor(private val context: Context){

    @Provides
    fun providesRoomDb() : Database=
        Room.databaseBuilder(context,Database::class.java,"foodino_database").build()

}