package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsUiContent

@Composable
fun VideoRailsController(
    uniflow: VideoRailsUniflow<*>/* = hiltViewModel<VideoRailsViewModel>()*/
) {
    val state by uniflow.uiState.collectAsStateWithLifecycle()
    VideoRailsUiContent(state, uniflow::handleEvent)
    BackHandler { uniflow.handleEvent(VideoRailsEvent.OnCloseClicked) }

//    val localContext = LocalContext.current
//    uniflow.sideEffect.collectWithLifecycle { effect ->
//        when (effect) {
//            VideoRailsSideEffect.Close -> (localContext as? Activity)?.finish()
//            // other side effects...
//            is VideoRailsSideEffect.GoToVideo -> TODO()
//        }
//    }
}
