package com.desafio.dextra.commom.alert;


import android.content.DialogInterface;

public interface AlertView {

    void showDialog(AlertDescriptor alertDescriptor);
    void showDialog(String message);
    void showDialog(String message, DialogInterface.OnClickListener positiveClick);

}
