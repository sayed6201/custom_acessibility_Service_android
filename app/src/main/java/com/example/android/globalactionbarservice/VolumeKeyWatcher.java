package com.example.android.globalactionbarservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class VolumeKeyWatcher {

    static final String TAG = "hg";
    private Context mContext;
    private IntentFilter mFilter;
    private OnVolumePressedListener mListener;
    private InnerReceiver mReceiver;

    public VolumeKeyWatcher(Context context) {
        mContext = context;
//        mFilter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
//        mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

        mFilter = new IntentFilter();
        mFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    }

    public void setOnVolumePressedListener(OnVolumePressedListener listener) {
        mListener = listener;
        mReceiver = new InnerReceiver();
    }

    public void startWatch() {
        if (mReceiver != null) {
            mContext.registerReceiver(mReceiver, mFilter);
        }
    }

    public void stopWatch() {
        if (mReceiver != null) {
            mContext.unregisterReceiver(mReceiver);
        }
    }

    class InnerReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//
//            mListener.onVolumePressed();
//
////            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
////                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
////                if (reason != null) {
////                    Log.e(TAG, "action:" + action + ",reason:" + reason);
////                    if (mListener != null) {
////                        if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
////                            mListener.onVolumePressed();
////                        } else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
////                            mListener.onVolumeLongPressed();
////                        }
////                    }
////                }
////            }
//        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "In onReceive");       // It won't even print this.
            Toast.makeText(context, "receiveed !!", Toast.LENGTH_SHORT).show();
            String intentAction = intent.getAction();
            if (Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
//                KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
//
//                if (event == null) {
//                    return;
//                }
//                int keycode = event.getKeyCode();
//                int action = event.getAction();
//
//                if (keycode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE || keycode == KeyEvent.KEYCODE_HEADSETHOOK) {
//                    if (action == KeyEvent.ACTION_DOWN) {
//                        Log.e(TAG, "Button Pressed");    //Call function here.
                        Toast.makeText(context, "Button pressed !!", Toast.LENGTH_SHORT).show();
//                        mListener.onVolumePressed();
//                        if (isOrderedBroadcast()) {
//                            abortBroadcast();
//                        }
//                    }
//                }
            }
        }
    }
}




