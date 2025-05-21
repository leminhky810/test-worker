package com.minhky.testworker.database

import androidx.room.RoomDatabaseConstructor

public actual object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
  actual override fun initialize(): AppDatabase = com.minhky.testworker.database.AppDatabase_Impl()
}
