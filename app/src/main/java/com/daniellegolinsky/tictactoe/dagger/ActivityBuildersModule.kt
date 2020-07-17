package com.daniellegolinsky.tictactoe.dagger

import com.daniellegolinsky.tictactoe.view.GameActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = [
                BoardViewModelModule::class
            ]
    )
    abstract fun contributesGameActivity(): GameActivity
}