package aung.thiha.spacex.launches.di

import aung.thiha.spacex.launches.data.cache.AndroidDatabaseDriverFactory
import aung.thiha.spacex.launches.data.cache.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module
    get() = module {
        single<DatabaseDriverFactory> {
            AndroidDatabaseDriverFactory(
                get()
            )
        }
    }
