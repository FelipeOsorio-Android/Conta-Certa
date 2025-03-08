package com.example.contacerta.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieEventListener
import com.lottiefiles.dotlottie.core.util.DotLottieSource

@Composable
fun CustomSplashScreen(
    modifier: Modifier = Modifier,
    onFinishedAnimation: () -> Unit = {}
) {
    val dotController = remember { DotLottieController() }
    val dotEventListener = remember {
        object : DotLottieEventListener {
            override fun onComplete() {
                super.onComplete()
                onFinishedAnimation()
            }
        }
    }

    LaunchedEffect(Unit) {
        dotController.addEventListener(dotEventListener)
    }

    DotLottieAnimation(
        source = DotLottieSource.Asset("splash_animated.lottie"),
        controller = dotController,
        modifier = modifier.fillMaxSize(),
        autoplay = true
    )
}

@Preview
@Composable
private fun CustomSplashScreenPreview() {
    CustomSplashScreen()
}