package dk.myapp.mentalprojekt.Services

import dk.myapp.mentalprojekt.PulsSensor.PulsSensor


class PTSDService(val pulsSensor: PulsSensor, val pulseDetection:(Int)->Unit) {

    fun actOnPulsDetektion(puls: Int) {
        if (puls > 100) { // Tjek om pulsværdien overstiger 500
            pulseDetection(puls) // Trig navigation
        }
    }
}