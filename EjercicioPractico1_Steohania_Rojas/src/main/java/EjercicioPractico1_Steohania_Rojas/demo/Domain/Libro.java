package EjercicioPractico1_Steohania_Rojas.demo.Domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "libro")
@Data
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    
    @Column(name = "autor", nullable = false, length = 200)
    private String autor;
    
    @Column(name = "isbn", length = 20)
    private String isbn;
    
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;  // Ahora sí encuentra Categoria porque están en el MISMO paquete
    
    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    
    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;
    
    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructor por defecto
    public Libro() {}
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    
    
    

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getTitulo() { return titulo; }
public void setTitulo(String titulo) { this.titulo = titulo; }

public String getAutor() { return autor; }
public void setAutor(String autor) { this.autor = autor; }

public String getIsbn() { return isbn; }
public void setIsbn(String isbn) { this.isbn = isbn; }

public String getDescripcion() { return descripcion; }
public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

public Categoria getCategoria() { return categoria; }
public void setCategoria(Categoria categoria) { this.categoria = categoria; }

public LocalDate getFechaPublicacion() { return fechaPublicacion; }
public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

public Boolean getDisponible() { return disponible; }
public void setDisponible(Boolean disponible) { this.disponible = disponible; }

public BigDecimal getPrecio() { return precio; }
public void setPrecio(BigDecimal precio) { this.precio = precio; }

public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

public LocalDateTime getUpdatedAt() { return updatedAt; }
public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}