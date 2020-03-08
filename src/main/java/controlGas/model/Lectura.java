package controlGas.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lectura {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //autoincrement
    private Long id;
    private Date data;
    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="comptador")
    private Comptador comptador;


    public Lectura() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Comptador getComptador() {
        return comptador;
    }

    public void setComptador(Comptador comptador) {
        this.comptador = comptador;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
