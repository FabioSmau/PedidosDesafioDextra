package com.desafio.dextra.commom.alert;


import android.content.DialogInterface;

public class AlertDescription implements AlertDescriptor {

    private String title;
    private String message;
    private String positiveTitleButton;
    private String negativeTitleButton;
    private DialogInterface.OnClickListener positiveClick;
    private DialogInterface.OnClickListener negativeClick;

    public AlertDescription(String title, String message, String positiveTitleButton, String negativeTitleButton, DialogInterface.OnClickListener positiveClick, DialogInterface.OnClickListener negativeClick) {
        this.title = title;
        this.message = message;
        this.positiveTitleButton = positiveTitleButton;
        this.negativeTitleButton = negativeTitleButton;
        this.positiveClick = positiveClick;
        this.negativeClick = negativeClick;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getPositiveTitleButton() {
        return positiveTitleButton;
    }

    @Override
    public String getNegativeTitleButton() {
        return negativeTitleButton;
    }

    @Override
    public DialogInterface.OnClickListener getPositiveClick() {
        return positiveClick;
    }

    @Override
    public DialogInterface.OnClickListener getNegativeClick() {
        return negativeClick;
    }
}
