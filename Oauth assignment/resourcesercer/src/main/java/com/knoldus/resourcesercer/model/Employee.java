package com.knoldus.resourcesercer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    Long id;
    String name;
    String CompanyName;

}
