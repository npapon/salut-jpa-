package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constante.Adressesinternes;
import constante.Dossiers;
import dao.ImageDao;
import dao.UtilisateurDao;
import formulaire.ProfilForm;

@WebServlet( "/effacermoncompte" )
public class EffacerMonCompteServlet extends HttpServlet {
    @EJB
    private UtilisateurDao utilisateurDao;
    @EJB
    private ImageDao       imageDao;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ProfilForm profilForm = new ProfilForm( imageDao, utilisateurDao );
        HttpSession session = request.getSession();
        try {
            profilForm.supprimerCompte( Dossiers.REPERTOIRE_CONTEXTE_APPLICATION, Dossiers.REPERTOIRE_IMAGESPROFIL, request );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        session.invalidate();

        response.sendRedirect( Adressesinternes.CONNEXION_COURT );
    }

}
