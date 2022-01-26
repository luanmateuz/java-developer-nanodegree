package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cars")
@Tag(name = "Car", description = "Endpoints for managing Car/Vehicles")
class CarController {

    private final CarService carService;
    private final CarResourceAssembler assembler;

    public CarController(CarService carService, CarResourceAssembler assembler) {
        this.carService = carService;
        this.assembler = assembler;
    }

    /**
     * Creates a list to store any vehicles.
     *
     * @return list of vehicles
     */
    @GetMapping
    @Operation(
            summary = "list all cars",
            method = "list",
            description = "List all cars in database",
            tags = {"Car"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Car.class)))
            })
    CollectionModel<EntityModel<Car>> list() {
        List<EntityModel<Car>> resources = carService.list()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(resources);
    }

    /**
     * Gets information of a specific car by ID.
     *
     * @param id the id number of the given vehicle
     * @return all information for the requested vehicle
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "find car by id",
            method = "get",
            description = "Find car by id in database",
            tags = {"Car"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Car.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
            }
    )
    public EntityModel<Car> get(
            @Parameter(
                    description = "The id of the car to be find.",
                    example = "1")
            @PathVariable Long id) {
        Car car = this.carService.findById(id);
        return assembler.toModel(car);
    }

    /**
     * Posts information to create a new vehicle in the system.
     *
     * @param car A new vehicle to add to the system.
     * @return response that the new vehicle was added to the system
     */
    @PostMapping
    @Operation(
            summary = "save car",
            method = "post",
            description = "Save car in database",
            tags = {"Car"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Car.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Already exists", content = @Content)
            }
    )
    public ResponseEntity<Car> post(
            @Parameter(
                    description = "Car to be add.",
                    required = true,
                    schema = @Schema(implementation = Car.class))
            @Valid @RequestBody Car car) {
        Car save = this.carService.save(car);
        EntityModel<Car> resource = assembler.toModel(save);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(Objects.requireNonNull(resource.getContent()).getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }

    /**
     * Updates the information of a vehicle in the system.
     *
     * @param id  The ID number for which to update vehicle information.
     * @param car The updated information about the related vehicle.
     * @return response that the vehicle was updated in the system
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "update car",
            method = "put",
            description = "Update car in database",
            tags = {"Car"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
            }
    )
    public ResponseEntity<Void> put(
            @Parameter(
                    description = "Car to update. Id, and Car cannot be Blank, Empty or Null",
                    required = true,
                    schema = @Schema(implementation = Car.class))
            @PathVariable Long id, @Valid @RequestBody Car car) {
        car.setId(id);
        assembler.toModel(this.carService.save(car));

        return ResponseEntity
                .noContent()
                .build();
    }

    /**
     * Removes a vehicle from the system.
     *
     * @param id The ID number of the vehicle to remove.
     * @return response that the related vehicle is no longer in the system
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "delete car",
            method = "delete",
            description = "Remove car in database",
            tags = {"Car"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
            }
    )
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "Id for delete car, cannot be Blank, Empty or Null",
                    example = "1",
                    required = true,
                    schema = @Schema(description = "Id from car", example = "1"))
            @PathVariable Long id) {
        this.carService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
