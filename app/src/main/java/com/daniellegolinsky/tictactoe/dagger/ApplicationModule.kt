package com.daniellegolinsky.tictactoe.dagger

import com.daniellegolinsky.tictactoe.ResourceProvider
import com.daniellegolinsky.tictactoe.TicTacToeApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun providesResourceProvider(): ResourceProvider {
        return TicTacToeApplication.resourceProvider
    }
}