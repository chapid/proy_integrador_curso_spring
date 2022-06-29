package com.user.service;

import com.user.model.Booking;
import com.user.repository.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;

class ImplBookingServiceTest {

    ImplBookingService objImplBookingService;

    @Test
    void get_information_create_book() {

        //Arrange
        IBookingRepository objIBookingRepository = Mockito.mock(IBookingRepository.class);
        objImplBookingService = new ImplBookingService(objIBookingRepository);
        Booking objBooking = new Booking("Don Quijote de la Mancha","Novela","Miguel de cervantes",100);

        //Act
        objImplBookingService.createBook(objBooking);

        //Assert
        verify(objIBookingRepository).save(objBooking);
    }

    @Test
    void get_book_when_call_find_by_idBook() {
        //Arrange
        IBookingRepository objIBookingRepository = Mockito.mock(IBookingRepository.class);
        objImplBookingService = new ImplBookingService(objIBookingRepository);

        //Act
        objImplBookingService.findByIdBook(2L);

        //Assert
        verify(objIBookingRepository).findById(2L);
    }

    @Test
    void no_get_book_when_call_find_by_idBook() {

    }

    @Test
    void get_books_when_call_find_all_books() {
        //Arrange
        IBookingRepository objIBookingRepository = Mockito.mock(IBookingRepository.class);
        objImplBookingService = new ImplBookingService(objIBookingRepository);

        //Act
        objImplBookingService.findAllBooks();

        //Assert
        verify(objIBookingRepository).findAll();
    }

    @Test
    void updateBook() {

    }

    @Test
    void deleteBook() {
    }
}