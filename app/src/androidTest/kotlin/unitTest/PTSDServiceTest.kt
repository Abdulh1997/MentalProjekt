package unitTest
import dk.myapp.mentalprojekt.business.services.PTSDService
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class PTSDServiceTest {

    @Mock
    private lateinit var pulseDetection: (Int) -> Unit

    private lateinit var ptsdService: PTSDService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        ptsdService = PTSDService(pulseDetection)
    }

    // En bestemt handling (repræsenteret ved pulseDetection-funktionen) udføres, når en høj puls-værdi detekteres
    @Test
    fun testPulseDetected_AboveThreshold() {
        val highPulse = 100

        ptsdService.pulseDetected(highPulse)

        verify(pulseDetection).invoke(highPulse)
    }


    // En bestemt handling (repræsenteret ved pulseDetection-funktionen) ikke udføres, når en lav puls-værdi detekteres
    @Test
    fun testPulseDetected_BelowThreshold() {
        val lowPulse = 90

        ptsdService.pulseDetected(lowPulse)

        verify(pulseDetection, never()).invoke(ArgumentMatchers.anyInt())
    }

}