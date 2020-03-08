package controlGas.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Client client;  //una factura pertany a un client, Moltes Factures poden pertanyer a 1 client. Y el mapped iria al que tiene menos, al lado delONE

    @ManyToOne
    Comptador comptador;//1 contador puede tener muchas facturas

    Double lecturaInicial;
    Double lecturaFinal;
    Double consum;
    Double total;
    Date dataEmissió;

    public Factura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Comptador getComptador() {
        return comptador;
    }

    public void setComptador(Comptador comptador) {
        this.comptador = comptador;
    }

    public Double getLecturaInicial() {
        return lecturaInicial;
    }

    public void setLecturaInicial(Double lecturaInicial) {
        this.lecturaInicial = lecturaInicial;
    }

    public Double getLecturaFinal() {
        return lecturaFinal;
    }

    public void setLecturaFinal(Double lecturaFinal) {
        this.lecturaFinal = lecturaFinal;
    }

    public Double getConsum() {
        return consum;
    }

    public void setConsum(Double consum) {
        this.consum = consum;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDataEmissió() {
        return dataEmissió;
    }

    public void setDataEmissió(Date dataEmissió) {
        this.dataEmissió = dataEmissió;
    }
}
