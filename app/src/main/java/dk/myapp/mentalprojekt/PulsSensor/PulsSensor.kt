package dk.myapp.mentalprojekt.PulsSensor
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dk.myapp.mentalprojekt.business.services.PulseListener

class PulsSensor(private val context: Context, private val manager: SensorManager,private val pulseListener:PulseListener) {

    private lateinit var pulseSensor: Sensor
    val pulseValueState = mutableStateOf(0f)

    fun setupListener() {
        val permission = Manifest.permission.BODY_SENSORS
        val granted = PackageManager.PERMISSION_GRANTED
        if (ContextCompat.checkSelfPermission(context, permission) != granted) {
            ActivityCompat.requestPermissions(context as Activity, arrayOf(permission), 1)
        }
        pulseSensor = manager.getDefaultSensor(Sensor.TYPE_HEART_RATE)

        manager.registerListener(
            object : SensorEventListener {
                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

                override fun onSensorChanged(event: SensorEvent?) {
                    event?.let {
                        if (it.sensor.type == Sensor.TYPE_HEART_RATE) {
                            val pulse = it.values[0]
                            pulseValueState.value = pulse

                            pulseListener.pulseDetected(it.values[0].toInt())
                            Log.d("Puls:", "Værdien af puls er: ${pulseValueState.value}")

                        }
                    }
                }
            },
            pulseSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }
}
