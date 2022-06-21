package sk.posam.fsa.projekt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation", schema = "public")
@Access(AccessType.FIELD)
public class Reservation {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "time_start")
    private Long timeStart;

    @Column(name = "length")
    private Long length;

    @Column(name = "date")
    private String date;

    @Column(name = "mail")
    private String mail;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private int status;

    @Column(name = "light")
    private boolean light;

    @ManyToOne
    @JoinColumn(name="court_fk", nullable=false)
    private Court court;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", length=" + length +
                ", date='" + date + '\'' +
                ", mail='" + mail + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", court=" + court +
                '}';
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }
}
