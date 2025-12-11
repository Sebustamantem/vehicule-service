package vehicle_service.repository

import org.springframework.data.jpa.repository.JpaRepository
import vehicle_service.model.Vehicle

interface VehicleRepository : JpaRepository<Vehicle, Long> {

    fun existsByPlate(plate: String): Boolean


    fun existsByPlateAndIdNot(plate: String, id: Long): Boolean

    fun findByUserId(userId: Long): List<Vehicle>
}
