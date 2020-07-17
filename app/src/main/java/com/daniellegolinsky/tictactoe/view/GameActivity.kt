package com.daniellegolinsky.tictactoe.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.daniellegolinsky.tictactoe.R
import com.daniellegolinsky.tictactoe.dagger.ViewModelProviderFactory
import com.daniellegolinsky.tictactoe.databinding.GameBoardLayoutBinding
import com.daniellegolinsky.tictactoe.viewModel.BoardViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class GameActivity @Inject constructor() : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var viewModel: BoardViewModel
    private lateinit var layoutBinding: GameBoardLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(BoardViewModel::class.java)

        layoutBinding = DataBindingUtil.setContentView(this, getLayoutId())
        layoutBinding.lifecycleOwner = this
        layoutBinding.viewModel = viewModel
        layoutBinding.executePendingBindings()
    }

    private fun getLayoutId(): Int {
        return R.layout.game_board_layout
    }
}