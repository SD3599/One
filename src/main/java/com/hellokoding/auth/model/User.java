package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String securityquestion;
    private String securityanswer;
    private String location;
    private Set<Role> roles;

    public User() {
		super();
	}

	public User(String username) {
		super();
		
		this.username = username;
		
	}
	

	public User(String username, String location) {
		super();
		this.username = username;
		this.location = location;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

	public String getSecurityquestion() {
		return securityquestion;
	}

	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}

	public String getSecurityanswer() {
		return securityanswer;
	}

	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
