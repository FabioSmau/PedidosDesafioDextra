package com.desafio.dextra.ingredients;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.desafio.dextra.databinding.ViewIngredientsStepperBinding;


public class IngredientStepperView extends LinearLayout {

    private ViewIngredientsStepperBinding binding;
    private OnChangeListener onChangeListener = new OnChangeListenerNullObject();

    public IngredientStepperView(Context context) {
        super(context);

        loadViews(context);
        setupOnTextChangeListener();
        setupOnClickListeners();
    }

    public IngredientStepperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        loadViews(context);
        setupOnTextChangeListener();
        setupOnClickListeners();

    }

    private void loadViews(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = ViewIngredientsStepperBinding.inflate(inflater, this, true);
    }

    private void setupOnTextChangeListener() {
        binding.valueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int count = convertValueFromInput();
                onChangeListener.onValueChange(count, IngredientStepperView.this);
            }
        });
    }

    private void setupOnClickListeners() {
        binding.incrementButton.setOnClickListener(v -> updateFieldValue(convertValueFromInput() + 1));
        binding.decrementButton.setOnClickListener(v -> updateFieldValue(convertValueFromInput() - 1));
    }

    public void setOnChangeListener(OnChangeListener listener) {
        if (listener == null)
            return;

        this.onChangeListener = listener;
    }

    private int convertValueFromInput() {
        int value;
        try {
            value = Integer.valueOf(binding.valueInput.getText().toString());
        } catch (Exception ignored) {
            value = 0;
        }
        return value;
    }

    public void updateFieldValue(int value) {
        value = value >= 0 ? value : 0;
        binding.valueInput.setText(String.valueOf(value));
    }

    public interface OnChangeListener {
        void onValueChange(int updatedValue, IngredientStepperView stepper);
    }

    private class OnChangeListenerNullObject implements OnChangeListener {

        @Override
        public void onValueChange(int updatedValue, IngredientStepperView stepper) {

        }
    }
}
