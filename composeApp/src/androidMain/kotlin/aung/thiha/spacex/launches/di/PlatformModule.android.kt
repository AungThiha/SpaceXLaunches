package aung.thiha.spacex.launches.di

import android.content.Context
import aung.thiha.spacex.launches.provider.ContextHolder
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<Context> {
        ContextHolder.context
    }
}