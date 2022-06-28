package com.user.service;

import com.user.model.Booking;
import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking createBook (Booking objBooking);
    Optional<Booking> findByIdBook (Long idBook);
    List<Booking> findAllBooks ();
    Booking updateBook (Booking objBooking);
    void deleteBook (Long objBook);
}
