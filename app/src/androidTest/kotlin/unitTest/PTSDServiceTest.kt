package unitTest
import dk.myapp.mentalprojekt.business.services.PTSDService
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations


class PTSDServiceTest {

    @Mock
    private lateinit var PulseChanged: (Int) -> Unit

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }
    @Test
    fun Test_med_zero_som_input() {
        // Arrange
        val service = PTSDService(PulseChanged)

        // Act
        service.pulseDetected(0)

        //Assert
        verify(PulseChanged, never()).invoke(ArgumentMatchers.anyInt()) // Forventer ingen interaktion med PulseChanged
    }
    @Test
    fun Test_med_En_værdi_som_input() {
        // Arrange
        val service = PTSDService(PulseChanged)

        // Act
        service.pulseDetected(100)

        // Assert
        verify(PulseChanged).invoke(100) // Forventer én invocation af PulseChanged med pulsværdi 100
    }
    @Test
    fun Test_med_flere_værdier_som_input() {
        // Arrange
        val service = PTSDService(PulseChanged)

        // Act
        service.pulseDetected(97)
        service.pulseDetected(100)

        // Assert
        verify(PulseChanged).invoke(100) // Forventer én invocation af PulseChanged med pulsværdi 100
        verifyNoMoreInteractions(PulseChanged) // Forventer ingen yderligere interaktioner med PulseChanged
    }

    // En bestemt handling (repræsenteret ved pulseDetection-funktionen) udføres, når en høj puls-værdi detekteres
    @Test
    fun testPulseDetected_bliver_kaldt_ved_MaxVærdi_EP3() {
        // Arrange
        val service = PTSDService(PulseChanged)

        //Act
        service.pulseDetected(99)

        //Assert
        verify(PulseChanged).invoke(99)
    }

    // En bestemt handling (repræsenteret ved pulseDetection-funktionen) ikke udføres, når en lav puls-værdi detekteres
    @Test
    fun testPulseDetected_ikke_bliver_kaldt_ved_grænseVærdi_EP2() {
        // Arrange
        val service = PTSDService(PulseChanged)

        //Act
        service.pulseDetected(98)

        //Assert
        verify(PulseChanged, never()).invoke(ArgumentMatchers.anyInt())
    }

    // En bestemt handling (repræsenteret ved pulseDetection-funktionen) ikke udføres, når en lav puls-værdi detekteres
    @Test
    fun testPulseDetected_ikke_bliver_kaldt_ved_minVærdi_EP1() {
        // Arrange
        val service = PTSDService(PulseChanged)

        //Act
        service.pulseDetected(97)

        //Assert
        verify(PulseChanged, never()).invoke(ArgumentMatchers.anyInt())
    }
}