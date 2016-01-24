package comdirisionuofthacks.httpsgithub.opus;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

import com.mbientlab.metawear.MetaWearBleService;
import com.mbientlab.metawear.MetaWearBoard;
import com.mbientlab.metawear.module.Accelerometer;

public class WorkActivity extends AppCompatActivity implements ServiceConnection {

    private MetaWearBleService.LocalBinder serviceBinder;

    private final String MW_MAC_ADDRESS= "EC:2C:09:81:22:AC";
    private MetaWearBoard mwBoard;

    public void retrieveBoard() {
        final BluetoothManager btManager=
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        final BluetoothDevice remoteDevice=
                btManager.getAdapter().getRemoteDevice(MW_MAC_ADDRESS);

        // Create a MetaWear board object for the Bluetooth Device
        mwBoard= serviceBinder.getMetaWearBoard(remoteDevice);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        // Bind the service when the activity is created
        getApplicationContext().bindService(new Intent(this, MetaWearBleService.class),this, Context.BIND_AUTO_CREATE);

        try {

            Accelerometer accelModule = mwBoard.getModule(Accelerometer.class);

            // Set the sampling frequency to 50Hz, or closest valid ODR
            accelModule.setOutputDataRate(50.f);
            // Set the measurement range to +/- 4g, or closet valid range
            accelModule.setAxisSamplingRange(4.0f);

            // enable axis sampling
            accelModule.enableAxisSampling();

            // Switch the accelerometer to active mode
            accelModule.start();
        } catch (Exception e){  }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Unbind the service when the activity is destroyed
        getApplicationContext().unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        // Typecast the binder to the service's LocalBinder class
        serviceBinder = (MetaWearBleService.LocalBinder) service;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) { }
}

