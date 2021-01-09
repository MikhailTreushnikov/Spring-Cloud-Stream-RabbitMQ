package patient.cloud.patientservice.service

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestBody
import patient.cloud.patientservice.entity.Patient

@Repository
interface PatientRepository: JpaRepository<Patient,Long>{}

@Service
class PatientService(
    private val patientRepository: PatientRepository
){

    @Transactional
    fun getPatient(id: Long?): Patient? {
        return patientRepository.findById(id!!).orElse(null)
    }

    @Transactional
    fun getAllPatient(): List<Patient?>? {
        return patientRepository.findAll()
    }

    @Transactional
    fun createPatient(patient: Patient): Patient{
        var newPatient = patientRepository.save(patient)
        return newPatient
    }
}
