package com.example.karidmarket.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.karidmarket.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun getDatabaseDAO(): DataBaseDao?

}