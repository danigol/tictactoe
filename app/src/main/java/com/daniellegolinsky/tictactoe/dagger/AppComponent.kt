package com.daniellegolinsky.tictactoe.dagger

import com.daniellegolinsky.tictactoe.TicTacToeApplication
import com.daniellegolinsky.tictactoe.model.BoardData
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ AndroidSupportInjectionModule::class,
                    ActivityBuildersModule::class,
                    ModelModule::class]
)
interface AppComponent : AndroidInjector<TicTacToeApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TicTacToeApplication): Builder
        fun build() : AppComponent
    }
}