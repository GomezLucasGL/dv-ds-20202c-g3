package ar.edu.davinci.dvds20202cg3.model;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "vnt_id")
@DiscriminatorValue("EFECTIVO")
@Table(name="ventas_efectivo")

@Data
@SuperBuilder
public class VentaEfectivo extends Venta implements Serializable {

    @Override
    public Double conRecargo(Double importeBase) {
        return importeBase;
    }
    private static final long serialVersionUID = -8393218825317899807L;


}
