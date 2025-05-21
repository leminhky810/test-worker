package com.minhky.testworker.di

import androidx.room.Room
import com.minhky.testworker.database.AppDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import com.minhky.testworker.database.DB_FILE_NAME
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.minhky.testworker.database.dao.FruitteDao

actual class AppDatabaseFactory() {
    actual fun createAppDatabase(): AppDatabase =
        Room.databaseBuilder<AppDatabase>(
                name = "${fileDirectory()}/$DB_FILE_NAME",
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()


    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory).path!!
    }
}

actual val AppDatabaseFactory.fruitteeDao: FruitteDao
    get() = createAppDatabase().fruitteeDao()