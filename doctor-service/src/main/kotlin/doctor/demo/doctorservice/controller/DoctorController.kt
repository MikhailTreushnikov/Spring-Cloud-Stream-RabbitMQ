package doctor.demo.doctorservice.controller

import doctor.demo.doctorservice.entity.Doctor
import doctor.demo.doctorservice.service.DoctorService
import org.springframework.web.bind.annotation.*


@RestController
class DoctorController(
    private val doctorService: DoctorService
) {

    @GetMapping("/doctor/{doctorId}")
    fun getDoctor(@PathVariable doctorId: Long): Doctor {
        return doctorService.getDoctorById(doctorId)
    }

    @GetMapping("/doctor")
    fun getAll(): MutableList<Doctor> {
        return doctorService.getAllDoctors() as MutableList<Doctor>
    }

    @PostMapping("/doctor/")
    fun createDoctor(@RequestBody doctor: Doctor): Doctor {
        return doctorService.newDoctor(doctor)
    }
}