package com.daniellegolinsky.tictactoe.view

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(BoardViewModel::class.java)

        layoutBinding = DataBindingUtil.setContentView(this, getLayoutId())
        layoutBinding.lifecycleOwner = this
        layoutBinding.viewModel = viewModel
        layoutBinding.executePendingBindings()

        viewModel.alertMessage.observe(this, Observer{message -> displayMessage(message)})
    }

    private fun displayMessage(message: Int) {
        if (toast != null) {
            toast?.cancel()
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    private fun getLayoutId(): Int {
        return R.layout.game_board_layout
    }
}