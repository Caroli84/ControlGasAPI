package controlGas.controllers;

import controlGas.dao.ComptadorRepository;
import controlGas.dao.FacturaRepository;
import controlGas.dao.LecturaRepository;
import controlGas.dao.PreuRepository;
import controlGas.model.Comptador;
import controlGas.model.Factura;
import controlGas.model.Lectura;
import controlGas.model.Preu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FacturaController {
    @Autowired
    FacturaRepository facturaRepository;
    ComptadorRepository comptadorRepository;
    LecturaRepository lecturaRepository;
    PreuRepository preuRepository;
    public void calcularFactures(){
        List<Comptador> comptadorList=comptadorRepository.findAll();
        for (Comptador comptador:comptadorList ) {
            Long ultimaLecturaFacturaId=comptador.getUltimaLecturaFacturadaId();//de cada contador tomo la ultima lectura facturada
            Optional<Lectura> ultimaLecturaFacturada=lecturaRepository.findById(ultimaLecturaFacturaId);//si existe, tomo la fecha
            Date dataUltimaLecturaFacturada=null;
            if(ultimaLecturaFacturada.isPresent()){
                dataUltimaLecturaFacturada=ultimaLecturaFacturada.get().getData();

            }

            //guardo en una lista lo que haya por facturar
            List <Lectura> lecturaList=lecturaRepository.findByComptadorAndDataGreaterThan(comptador,dataUltimaLecturaFacturada);
            if(!lecturaList.isEmpty()){
                Date ultimaLectura=dataUltimaLecturaFacturada;//la que se tiene referenciada como la ultima pagada
                Lectura maxLectura=lecturaList.get(0); //????de la lista pillo la mas nueva
                //si hay mas de una en la lista busco el maximo?????
                for (Lectura lecturaNoFacturada:lecturaList) {
                    Date dataLectura=lecturaNoFacturada.getData();
                    if(dataLectura.getTime()>ultimaLectura.getTime()){
                        ultimaLectura=dataLectura; //ahora la referencia de la ultima cobrada se sustituye a la nueva factura
                        maxLectura=lecturaNoFacturada;
                    }
                }

                Double consum=maxLectura.getValor()-ultimaLecturaFacturada.get().getValor();
                List<Preu> preuList=preuRepository.findByIniciGreaterThanAndFiLessThan(consum,consum);
                Preu preu=preuList.get(0);
                Double preuKWh=preu.getValor();
                Double total=consum*preuKWh;

                Factura factura=new Factura();
                factura.setClient(comptador.getClient());
                factura.setComptador(comptador);
                factura.setLecturaInicial(ultimaLecturaFacturada.get().getValor());//se lee desde el ultimo registro
                factura.setLecturaFinal(maxLectura.getValor());//hasta el get(0) de la Lista pq es el ultimo en facturarse
                factura.setConsum(consum);
                factura.setTotal(total);
                Date datee = java.sql.Date.valueOf(LocalDate.now());
                factura.setDataEmissió(datee);
                facturaRepository.save(factura);
                comptador.setUltimaLecturaFacturadaId(maxLectura.getId());
                comptadorRepository.save(comptador);

            }




        }

    }


}
