package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.Utilisateur;

@Stateless
public class UtilisateurDao {
    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
    private static final String PARAM_EMAIL           = "email";

    @PersistenceContext( unitName = "bdd_PU" )
    private EntityManager       em;

    public void creer( Utilisateur utilisateur ) throws DAOException {
        try {
            em.persist( utilisateur );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    public Utilisateur trouver( String email ) throws DAOException {
        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        try {
            utilisateur = (Utilisateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return utilisateur;
    }
}