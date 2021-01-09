package patient.cloud.patientservice.controller

import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.*
import patient.cloud.patientservice.bindings.DeletePatientBindings
import patient.cloud.patientservice.bindings.NewPatientBindings
import patient.cloud.patientservice.entity.Patient
import patient.cloud.patientservice.service.PatientService

@RestController
class PatientController(
    private val patientService: PatientService,
    /*private val source: Source*/
    private val newPatientBindings: NewPatientBindings,
    private val deletePatientBindings: DeletePatientBindings
) {
    @GetMapping(value = ["/patient/{id}"])
    fun getOnePatient(@PathVariable id: Long?): Patient? {
        return patientService.getPatient(id)
    }

    @GetMapping(value = ["/patient"])
    fun getAll(): List<Patient?>? {
        return patientService.getAllPatient()
    }

    @PostMapping(value = ["/patient/"])
    fun newPatient(@RequestBody patient: Patient): Patient{
        val createdPatient = patientService.createPatient(patient)
        newPatientBindings.newPatient().send(MessageBuilder.withPayload(createdPatient).build())
        return createdPatient
    }
}