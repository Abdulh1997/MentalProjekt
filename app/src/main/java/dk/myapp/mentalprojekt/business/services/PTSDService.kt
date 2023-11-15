package dk.myapp.mentalprojekt.business.services
class PTSDService(private val PulseChanged:(Int)->Unit):PulseListener {
    override fun pulseDetected(pulse: Int) {
        if (pulse > 98) { // Tjek om pulsværdien overstiger 98
            PulseChanged(pulse) // Trig navigation
        }
    }
}