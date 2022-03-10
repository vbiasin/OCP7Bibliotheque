package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import com.ocp7bibliotheque.bibliothequeweb.DTO.RoleDTO;
import com.ocp7bibliotheque.bibliothequeweb.DTO.UserAccountDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Library;
import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import com.ocp7bibliotheque.bibliothequeweb.Proxies.BibliothequeAdministrationUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebAdministrationController {

    @Autowired
    private BibliothequeAdministrationUserProxy userProxy;

    @GetMapping("/administration")
    public String administration() {
        return "administration";
    }

    @PostMapping("/addLibrary")
    public String library(String name, String address) {
        Library library = new Library(name, address);
        Library librarySaved = userProxy.addLibrary(library);
        return  "administration";
    }

    @PostMapping("/addRole")
    public String role(@RequestParam int idRole) {
        UserDetails activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RoleDTO roleDTO = new RoleDTO(activeUser.getUsername(),idRole);
        userProxy.addRole(roleDTO);
        return  "administration";
    }

    @PostMapping("/searchUserAccount")
    public String searchUserAccount(Model model, String mail, String lastName, String firstName, @RequestParam(name="pageList", defaultValue="0") int pageList,@RequestParam(name="size",defaultValue="30") int size) throws Exception {
        UserAccountDTO userAccountDTO = new UserAccountDTO(mail,lastName,firstName,pageList,size);
        Page<UserAccount>pageListUsers;
        try {

            pageListUsers = userProxy.searchUserAccount(userAccountDTO);
            model.addAttribute("listUsers",pageListUsers.getContent());
            int []pagesListSites = new int[pageListUsers.getTotalPages()];
            model.addAttribute("pagesListSites",pagesListSites);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Administration";
    }

/*    @PostMapping("/removeRole")
    public String removeTopo(@RequestParam Long idTopo) {
        try {
            topoService.removeTopo(idTopo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/administration";
    }

    @PostMapping("/removeLibrary")
    public String removeTopo(@RequestParam Long idTopo) {
        try {
            topoService.removeTopo(idTopo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/administration";
    }

    @PostMapping("/searchLibrary")
    public String searchSite(Model model, String country, String place, String cotationMin, String cotationMax, Integer nbSectorsMin,Integer nbSectorsMax,
                             Integer nbPathsMin, Integer nbPathsMax , @RequestParam(name="pageList",defaultValue="0") int pageList,@RequestParam(name="size",defaultValue="30") int size) throws Exception {

        Page<UserAccoujnt> pageListSites;

        try {

            pageListSites = siteService.searchSite(country, place, (Integer) nbSectorsMin,(Integer) nbSectorsMax, ( Integer)nbPathsMin,(Integer)nbPathsMax,cotationMin,cotationMax,pageList,size);
            model.addAttribute("listSites",pageListSites.getContent());
            int []pagesListSites = new int[pageListSites.getTotalPages()];
            model.addAttribute("pagesListSites",pagesListSites);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "sites";
    }*/


}
