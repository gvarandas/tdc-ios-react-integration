package com.tdc.react.reactintegrationapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class ReactNativeFragment extends Fragment implements KeyEventListener {
    private ReactNativeView mView;
    private ReactInstanceManager mReactInstanceManager;


    @Override
    public void onAttach(Context context) {
        if (context instanceof KeyEventActivity) {
            ((KeyEventActivity)context).onAttach(this);
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        if (getActivity() instanceof KeyEventActivity) {
            ((KeyEventActivity)getActivity()).onDetach(this);
        }
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        bundle.putString(InstanceManager.ASSET_NAME, "tab.bundle");
        bundle.putString(InstanceManager.APP_NAME, "ReactApp");

        mView = new ReactNativeView(getActivity(), bundle);
        mReactInstanceManager = InstanceManager.createReactInstanceManager(getActivity(), bundle);
        mView.startReactApplication(mReactInstanceManager);

        return mView;
    }

    public boolean onActivityKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return this.onActivityKeyUp(keyCode, event);
    }

    @Override
    public void onResume() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(getActivity(), new DefaultHardwareBackBtnHandler() {
                @Override
                public void invokeDefaultOnBackPressed() {
                    getActivity().onBackPressed();
                }
            });
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(getActivity());
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (mView != null) {
            mView.unmountReactApplication();
            mView = null;
        }
        super.onDestroy();
    }

}
