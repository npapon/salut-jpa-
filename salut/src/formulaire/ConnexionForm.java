package formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bean.Image;
import bean.Utilisateur;
import constante.MessagesErreur;
import constante.MessagesSucces;
import constante.ParametresFormulaire;
import dao.DAOException;
import dao.ImageDao;
import dao.UtilisateurDao;
import exception.FormValidationException;

public class ConnexionForm {

    private UtilisateurDao utilisateurDao;
    private ImageDao       imageDao;
    private List<String>   erreurs = new ArrayList<String>();
    private String         connexionAutorisee;

    public ConnexionForm( UtilisateurDao utilisateurDao, ImageDao imageDao ) {
        this.utilisateurDao = utilisateurDao;
        this.imageDao = imageDao;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        String login = request.getParameter( ParametresFormulaire.LOGIN );
        String motdepasse = request.getParameter( ParametresFormulaire.MOTDEPASSE );

        Utilisateur sessionActive = new Utilisateur();

        try {

            affecterLogin( login );
            verifierMotDePasse( login, motdepasse, sessionActive );
            String email = recupererEmail( login, motdepasse, sessionActive );
            recupererEmplacementImageProfil( email, sessionActive );
            if ( erreurs.isEmpty() ) {
                connexionAutorisee = MessagesSucces.SESSIONACTIVE_CREE;

                System.out.println( connexionAutorisee );
            } else {
                connexionAutorisee = MessagesErreur.CREATION_SESSIONACTIVE_KO;
                sessionActive = null;
                System.out.println( connexionAutorisee );

            }

        } catch ( DAOException e ) {
            connexionAutorisee = MessagesErreur.CREATION_SESSIONACTIVE_KO_RAISON_BDD;
            System.out.println( connexionAutorisee );
            e.printStackTrace();

        }

        return sessionActive;
    }

    public void affecterLogin( String login ) {
        if ( login.length() <= 3 ) {
            try {
                throw new FormValidationException( MessagesErreur.LOGIN_TROP_COURT );
            } catch ( FormValidationException e ) {
                System.out.println( e.getMessage() );

                erreurs.add(
                        e.getMessage() );
            }
        }
    }

    public void verifierMotDePasse( String login, String motdepasse, Utilisateur session ) {
        if ( utilisateurDao.rechercherSession( login, motdepasse ) == null ) {
            try {
                throw new FormValidationException( MessagesErreur.MOTDEPASSE_INCORRECT );
            } catch ( FormValidationException e ) {
                System.out.println( e.getMessage() );

                erreurs.add(
                        e.getMessage() );
            }
        } else {
            session.setLogin( login );
            session.setMot_de_passe( motdepasse );
        }

    }

    public String recupererEmail( String login, String motdepasse, Utilisateur session ) {
        String email = null;
        if ( utilisateurDao.rechercherSession( login, motdepasse ) == null ) {
            try {
                throw new FormValidationException( MessagesErreur.SESSION_INTROUVABLE );
            } catch ( FormValidationException e ) {
                System.out.println( e.getMessage() );

                erreurs.add(
                        e.getMessage() );
            }
        } else {
            email = utilisateurDao.rechercherSession( login, motdepasse ).getEmail();
            session.setEmail( email );

        }
        return email;
    }

    private void recupererEmplacementImageProfil( String email, Utilisateur sessionActive ) {
        Image imageProfil = null;
        if ( imageDao.rechercherImage( email ) == null ) {
            System.out.println( MessagesErreur.IMAGEPROFIL_INEXISTANTE );

        } else

        {

            String imageProfilEmplacement = imageDao.rechercherImage( email ).getEmplacement();
            sessionActive.setEmplacementImageProfil( imageProfilEmplacement );
        }

    }

    public String getConnexionAutorisee() {
        return connexionAutorisee;
    }

    public List<String> getErreurs() {
        return erreurs;
    }

}
