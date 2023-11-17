package unitTest
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import dk.myapp.mentalprojekt.PulsSensor.PulsSensor
import dk.myapp.mentalprojekt.business.services.PTSDService
import dk.myapp.mentalprojekt.business.services.PulseListener
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class PulsSensorTest {
    @Mock
    private lateinit var sensorManager: SensorManager

    @Mock
    private lateinit var pulseListener: PulseListener

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var mockSensor: Sensor

    @Mock
    private lateinit var sensorEvent: SensorEvent

    private lateinit var pulsSensor: PulsSensor

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        pulsSensor = PulsSensor(mockContext, sensorManager, pulseListener)
    }

    @Test
    fun testSetupListenerAndSensorChange() {
        // Setup
        Mockito.`when`(sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)).thenReturn(mockSensor)

        // Aktiver listener
        pulsSensor.setupListener()

        // Simuler en sensorændring
        val fakePulseValue = 70f
        Mockito.`when`(sensorEvent.values).thenReturn(floatArrayOf(fakePulseValue))
        Mockito.`when`(sensorEvent.sensor).thenReturn(mockSensor)

        // Udløs onSensorChanged manuelt
        val sensorEventListenerCaptor = ArgumentCaptor.forClass(SensorEventListener::class.java)
        Mockito.verify(sensorManager).registerListener(sensorEventListenerCaptor.capture(), Mockito.eq(mockSensor), Mockito.anyInt())

        val sensorEventListener = sensorEventListenerCaptor.value
        sensorEventListener.onSensorChanged(sensorEvent)

        // Bekræft
        Mockito.verify(pulseListener).pulseDetected(fakePulseValue.toInt())
    }
}