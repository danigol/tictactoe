package com.daniellegolinsky.tictactoe

import com.daniellegolinsky.tictactoe.dagger.AppComponent
import com.daniellegolinsky.tictactoe.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TicTacToeApplication : DaggerApplication() {

    companion object {
        lateinit var component: AppComponent
        lateinit var resourceProvider: ResourceProvider
    }

    override fun onCreate() {
        super.onCreate()
        resourceProvider = ResourceProvider(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder().application(this).build()
        return component
    }
}