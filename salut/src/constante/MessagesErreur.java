package constante;

public class MessagesErreur {
    public static final String FICHIER_PROPRIETE_INTROUVABLE        = "Le fichier propri�t� est introuvable";
    public static final String DRIVER_INTROUVABLE                   = "Driver introuvable dans le classpath ";
    public static final String ECHEC_INSERT_UTILISATEUR             = "L'utilisateur n'a pas �t� ins�r� en base";
    public static final String ECHEC_INSERT_IMAGEPROFIL             = "L'image de profil n'a pas �t� ins�r� en base";
    public static final String ECHEC_UPDATE_IMAGEPROFIL             = "L'image de profil n'a pas �t� updat� en base";
    public static final String ECHEC_UPDATE_ACHATSBLOQUESV2         = "Aucun achat bloqu� dans V2 n'a �t� mis � jour";
    public static final String ECHEC_DELETE_IMAGEPROFIL             = "L'image de profil n'a pas �t� effac� en base";
    public static final String ECHEC_DELETE_UTILISATEUR             = "L'utilisateur n'a pas �t� effac� en base";
    public static final String ECHEC_RECUPERATION_ID_UTILISATEUR    = "aucun id unique pour l'utilisateur de trouv� car aucune ligne n'a �t� ins�r�e pour l'utilisateur en base";
    public static final String ECHEC_RECUPERATION_ID_IMAGEPROFIL    = "aucun id unique pour l'image de profil de trouv� car aucune ligne n'a �t� ins�r�e pour l'utilisateur en base";
    public static final String LOGIN_TROP_COURT                     = "Le login doit faire plus de 3 caract�res";
    public static final String NOM_TROP_COURT                       = "Le nom doit faire plus de 3 caract�res";
    public static final String MOTDEPASSE_TROP_COURT                = "Le mot de passe doit faire plus de 3 caract�res";
    public static final String MOTDEPASSE_INCORRECT                 = "Le mot de passe n'est pas le bon pour le login choisi";
    public static final String SESSION_INTROUVABLE                  = "Aucune session n'a �t� trouv�e en base";
    public static final String IMAGEPROFIL_INEXISTANTE              = "Aucune image n'a �t� trouv� pour le mail choisi";
    public static final String EMAIL_FORMAT_INVALIDE                = "Le format de l'email n'est pas valide";
    public static final String EMAIL_ABSENT                         = "Impossible de r�cup�rer l'email dans la session de l'utilisateur";
    public static final String EMPLACEMENT_VIDE                     = "Aucun emplacement de d�fini";
    public static final String EMAIL_DEJA_PRIS                      = "L'email est d�j� pris";
    public static final String CONFIRMATION_MOTPASSE_INCORRECTE     = "Le mot de passe confirm� est diff�rent";
    public static final String CREATION_UTILISATEUR_KO              = "Echec de la cr�ation en base utilisateur";
    public static final String CREATION_SESSIONACTIVE_KO            = "Echec de la cr�ation d'une session de connexion";
    public static final String CREATION_IMAGEPROFIL_KO              = "Echec de la cr�ation en base image profil";
    public static final String CREATION_UTILISATEUR_KO_RAISON_BDD   = "Echec de la cr�ation utilisateur pour un probl�me li� � la base";
    public static final String CREATION_SESSIONACTIVE_KO_RAISON_BDD = "Echec de la cr�ation de la session pour un probl�me li� � la base";
    public static final String CREATION_IMAGEPROFIL_KO_RAISON_BDD   = "Echec de la cr�ation image profil pour un probl�me li� � la base";
    public static final String TAILLE_FICHIER_TROP_GRANDE           = "Le fichier a une taille trop grande";
    public static final String AUCUN_FICHIER                        = "L'en_t�te de la requ�te POST ne contient aucun fichier";
    public static final String FICHIER_PAS_UNE_IMAGE                = "Le fichier n'est pas une image";
    public static final String ERREUR_CONFIG_POOL_CONNEXIONS        = "Erreur de configuration du pool de connexions";

}
