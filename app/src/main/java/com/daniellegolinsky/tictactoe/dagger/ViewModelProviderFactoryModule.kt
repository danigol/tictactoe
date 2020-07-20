package com.daniellegolinsky.tictactoe.dagger

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderFactoryModule {
    @Binds
    abstract fun bindsViewModelProviderFactory(
            viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}