package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.BookRepository;
import com.ocp7bibliotheque.bibliothequeadministration.DAO.LibraryRepository;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Book;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void removeLibrary(int idLibrary) throws Exception {
        Optional<Library> library = libraryRepository.findById(idLibrary);
        if(library.isEmpty()) throw new Exception("Cette Bibliotheque n'existe pas !");
        List<Book> listBooks = bookRepository.findByLibrary(library.get());
        for (Book book:listBooks
        ) {
            bookRepository.delete(book);
        }
        libraryRepository.delete(library.get());
    }

    @Override
    public Library addLibrary(Library library) throws Exception {
        Optional<Library> newLibrary = libraryRepository.findByNameAndAddress(library.getName(),library.getAddress());
        if(!newLibrary.isEmpty()) throw new Exception("Cette Bibliotheque existe déjà !");
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> searchLibrary(String name, String address) throws Exception {
        List<Library> libraries = libraryRepository.findByNameContainsOrAddressContains(name,address);
        List<Library> noDoublonLibraries = new ArrayList<>();
        if(!libraries.isEmpty()){
            for( Library library:  libraries ){
                if(noDoublonLibraries.isEmpty()) noDoublonLibraries.add(library);
                boolean doublon = true;
                for (Library noDoublonLibrary:noDoublonLibraries) {
                    if (!library.getName().equals(noDoublonLibrary.getName()) || !library.getAddress().equals(noDoublonLibrary.getAddress())){
                        doublon=false;
                    }
                }
                if (!doublon) noDoublonLibraries.add(library);
            }
        }
        else noDoublonLibraries = libraryRepository.findAll();


        return noDoublonLibraries;

    }

}
