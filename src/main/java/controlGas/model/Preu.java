package controlGas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Integer inici;
    public Integer fi;
    public Double valor;


    public Preu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInici() {
        return inici;
    }

    public void setInici(Integer inici) {
        this.inici = inici;
    }

    public Integer getFi() {
        return fi;
    }

    public void setFi(Integer fi) {
        this.fi = fi;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
