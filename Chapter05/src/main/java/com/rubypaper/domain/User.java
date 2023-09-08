package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USERS")
public class User {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user"
			, cascade = {CascadeType.ALL})
	private List<Board> boardList = new ArrayList<Board>();
}
