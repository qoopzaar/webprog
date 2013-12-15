/**
 * 
 */
package example.webprog.entity;

/**
 * @author Nathnicha
 * @create Dec 12, 2013
 * @since 1.0
 * 
 */
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2558266518418276442L;

	private String username;
	private String password;
	private String role;

	/**
	 * 
	 */
	public User() {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
