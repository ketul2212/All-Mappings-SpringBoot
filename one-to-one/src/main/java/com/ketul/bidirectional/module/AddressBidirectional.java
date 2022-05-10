package com.ketul.bidirectional.module;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ketul.annotation.NameChecker;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address_bidirectional")
public class AddressBidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NameChecker()
    private String email;

    @OneToOne(mappedBy = "addressBidirectional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private UserBidirectional userBidirectional;

}
