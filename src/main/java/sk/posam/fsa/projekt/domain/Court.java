package sk.posam.fsa.projekt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "court", schema = "public")
@Access(AccessType.FIELD)
public class Court {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order")
    private Long order;

    @JsonIgnore
    @OneToMany(mappedBy="id")
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name="court_type_fk", nullable=false)
    private CourtType courtType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }
}
