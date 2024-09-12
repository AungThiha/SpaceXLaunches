
package aung.thiha.spacex.launches.di

import aung.thiha.spacex.launches.SpaceXSDK
import aung.thiha.spacex.launches.data.network.SpaceXApi
import org.koin.core.module.Module
import org.koin.dsl.module

val spaceXSdkModule : Module = module {
    single<SpaceXApi> { SpaceXApi() }
    single<SpaceXSDK> {
        SpaceXSDK(
            databaseDriverFactory = get(), spaceXApi = get()
        )
    }
}