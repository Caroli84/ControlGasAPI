package controlGas.model;


import controlGas.model.Client;
import controlGas.model.Lectura;

import javax.persistence.*;
import java.util.List;
@Entity
public class Comptador {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //autoincrement
    private Long id;
    private String ref;
    private String adreca;
    private int cp;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "comptador", fetch = FetchType.LAZY)  //la referencia a municipi la tiene Sinistre, ONE. MApped indica el nom de com te la referencia la taula que referex a aquesta taula ONE
            List<Lectura> lecturesList;

    @ManyToOne (fetch = FetchType.EAGER)//moltes incidencies to one municipi
    @JoinColumn(name="client")
    private Client client;



    //cada Comptador nomes tindra una lectura faturada
    Long ultimaLecturaFacturadaId;

    public Comptador() {
    }


    public Long getUltimaLecturaFacturadaId() {
        return ultimaLecturaFacturadaId;
    }

    public void setUltimaLecturaFacturadaId(Long ultimaLecturaFacturadaId) {
        this.ultimaLecturaFacturadaId = ultimaLecturaFacturadaId;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public List<Lectura> getLecturesList() {
        return lecturesList;
    }

    public void setLecturesList(List<Lectura> lecturesList) {
        this.lecturesList = lecturesList;
    }

    @Override
    public String toString() {
        return "Comptador{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", adreca='" + adreca + '\'' +
                ", cp=" + cp +
                '}';
    }
}
