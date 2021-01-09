package doctor.demo.doctorservice.service

import doctor.demo.doctorservice.entity.Doctor
import doctor.demo.doctorservice.entity.Specialization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Repository
interface DoctorRepository: JpaRepository<Doctor,Long>{
    fun findBySpecialization(specialization: Specialization): Doctor
}

@Service
@Transactional
class DoctorService(
    private val doctorRepository: DoctorRepository
    ) {

    fun getDoctorById(id: Long): Doctor{
        return doctorRepository.findById(id).orElseGet(null)
    }

    fun getAllDoctors(): List<Doctor>{
        return doctorRepository.findAll()
    }

    fun newDoctor(doctor: Doctor): Doctor{
        return doctorRepository.save(doctor)
    }

    fun getDoctorBySpec(disease: String):Doctor {
        var spec: Specialization? = null
        Specialization.values().forEach {specialization ->
            if(specialization.name.equals(disease))
                spec= specialization
        }
        if (spec == null)
            spec = Specialization.PEDIATRICIAN
        return doctorRepository.findBySpecialization(spec!!)
    }
}