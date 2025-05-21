package com.minhky.testworker.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.minhky.testworker.database.AppDatabase
import com.minhky.testworker.database.DB_FILE_NAME
import com.minhky.testworker.database.dao.FruitteDao
import kotlinx.coroutines.Dispatchers

actual class AppDatabaseFactory(
    private val context: Context
) {
    actual fun createAppDatabase(): AppDatabase =
        Room
            .databaseBuilder<AppDatabase>(
                context = context,
                name = context.getDatabasePath(DB_FILE_NAME).absolutePath,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
}

actual val AppDatabaseFactory.fruitteeDao: FruitteDao
    get() = createAppDatabase().fruitteeDao()

