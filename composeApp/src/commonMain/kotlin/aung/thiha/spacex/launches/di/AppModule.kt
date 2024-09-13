package aung.thiha.spacex.launches.di

import org.koin.core.module.Module

val appModule : List<Module> = listOf(
    databaseModule,
    spaceXSdkModule,
    launchesModule,
    platformModule
)