package org.gerdoc.pixup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table( name = "TBL_CANCION" )
public class Cancion extends Catalogo
{
    @Column( name ="TITULO" , nullable = false )
    private String titulo;

    @Column( name ="DURACION" , nullable = false )
    private LocalTime duracion;
}