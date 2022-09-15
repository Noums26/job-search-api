package com.workapi.workapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Offers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Long domain_id;

    private Long user_id;

    private boolean state;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer_id")
    private List<Mission> missions;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "domain_id", insertable = false, nullable = false, updatable = false)
    private Domain domain;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, nullable = false, updatable = false)
    private Users user;

}
