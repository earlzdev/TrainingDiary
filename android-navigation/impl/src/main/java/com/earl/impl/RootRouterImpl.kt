package com.earl.impl

import androidx.compose.runtime.Composable
import com.earl.api.RootRouter

class RootRouterImpl: RootRouter {

    @Composable
    override fun Root() = RootScene()
}