package doctor.demo.doctorservice.bindings

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

const val NEW_PATIENT = "new_patient"
const val DELETE_PATIENT = "delete_patient"

interface NewPatientBindings {
    @Input(NEW_PATIENT)
    fun newPatient(): SubscribableChannel
}
interface DeletePatientBindings {
    @Input(DELETE_PATIENT)
    fun deletePatient(): SubscribableChannel
}