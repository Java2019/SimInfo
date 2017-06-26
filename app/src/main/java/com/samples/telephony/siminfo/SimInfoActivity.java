package com.samples.telephony.siminfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class SimInfoActivity extends AppCompatActivity {

    private TextView text;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_sim_info);

        this.text = (TextView)findViewById(R.id.text);
        final TelephonyManager manager = (TelephonyManager)getSystemService(
                Context.TELEPHONY_SERVICE);
        String simCountryIso = manager.getSimCountryIso();
        String simOperator = manager.getSimOperator();
        String simOperatorName = manager.getSimOperatorName();
        String simSerialNumber = manager.getSimSerialNumber();
        String simSubscriberId = manager.getSubscriberId();
        int simState = manager.getSimState();
        String sSimStateString = "Not Defined";
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                sSimStateString = "ABSENT";
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                sSimStateString = "NETWORK_LOCKED";
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                sSimStateString = "PIN_REQUIRED";
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                sSimStateString = "PUK_REQUIRED";
                break;
            case TelephonyManager.SIM_STATE_READY:
                sSimStateString = "STATE_READY";
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                sSimStateString = "STATE_UNKNOWN";
                break;
        }
        text.setText(
                "\nSim CountryIso: " + simCountryIso +
                "\nSim Operator: " + simOperator +
                "\nSim OperatorName: " + simOperatorName +
                "\nSim SerialNumber: " + simSerialNumber +
                "\nSim SubscriberId: " + simSubscriberId +
                "\nSim StateString: " + sSimStateString);
    }
}
