package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Achat;
import bean.Utilisateur;
import constante.Adressesinternes;
import constante.AttributsServlet;
import dao.AchatDao;
import formulaire.AchatForm;

@WebServlet( "/libererachatv2" )
public class LibererAchatV2Servlet extends HttpServlet {
    @EJB

    private AchatDao achatDao;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( Adressesinternes.LIBERERACHATV2 ).forward( request,
                response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        AchatForm achatForm = new AchatForm( achatDao );
        HttpSession session = request.getSession();
        Utilisateur sessionActive = (Utilisateur) session.getAttribute( AttributsServlet.SESSIONACTIVE );
        List<Achat> achatLiberes = achatForm.libererAchatV2( sessionActive.getLogin() );
        session.setAttribute( AttributsServlet.LISTEACHATSLIBERESV2, achatLiberes );
        response.sendRedirect( Adressesinternes.SYNTHESE_SCRIPT_LIBERERACHATV2_COURT );

    }

}
