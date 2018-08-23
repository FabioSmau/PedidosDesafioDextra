package com.desafio.dextra.commom.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.desafio.dextra.R;

public class DialogController implements AlertView {

    private Context context;

    public DialogController(Context context) {
        this.context = context;
    }

    @Override
    public void showDialog(AlertDescriptor alert) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(alert.getTitle())
                .setMessage(alert.getMessage())
                .setPositiveButton(alert.getPositiveTitleButton(), alert.getPositiveClick())
                .setNegativeButton(alert.getNegativeTitleButton(), alert.getNegativeClick());

        builder.show();
    }

    @Override
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_ok, null);

        builder.show();
    }

    @Override
    public void showDialog(String message, DialogInterface.OnClickListener positiveClick) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_ok, positiveClick);
        builder.show();
    }
}
