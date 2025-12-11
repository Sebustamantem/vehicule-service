package vehicle_service.controller

import org.springframework.web.bind.annotation.*
import vehicle_service.dto.VehicleRequest
import vehicle_service.service.VehicleService

@RestController
@RequestMapping("/vehicles")
class VehicleController(
    private val service: VehicleService
) {

    @PostMapping
    fun create(@RequestBody request: VehicleRequest) =
        service.create(request)

    @GetMapping("/user/{userId}")
    fun listByUser(@PathVariable userId: Long) =
        service.listByUser(userId)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: VehicleRequest
    ) = service.update(id, request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}
