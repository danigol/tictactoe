package com.daniellegolinsky.tictactoe.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ AndroidSupportInjectionModule::class,
                    ActivityBuildersModule::class ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DaggerApplication): Builder
        fun build() : AppComponent
    }
}