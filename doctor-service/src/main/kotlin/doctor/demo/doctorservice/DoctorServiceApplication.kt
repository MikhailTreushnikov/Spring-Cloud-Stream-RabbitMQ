package doctor.demo.doctorservice

import doctor.demo.doctorservice.bindings.DeletePatientBindings
import doctor.demo.doctorservice.bindings.NewPatientBindings
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding


@EnableBinding(
    NewPatientBindings::class,
    DeletePatientBindings::class
)
@SpringBootApplication
class DoctorServiceApplication

fun main(args: Array<String>) {
    runApplication<DoctorServiceApplication>(*args)
}
