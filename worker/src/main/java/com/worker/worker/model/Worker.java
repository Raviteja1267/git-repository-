package com.worker.worker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Worker")
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 @Column
	private String name;
	 @Column
	private int age;
	 @Column
	private String  email;

}
