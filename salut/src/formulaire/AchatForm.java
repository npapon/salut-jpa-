package formulaire;

import java.sql.Timestamp;
import java.util.List;

import bean.Achat;
import dao.AchatDao;

public class AchatForm {

    private AchatDao achatDao;

    public AchatForm( AchatDao achatDao ) {
        this.achatDao = achatDao;
    }

    public List<Achat> libererAchatV2( String nomUtilisateur ) {

        List<Achat> achatsBloquesV2 = achatDao.rechercherAchatsBloquesV2();
        Timestamp dateModification = new Timestamp( System.currentTimeMillis() );

        for ( Achat achat : achatsBloquesV2 ) {
            achatDao.modifierAchatBloqueV2( achat.getId(), nomUtilisateur, dateModification );
        }

        return achatsBloquesV2;

    }

}
