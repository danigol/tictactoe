package com.daniellegolinsky.tictactoe.dagger

import com.daniellegolinsky.tictactoe.model.BoardData
import dagger.Module
import dagger.Provides

@Module
class ModelModule {
    @Provides
    fun providesBoardData(): BoardData {
        return BoardData()
    }
}