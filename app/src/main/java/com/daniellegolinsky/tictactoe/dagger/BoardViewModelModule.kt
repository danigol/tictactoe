package com.daniellegolinsky.tictactoe.dagger

import androidx.lifecycle.ViewModel
import com.daniellegolinsky.tictactoe.viewModel.BoardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BoardViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BoardViewModel::class)
    abstract fun bindsBoardViewModel(boardViewModel: BoardViewModel): ViewModel
}