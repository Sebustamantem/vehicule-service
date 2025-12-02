package vehicle_service.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import vehicle_service.dto.VehicleRequest
import vehicle_service.dto.VehicleResponse
import vehicle_service.model.Vehicle
import vehicle_service.repository.VehicleRepository

@Service
class VehicleService(
    private val repo: VehicleRepository
) {

    fun create(request: VehicleRequest): VehicleResponse {

        if (repo.existsByPlate(request.plate)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "La patente ya existe")
        }

        val vehicle = Vehicle(
            brand = request.brand,
            model = request.model,
            year = request.year,
            plate = request.plate,
            km = request.km,
            soapDate = request.soapDate,
            permisoCirculacionDate = request.permisoCirculacionDate,
            revisionTecnicaDate = request.revisionTecnicaDate,
            userId = request.userId
        )

        val saved = repo.save(vehicle)
        return saved.toResponse()
    }

    fun listByUser(userId: Long): List<VehicleResponse> =
        repo.findByUserId(userId).map { it.toResponse() }

    fun delete(id: Long) {
        if (!repo.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado")
        }
        repo.deleteById(id)
    }

    private fun Vehicle.toResponse() = VehicleResponse(
        id, brand, model, year, plate, km,
        soapDate, permisoCirculacionDate, revisionTecnicaDate, userId
    )
}
