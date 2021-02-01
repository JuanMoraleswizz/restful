package co.com.restful.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Table(name = "tipo_identificacion")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonIgnore
    @OneToOne(mappedBy = "tipoIdentificacion")
    private Cliente cliente;

    @Column(name = "estado")
    private Boolean estado;
}
