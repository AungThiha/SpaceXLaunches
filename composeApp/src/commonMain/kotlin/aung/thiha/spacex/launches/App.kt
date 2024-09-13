package aung.thiha.spacex.launches

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import aung.thiha.spacex.launches.data.cache.DatabaseDriverFactory
import aung.thiha.spacex.launches.data.network.SpaceXApi
import aung.thiha.spacex.launches.di.appModule
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.getKoin

import spacexlaunches.composeapp.generated.resources.Res
import spacexlaunches.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {
            val koin = getKoin()
            AppViewModel(koin.get())
            val viewModel : AppViewModel = viewModel {
                AppViewModel(koin.get())
            }
            val state by remember { viewModel.state }
            LaunchedEffect(Unit) {
                viewModel.loadLaunches()
            }
            state.launches.firstOrNull()?.let { rocketLaunch ->
                Text(text = rocketLaunch.missionName)
            } ?: run {
                Text(text = "no mission")
            }
        }
    }
}