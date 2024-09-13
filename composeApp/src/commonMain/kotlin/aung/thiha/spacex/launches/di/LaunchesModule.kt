package aung.thiha.spacex.launches.di

import aung.thiha.spacex.launches.AppViewModel
import org.koin.dsl.module

val launchesModule = module {
    factory {
        AppViewModel(get())
    }
}