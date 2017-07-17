package kz.test.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Size(min=3, max=50)
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Size(min=3, max=50)
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "MOBILE", nullable = false)
	private String mobile;

	@Size(min=5, max=50)
	@Column(name = "PICTURE_URI", nullable = false)
	private String pictureUri;

	@Column(name = "USER_STATUS", nullable = false)
	private String userStatus;

	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Requests> requests;



	public User(long id, String firstName, String lastName, String email, String mobile, String pictureUri, String userStatus, Set<Requests> requests) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.pictureUri = pictureUri;
		this.userStatus = userStatus;
		this.requests = requests;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPictureUri() {
		return pictureUri;
	}

	public void setPictureUri(String pictureUri) {
		this.pictureUri = pictureUri;
	}

	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Set<Requests> getRequests() {
		return requests;
	}

	public void setRequests(Set<Requests> requests) {
		this.requests = requests;
	}

	public void addRequest(Requests request) {
		if (request != null) {
			if (requests == null) {
				requests = new HashSet<Requests>();
			}
			requests.add(request);
			request.setUser(this);
		}
	}


}