package vehicle.service.model

import jakarta.persistence.*

@Entity
@Table(name = "vehiculos")
data class Vehicle(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val brand: String,

    @Column(nullable = false)
    val model: String,

    @Column(nullable = false)
    val year: Int,

    @Column(nullable = false, unique = true)
    val plate: String,

    @Column(nullable = false)
    val km: String,

    @Column(nullable = false)
    val soapDate: String,

    @Column(nullable = false)
    val permisoCirculacionDate: String,

    @Column(nullable = false)
    val revisionTecnicaDate: String,

    // Asociado al usuario dueño del auto
    @Column(nullable = false)
    val userId: Long
)
