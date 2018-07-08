package com.tdc.react.reactintegrationapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class KeyEventActivity extends AppCompatActivity {

    private List<KeyEventListener> listenerList = new ArrayList<>();

    public void onAttach(KeyEventListener listener) {
        listenerList.add(listener);
    }

    public void onDetach(KeyEventListener listener) {
        listenerList.remove(listener);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        for (KeyEventListener listener:
             listenerList) {
            if ((listener != null) &&
                    (listener.isVisible()) &&
                    (listener.onKey(listener.getView(), event.getKeyCode(), event))) {
                return true;
            }

        }
        return super.onKeyUp(keyCode, event);
    }
}
