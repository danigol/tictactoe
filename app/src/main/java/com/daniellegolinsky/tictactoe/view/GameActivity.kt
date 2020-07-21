package com.daniellegolinsky.tictactoe.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daniellegolinsky.tictactoe.R
import com.daniellegolinsky.tictactoe.dagger.ViewModelProviderFactory
import com.daniellegolinsky.tictactoe.databinding.GameBoardLayoutBinding
import com.daniellegolinsky.tictactoe.model.AlertType
import com.daniellegolinsky.tictactoe.viewModel.BoardViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class GameActivity @Inject constructor() : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var viewModel: BoardViewModel
    private lateinit var layoutBinding: GameBoardLayoutBinding

    private var toast: Toast? = null
    private var dialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(BoardViewModel::class.java)

        layoutBinding = DataBindingUtil.setContentView(this, getLayoutId())
        layoutBinding.lifecycleOwner = this
        layoutBinding.viewModel = viewModel
        layoutBinding.executePendingBindings()

        viewModel.toastMessage.observe(this, Observer {
            message -> displayToastMessage(message)
        })
        viewModel.alertMessage.observe(this, Observer {
            messagePair -> displayDialogMessage(messagePair)
        } )
    }

    private fun displayToastMessage(message: String?) {
        message?.let {
            if (toast != null) {
                toast?.cancel()
            }
            toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast?.show()
        }
    }

    private fun displayDialogMessage(messagePair: Pair<String, AlertType>?) {
        if (dialog != null) {
            dialog?.dismiss()
            dialog = null
        }
        messagePair?.let {
            var message: String = it.first
            var type: AlertType = it.second

            var dialogBuilder: AlertDialog.Builder =
                    AlertDialog.Builder(this)
                               .setTitle(message)
                               .setIcon(R.drawable.ic_tictactoeicon)
            if (type == AlertType.NEW_GAME) {
                dialogBuilder.setPositiveButton(R.string.new_game) { _, _ -> viewModel.newGameClicked()}
            }
            dialogBuilder.setNegativeButton(R.string.dismiss, null)
            // Create and show dialog with new game button
            dialog = dialogBuilder.create()
            dialog?.show()
        }
    }

    private fun getLayoutId(): Int {
        return R.layout.game_board_layout
    }
}