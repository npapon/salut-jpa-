package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Image;
import bean.Utilisateur;
import constante.Adressesinternes;
import constante.AttributsServlet;
import constante.Dossiers;
import constante.RepertoiresIcones;
import dao.ImageDao;
import dao.UtilisateurDao;
import formulaire.ProfilForm;

@WebServlet( "/profil" )
@MultipartConfig( location = "C:\\Users\\npapo\\git\\Dao\\Dao", maxFileSize = 10485760, maxRequestSize = 52428800, fileSizeThreshold = 1048576 )

public class ProfilServlet extends HttpServlet {
    @EJB
    public ImageDao       imageDao;
    @EJB
    public UtilisateurDao utilisateurDao;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute( AttributsServlet.ICONE_SUPPRIMER, RepertoiresIcones.SUPPRIMER );
        session.setAttribute( AttributsServlet.EFFACERMONCOMPTE_PAGE, Adressesinternes.EFFACERMONCOMPTE_COURT );
        this.getServletContext().getRequestDispatcher( Adressesinternes.PROFIL ).forward( request,
                response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ProfilForm profilForm = new ProfilForm( imageDao, utilisateurDao );
        Image image = null;

        try {
            image = profilForm.creerImageProfil( Dossiers.REPERTOIRE_CONTEXTE_APPLICATION, Dossiers.REPERTOIRE_IMAGESPROFIL,
                    request );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        Utilisateur sessionActive = (Utilisateur) session.getAttribute( AttributsServlet.SESSIONACTIVE );
        sessionActive.setEmplacementImageProfil( image.getEmplacement() );
        session.setAttribute( AttributsServlet.IMAGEPROFIL, image );

        response.sendRedirect( Adressesinternes.PROFIL_COURT );
    }

}
