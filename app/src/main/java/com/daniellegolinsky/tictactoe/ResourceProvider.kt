package com.daniellegolinsky.tictactoe

import android.content.Context

class ResourceProvider(var context: Context) {

    fun getString(id: Int): String {
        return context.getString(id)
    }

    fun getString(id: Int, replacementText: String): String {
        return context.getString(id, replacementText)
    }
}