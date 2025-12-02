package vehicle.service.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vehicle.service.model.Vehicle

@Repository
interface VehicleRepository : JpaRepository<Vehicle, Long> {

    fun findByUserId(userId: Long): List<Vehicle>

    fun existsByPlate(plate: String): Boolean
}
