package com.deliveryFarmacy.persistence.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private String numberProtocol;

    @ManyToOne(targetEntity = Farmacy.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "farmacy_origin_id")
    private Farmacy farmacyOrigin;

    @OneToOne(targetEntity = Adress.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "adress_id", foreignKey = @ForeignKey(name = "FK_DELIVERY_ADRESS"))
    private Adress adress;
    private String status;
    private String receivedBy;
    private Date dateDelivered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberProtocol() {
        return numberProtocol;
    }

    public void setNumberProtocol(String numberProtocol) {
        this.numberProtocol = numberProtocol;
    }

    public Farmacy getFarmacyOrigin() {
        return farmacyOrigin;
    }

    public void setFarmacyOrigin(Farmacy farmacyOrigin) {
        this.farmacyOrigin = farmacyOrigin;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
