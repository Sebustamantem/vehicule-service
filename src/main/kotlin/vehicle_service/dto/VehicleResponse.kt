package vehicle_service.dto

data class VehicleResponse(
    val id: Long?,
    val brand: String,
    val model: String,
    val year: Int,
    val plate: String,
    val km: String,
    val soapDate: String,
    val permisoCirculacionDate: String,
    val revisionTecnicaDate: String,
    val userId: Long
)
