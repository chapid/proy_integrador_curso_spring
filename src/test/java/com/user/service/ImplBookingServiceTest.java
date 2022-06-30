package com.user.service;

import com.user.model.Booking;
import com.user.repository.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

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
        //Arrange
        IBookingRepository objIBookingRepository = Mockito.mock(IBookingRepository.class);
        objImplBookingService = new ImplBookingService(objIBookingRepository);

        Booking objBooking = new Booking("Don Quijote de la Mancha","Novela","Miguel de cervantes",100);

        //Act
        objImplBookingService.updateBook(objBooking);

        //Assert
        verify(objIBookingRepository).save(objBooking);
    }

    @Test
    void deleteBook() {

        //Arrange
        IBookingRepository objIBookingRepository = Mockito.mock(IBookingRepository.class);
        objImplBookingService = new ImplBookingService(objIBookingRepository);

        //Act
        objImplBookingService.deleteBook(1000L);

        //Assert
        verify(objIBookingRepository).deleteById(1000L);
    }
}