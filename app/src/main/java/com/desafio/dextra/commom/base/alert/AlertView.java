package com.desafio.dextra.commom.base.alert;


import android.content.DialogInterface;

public interface AlertView {

    void showDialog(String message);
    void showDialog(String message, DialogInterface.OnClickListener positiveClick);

}
