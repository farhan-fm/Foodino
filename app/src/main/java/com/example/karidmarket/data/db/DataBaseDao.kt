package com.example.karidmarket.data.db

import androidx.room.*
import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single

@Dao
interface DataBaseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addUser(userEntity: UserEntity) : Single<Long>?

    @Update
    fun updateUser(userEntity: UserEntity) : Single<Int>?

    @Query("SELECT * FROM user_tb WHERE id==:id")
    fun readUser(id:Int) : Single<UserEntity>?

    @Query("SELECT * FROM user_tb WHERE userName==:userName AND password==:password")
    fun loginUser(userName:String,password:String) : Single<UserEntity>

}