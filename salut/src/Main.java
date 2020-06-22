import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.Image;
import bean.Utilisateur;
import dao.DAOException;
import dao.ImageDao;

@Stateless
public class Main {

    private static final String  JPQL_SELECT_PAR_EMAIL = "SELECT i FROM Image i WHERE i.email = :email";

    private static final String  PARAM_EMAIL           = "email";

    @PersistenceContext( unitName = "bdd_PU" )
    private static EntityManager em;

    public String recupererLibelleAssocieALImage2( String email, ImageDao imageDao ) {

        Image imageProfil = imageDao.rechercherImage( email );

        String libelleImage = imageProfil.getLibelle();
        return libelleImage;

    }

    public static Image rechercherImage2( String email ) throws DAOException {
        System.out.println( "lol" + em );
        Image imageProfil = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        try {
            imageProfil = (Image) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return imageProfil;
    }

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Image image = new Image();
        image = rechercherImage2( "npapon@live.fr" );

        System.out.println( "lol" + rechercherImage2( "npapon@live.fr" ) );
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        entityManagerFactory = Persistence.createEntityManagerFactory( "bdd_PU" );
        entityManager = entityManagerFactory.createEntityManager();

        System.out.println( "- Lecture de tous les articles -----------" );

        List<Utilisateur> utilisateurs = entityManager.createQuery( "select u from Utilisateur u", Utilisateur.class )
                .getResultList();
        for ( Utilisateur utilisateur : utilisateurs ) {
            System.out.println( utilisateur );
        }

    }

}
