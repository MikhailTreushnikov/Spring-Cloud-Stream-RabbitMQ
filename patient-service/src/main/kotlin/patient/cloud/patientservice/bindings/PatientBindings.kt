package patient.cloud.patientservice.bindings

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

const val NEW_PATIENT = "new_patient"
const val DELETE_PATIENT = "delete_patient"

interface NewPatientBindings {
    @Output(NEW_PATIENT)
    fun newPatient(): MessageChannel
}
interface DeletePatientBindings{
    @Output(DELETE_PATIENT)
    fun deletePatient(): MessageChannel
}