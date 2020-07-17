package com.daniellegolinsky.tictactoe.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProviders
import com.daniellegolinsky.tictactoe.dagger.ViewModelProviderFactory
import com.daniellegolinsky.tictactoe.viewModel.BoardViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class GameActivity @Inject constructor() : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    lateinit var viewModel: BoardViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(BoardViewModel::class.java)
    }
}