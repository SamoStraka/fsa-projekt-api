package sk.posam.fsa.projekt.domain;


import javax.persistence.*;

@Entity
@Table(name = "price", schema = "public")
@Access(AccessType.FIELD)
public class Price {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name="court_type_fk", nullable=false)
    private CourtType courtType;

    @ManyToOne
    @JoinColumn(name="type_of_day_fk", nullable=false)
    private TypeOfDay typeOfDay;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public TypeOfDay getTypeOfDay() {
        return typeOfDay;
    }

    public void setTypeOfDay(TypeOfDay typeOfDay) {
        this.typeOfDay = typeOfDay;
    }
}
