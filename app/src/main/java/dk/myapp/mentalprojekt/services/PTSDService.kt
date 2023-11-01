package dk.myapp.mentalprojekt.services

class PTSDService(private val pulseDetection:(Int)->Unit):PulseListener {
    override fun pulseDetected(pulse: Int) {
        if (pulse > 98) { // Tjek om pulsværdien overstiger 98
            pulseDetection(pulse) // Trig navigation
        }
    }
}