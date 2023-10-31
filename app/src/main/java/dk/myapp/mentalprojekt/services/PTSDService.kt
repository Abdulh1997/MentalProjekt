package dk.myapp.mentalprojekt.services

import dk.myapp.mentalprojekt.PulsSensor.PulsSensor


class PTSDService(private val pulseDetection:(Int)->Unit):PulseListener {

    override fun pulseDetected(pulse: Int) {
        if (pulse > 88) { // Tjek om pulsværdien overstiger 500
            pulseDetection(pulse) // Trig navigation
        }
    }
}