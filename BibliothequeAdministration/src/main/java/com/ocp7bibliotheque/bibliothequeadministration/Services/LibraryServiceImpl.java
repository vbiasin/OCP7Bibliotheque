package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.LibraryRepository;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void removeLibrary(int idLibrary) throws Exception {
        Optional<Library> library = libraryRepository.findById(idLibrary);
        if(library.isEmpty()) throw new Exception("Cette Bibliotheque n'existe pas !");
        libraryRepository.delete(library.get());
    }

    @Override
    public Library addLibrary(Library library) throws Exception {
        Optional<Library> newLibrary = libraryRepository.findByNameAndAddress(library.getName(),library.getAddress());
        if(!newLibrary.isEmpty()) throw new Exception("Cette Bibliotheque existe déjà !");
        return libraryRepository.save(library);
    }

}
