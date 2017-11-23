package com.smartkitchen.smartkitchen.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.smartkitchen.smartkitchen.R;

/**
 * Created by israel-martinez on 09-11-17.
 */

public class MessageDialog{

    public static void show(Context context){
        new AlertDialog.Builder(context)
                .setTitle(R.string.title_dialog)
                .setMessage(R.string.message_dialog)
                .setCancelable(false)
                .setPositiveButton(R.string.accept_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Whatever...
                    }
                }).show();
    }
}