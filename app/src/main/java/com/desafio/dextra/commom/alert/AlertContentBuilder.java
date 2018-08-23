package com.desafio.dextra.commom.alert;

import android.content.DialogInterface;

public class AlertContentBuilder implements AlertBuilder {

    private String title;
    private String message;
    private String positiveTitleButton = "OK";
    private String negativeTitleButton;
    private DialogInterface.OnClickListener positiveClick = (dialog, which) -> dialog.dismiss();
    private DialogInterface.OnClickListener negativeClick = (dialog, which) -> dialog.dismiss();

    @Override
    public AlertContentBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public AlertContentBuilder message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public AlertContentBuilder positiveTitleButton(String positiveTitleButton) {
        this.positiveTitleButton = positiveTitleButton;
        return this;
    }

    @Override
    public AlertContentBuilder negativeTitleButton(String negativeTitleButton) {
        this.negativeTitleButton = negativeTitleButton;
        return this;
    }

    @Override
    public AlertContentBuilder positiveClick(DialogInterface.OnClickListener positiveClick) {
        this.positiveClick = positiveClick;
        return this;
    }

    @Override
    public AlertContentBuilder negativeClick(DialogInterface.OnClickListener negativeClick) {
        this.negativeClick = negativeClick;
        return this;
    }

    @Override
    public AlertDescriptor build() {
        return new AlertDescription(
                title,
                message,
                positiveTitleButton,
                negativeTitleButton,
                positiveClick,
                negativeClick
        );
    }
}
