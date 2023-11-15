package dk.myapp.mentalprojekt.business.services

interface PulseListener {
    fun pulseDetected(pulse: Int): Unit
}