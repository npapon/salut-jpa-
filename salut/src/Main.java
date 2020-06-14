import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Utilisateur;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

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
