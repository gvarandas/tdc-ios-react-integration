package com.tdc.react.reactintegrationapp;

import android.view.View;

public interface KeyEventListener extends View.OnKeyListener {
    boolean isVisible();
    View getView();
}
