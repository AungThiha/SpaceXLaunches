package aung.thiha.spacex.launches.di

import aung.thiha.spacex.launches.data.cache.IOSDatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module
    get() = module {
        single { IOSDatabaseDriverFactory() }
    }
