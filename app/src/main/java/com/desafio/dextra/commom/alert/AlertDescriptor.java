package com.desafio.dextra.commom.alert;

import android.content.DialogInterface;

public interface AlertDescriptor {
    String getTitle();

    String getMessage();

    String getPositiveTitleButton();

    String getNegativeTitleButton();

    DialogInterface.OnClickListener getPositiveClick();

    DialogInterface.OnClickListener getNegativeClick();
}
