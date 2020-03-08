package controlGas.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //autoincrement
    private Long id;
    private String nom;
    private String cog;                                 //restcontroller-->controller es qui te la logit y sap que fer a cada peticio, RESTcontroller vol dir que les peticions li venen a traves duna apirest que li ve per una api que intercambia jason. en un restcontroller li hem de dir com invocar aquesta funcio, mapejar aquesta URL i quin metode executar si ve algo d0aquesta url, si ve una peticio
    private String dni;                                //un repository es un DAO, es lobjecte q permet accedir a les dades, lo que spring li diu repository
                                                        //LAZY per defecte
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "client", fetch = FetchType.LAZY)  //la referencia a municipi la tiene Sinistre, ONE. MApped indica el nom de com te la referencia la taula que referex a aquesta taula ONE
            List<Comptador> comptadorList;

    public Client() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCog() {
        return cog;
    }

    public void setCog(String cog) {
        this.cog = cog;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Comptador> getComptadorList() {
        return comptadorList;
    }

    public void setComptadorList(List<Comptador> comptadorList) {
        this.comptadorList = comptadorList;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cog='" + cog + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
