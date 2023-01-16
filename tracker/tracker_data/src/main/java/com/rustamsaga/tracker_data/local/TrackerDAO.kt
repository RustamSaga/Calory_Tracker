package com.rustamsaga.tracker_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.rustamsaga.tracker_data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertTrackedFood(trackerFoodEntity: TrackedFoodEntity)

    @Delete
    suspend fun deleteTrackedFood(trackerFoodEntity: TrackedFoodEntity)

    @Query(
        """
            SELECT * 
            FROM trackedfoodentity
            WHERE dayOfMonth =:day AND month =:month AND year =:year
        """
    )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>

}