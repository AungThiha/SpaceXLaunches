package aung.thiha.spacex.launches

import aung.thiha.spacex.launches.data.cache.Database
import aung.thiha.spacex.launches.data.cache.DatabaseDriverFactory
import aung.thiha.spacex.launches.data.model.RocketLaunch
import aung.thiha.spacex.launches.data.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory, val spaceXApi: SpaceXApi) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            spaceXApi.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
        }
    }
}