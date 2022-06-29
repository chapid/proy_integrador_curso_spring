package com.user.service;

import com.user.model.Booking;
import com.user.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ImplBookingService implements IBookingService {

    private final IBookingRepository objBookRepository;

    public ImplBookingService(@Autowired IBookingRepository objBookRepository) {
        this.objBookRepository = objBookRepository;
    }

    @Override
    public Booking createBook(Booking objBooking) {
        return objBookRepository.save(objBooking);
    }

    @Override
    public Optional<Booking> findByIdBook (Long idBook) {
        return objBookRepository.findById(idBook);
    }

    @Override
    public List<Booking> findAllBooks() {
        return (List<Booking>) objBookRepository.findAll();
    }

    @Override
    public Booking updateBook(Booking objBooking) {
        //if (objBook.getIdBook() != 0 && objBookRepository.existsById(objBook.getIdBook())){
            return objBookRepository.save(objBooking);
        //}
       // return null;
    }

    @Override
    public void deleteBook (Long idBook) {
        objBookRepository.deleteById(idBook);
    }
}
