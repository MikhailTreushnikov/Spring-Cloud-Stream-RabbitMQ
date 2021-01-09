package doctor.demo.doctorservice.entity

import javax.persistence.*

enum class Specialization(s: String) {
    DENTIST("caries"),
    SURGEON("fracture"),
    DERMATOLOGIST("rash"),
    CARDIOLOGIST("heart attack"),
    ONCOLOGIST("tumor"),
    PEDIATRICIAN("another")
}

@Entity
@Table(name = "doctor",schema = "doctor-service")
class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name="name")
    var fullName: String? = null
    @Column(name = "specialization")
    @Enumerated(EnumType.STRING)
    var specialization: Specialization? = null
    @Column(name = "patient")
    var fullNamePatient: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Doctor

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (specialization != other.specialization) return false
        if (fullNamePatient != other.fullNamePatient) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (specialization?.hashCode() ?: 0)
        result = 31 * result + (fullNamePatient?.hashCode() ?: 0)
        return result
    }

}