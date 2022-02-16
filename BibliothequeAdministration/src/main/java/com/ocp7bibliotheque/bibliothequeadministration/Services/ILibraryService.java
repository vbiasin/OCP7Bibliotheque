package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;

public interface ILibraryService {

    public void removeLibrary(int idLibrary) throws Exception;
    public Library addLibrary(Library library) throws Exception;

}
