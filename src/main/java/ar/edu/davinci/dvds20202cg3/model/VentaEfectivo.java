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
public class VentaEfectivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "vta_id")
    private Long id;
    private static final long serialVersionUID = -8393218825317899807L;


}
