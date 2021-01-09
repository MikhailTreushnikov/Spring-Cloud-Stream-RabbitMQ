package doctor.demo.doctorservice.listener

import doctor.demo.doctorservice.bindings.NEW_PATIENT
import doctor.demo.doctorservice.entity.Doctor
import doctor.demo.doctorservice.entity.Patient
import doctor.demo.doctorservice.entity.Specialization
import doctor.demo.doctorservice.service.DoctorService
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component

@Component
class CreatePatientHandler (private val doctorService: DoctorService){

    @StreamListener(NEW_PATIENT)
    fun newPatientHandler(patient: Patient){
        val doc = Doctor()
        doc.fullName = "newDoctor${patient.id}"
        var spec: Specialization? = null
        Specialization.values().forEach { specialization ->
            if(specialization.name.equals(patient.diagnosis))
                spec= specialization
        }
        if (spec == null)
            spec = Specialization.PEDIATRICIAN
        doc.specialization =spec
        doc.fullNamePatient = patient.name
        doctorService.newDoctor(doc)
    }
}