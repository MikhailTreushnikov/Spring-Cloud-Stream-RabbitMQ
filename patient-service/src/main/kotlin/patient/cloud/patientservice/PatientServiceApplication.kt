package patient.cloud.patientservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import patient.cloud.patientservice.bindings.DeletePatientBindings
import patient.cloud.patientservice.bindings.NewPatientBindings

@SpringBootApplication
@EnableBinding(
    NewPatientBindings::class,
    DeletePatientBindings::class
)
class PatientServiceApplication

fun main(args: Array<String>) {
    runApplication<PatientServiceApplication>(*args)
}
