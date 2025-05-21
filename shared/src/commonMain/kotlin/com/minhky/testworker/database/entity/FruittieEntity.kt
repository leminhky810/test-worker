package com.minhky.testworker.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.minhky.testworker.domain.model.Fruittie
import com.minhky.testworker.network.model.FruittieDto

@Entity(tableName = "fruitties")
data class FruittieEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val fullName: String,
    val calories: String,
)