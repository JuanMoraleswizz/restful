package co.com.restful.domain;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "identificacion", nullable = false, length = 12, unique = true)
    private String identificacion;

    @Column(name = "primer_nombre",nullable = false,length = 70)
    private String primerNombre;

    @Column(name = "segundo_nombre", nullable = false, length = 70)
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false, length = 70)
    private String primerApellido;

    @Column(name = "segundo_apellido", nullable = false, length = 70)
    private String segundoApellido;

    @Column(name = "estado")
    private Boolean estado;

}
