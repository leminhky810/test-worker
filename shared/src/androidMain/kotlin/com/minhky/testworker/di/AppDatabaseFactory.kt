package com.minhky.testworker.di

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.minhky.testworker.database.AppDatabase
import com.minhky.testworker.database.DB_FILE_NAME
import kotlinx.coroutines.Dispatchers

actual class AppDatabaseFactory(
    private val app: Application
) {
    actual val appDatabase: AppDatabase =
        Room
            .databaseBuilder<AppDatabase>(
                context = app,
                name = app.getDatabasePath(DB_FILE_NAME).absolutePath,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()

}