package dk.myapp.mentalprojekt.services

interface PulseListener {

    fun pulseDetected(pulse: Int): Unit

}