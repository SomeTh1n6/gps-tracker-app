package com.etwas.gpstracker.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.etwas.gpstracker.R
import com.etwas.gpstracker.databinding.SaveDialogBinding
import com.etwas.gpstracker.db.TrackItem

object DialogManager {
    fun showLocEnableDialog(context: Context, listener: Listener){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle(R.string.location_disabled)
        dialog.setMessage(context.getString(R.string.location_dialog_message))
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"){
            _, _ -> listener.onClick()
        }

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"){
                _, _ -> dialog.dismiss()
        }
        dialog.show()
    }

    fun showSaveDialog(context: Context, item: TrackItem?, listener: Listener){
        val builder = AlertDialog.Builder(context)
        val binding = SaveDialogBinding.inflate(LayoutInflater.from(context), null, false)
        builder.setView(binding.root)
        val dialog = builder.create()
        binding.apply {

            val time = "${item?.time} s"
            val velocity = "${item?.speed} km/h"
            val distance = "${item?.distance} km"
            tvTime.text = time
            tvSpeed.text = velocity
            tvDistance.text = distance

            bSave.setOnClickListener {
               listener.onClick()
               dialog.dismiss()
            }
            bCancel.setOnClickListener {
               dialog.dismiss()
            }
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun showLocPermissionDialog(context: Context, listener: Listener){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle(R.string.location_permission)
        dialog.setMessage(context.getString(R.string.location_dialog_permission_message))
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"){
                _, _ -> listener.onClick()
        }

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"){
                _, _ -> dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener{
        fun onClick()
    }
}