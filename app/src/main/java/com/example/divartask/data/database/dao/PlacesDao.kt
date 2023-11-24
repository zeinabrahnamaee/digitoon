package com.example.divartask.data.database.dao

import androidx.room.*
import com.example.divartask.data.database.entity.PlacesEntity


@Dao
interface PlacesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(places: List<PlacesEntity>)

    @Query("SELECT * FROM PLACES_TABLE")
    fun getCities(): List<PlacesEntity>

    @Query("SELECT COUNT(id) FROM PLACES_TABLE")
    fun getCount(): Int
}