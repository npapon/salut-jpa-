package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Image;
import bean.Utilisateur;
import dao.ImageDao;
import dao.UtilisateurDao;

@WebServlet( "/imagetest" )
public class Imagetest extends HttpServlet {
    @EJB
    ImageDao       imageDao;
    @EJB
    UtilisateurDao utilisateurDao;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Image image = imageDao.rechercherImage( "npapon@live.fr" );

        Utilisateur utilisateur = utilisateurDao.trouver( "npapon@live.fr" );
        Utilisateur sessionu = utilisateurDao.rechercherSession( "npapon",
                "abcde" );
        HttpSession session = request.getSession();
        session.setAttribute( "image", image );
        session.setAttribute( "utilisateur", utilisateur );
        session.setAttribute( "session", sessionu );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/imagetest.jsp" ).forward( request,
                response );
    }

}
