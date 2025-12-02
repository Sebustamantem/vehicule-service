package vehicle.service.controller

import org.springframework.web.bind.annotation.*
import vehicle.service.dto.VehicleRequest
import vehicle.service.service.VehicleService

@RestController
@RequestMapping("/vehicles")
class VehicleController(
    private val service: VehicleService
) {

    @PostMapping
    fun create(@RequestBody request: VehicleRequest) =
        service.create(request)

    @GetMapping("/{userId}")
    fun list(@PathVariable userId: Long) =
        service.listByUser(userId)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}
