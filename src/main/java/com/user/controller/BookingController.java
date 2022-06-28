package com.user.controller;


import com.user.controller.dto.BookingDto;
import com.user.model.Booking;
import com.user.service.IBookingService;
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
    @PostMapping("")
    public Booking createBook(@RequestBody BookingDto objBookingDto){
        return objBookServices.createBook(new Booking(objBookingDto));
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Booking>> findAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(objBookServices.findAllBooks());
    }

    @GetMapping("{idBook}")
    public Optional<Booking> findById(@PathVariable Long idBook){

        return objBookServices.findByIdBook(idBook);
    }

    @PutMapping("{objBook}")
    public Booking updateBook(@RequestBody Booking objBooking){
        return objBookServices.updateBook(objBooking);
    }

    @DeleteMapping("{idBook}")
    public void deleteBook(@PathVariable Long idBook){
        objBookServices.deleteBook(idBook);
    }
}

