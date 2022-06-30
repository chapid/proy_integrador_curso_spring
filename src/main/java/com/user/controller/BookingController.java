package com.user.controller;


import com.user.controller.dto.BookingDto;
import com.user.model.Booking;
import com.user.service.IBookingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/v2/booking/")
public class BookingController {

    private final IBookingService objBookServices;

    public BookingController(IBookingService iBookingService) {
        this.objBookServices = iBookingService;
    }
    //prueba rama juanes

    @ApiOperation(value="Crear Libros",authorizations = {@Authorization(value = "JWT")})
    @PostMapping("")
    public Booking createBook(@RequestBody BookingDto objBookingDto){
        return objBookServices.createBook(new Booking(objBookingDto));
    }

    @ApiOperation(value="Consultar todos los Libros",authorizations = {@Authorization(value = "JWT")})
    @GetMapping("")
    public ResponseEntity<Iterable<Booking>> findAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(objBookServices.findAllBooks());
    }

    @ApiOperation(value="Consultar libro por id",authorizations = {@Authorization(value = "JWT")})
    @GetMapping("{idBook}")
    public Optional<Booking> findById(@PathVariable Long idBook){

        return objBookServices.findByIdBook(idBook);
    }

    @ApiOperation(value="Actualizar Libro",authorizations = {@Authorization(value = "JWT")})
    @PutMapping("{objBook}")
    public Booking updateBook(@RequestBody Booking objBooking){
        return objBookServices.updateBook(objBooking);
    }

    @ApiOperation(value="Eliminar Libro",authorizations = {@Authorization(value = "JWT")})
    @DeleteMapping("{idBook}")
    public void deleteBook(@PathVariable Long idBook){
        objBookServices.deleteBook(idBook);
    }
}

