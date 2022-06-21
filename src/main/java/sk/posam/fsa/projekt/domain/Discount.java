package sk.posam.fsa.projekt.domain;

import javax.persistence.*;

@Entity
@Table(name = "discount", schema = "public")
@Access(AccessType.FIELD)
public class Discount {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "percentage", nullable = false)
    private Long percentage;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPercentage() {
        return percentage;
    }

    public void setPercentage(Long percentage) {
        this.percentage = percentage;
    }
}
