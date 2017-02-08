package Version2;


import java.util.*;

public class Joueur {
    

    private Utilisateur User;
    private Integer OrdreJeu;
    private ArrayList<Des> ValDes;
    

    
    public Joueur(Utilisateur User,ArrayList<Des> ValDes, Integer OrdreJeu) {

        this.User = User;
        this.OrdreJeu = OrdreJeu;
        this.ValDes = ValDes;
    }
}
