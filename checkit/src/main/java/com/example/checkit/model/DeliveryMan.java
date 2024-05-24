package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
@Accessors(chain = true)
@DiscriminatorValue("delivery_man")
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class DeliveryMan extends User{

    @ElementCollection
    @CollectionTable(
            name = "nic_images",
            joinColumns = @JoinColumn(name= "seller_id")
    )
    @Column(name="nationalId")
    private List<String> nicImagesUrls;

    @ElementCollection
    @CollectionTable(
            name = "dl_images",
            joinColumns = @JoinColumn(name = "deliveryman_id")
    )
    @Column(name = "driving_license")
    private List<String> drivingLicenseUrls;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "deliveryMan")
    private List<Delivery> deliveries;
}
