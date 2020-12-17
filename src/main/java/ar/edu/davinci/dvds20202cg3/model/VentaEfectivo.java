package ar.edu.davinci.dvds20202cg3.model;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "vnt_id")
@DiscriminatorValue("EFECTIVO")
@Table(name="ventas_efectivo")

@Data
@NoArgsConstructor(force = true)
@SuperBuilder
public class VentaEfectivo extends Venta implements Serializable {
    private static final long serialVersionUID = -8393218825317899807L;

    @Override
    public Double conRecargo(Double importeBase) {

        return importeBase;
    }



}
