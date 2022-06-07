package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ILibraryService {

    public void removeLibrary(int idLibrary) throws Exception;
    public Library addLibrary(Library library) throws Exception;
    public List<Library> searchLibrary(String name, String address) throws Exception;

}
