package com.desafio.dextra.commom.alert;

import android.content.DialogInterface;

public interface AlertBuilder {

    AlertBuilder title(String title);

    AlertBuilder message(String message);

    AlertBuilder positiveTitleButton(String positiveButton);

    AlertBuilder negativeTitleButton(String negativeTitleButton);

    AlertBuilder positiveClick(DialogInterface.OnClickListener positiveClick);

    AlertBuilder negativeClick(DialogInterface.OnClickListener negativeClick);

    AlertDescriptor build();
}
