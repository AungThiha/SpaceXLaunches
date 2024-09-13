package aung.thiha.spacex.launches

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import aung.thiha.spacex.launches.di.appModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.getKoin

@Composable
inline fun <reified T : ViewModel> getViewModel() : T {
    val koin = getKoin()
    return viewModel {
        koin.get<T>()
    }
}

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {

            val viewModel = getViewModel<AppViewModel>()

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