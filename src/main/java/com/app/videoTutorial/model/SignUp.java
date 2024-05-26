/**
 * 
 */
package com.app.videoTutorial.model;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * author: Ahmed Raihan
 * date: 5/06/2024
 */
/**
 * this is the dto for signup table all the properties of this class should be
 * as same as the columns of the table this dto will act like template for all
 * APIs
 */

@Entity
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String userName;
	private String email;
	private Integer phone;
	private String password;
	private String profilePic;
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
		this.password = sha256hex;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SignUp [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", profilePic=" + profilePic + ", roleId=" + roleId + "]";
	}

	public String getMatchedPassword(String password) {
		String rawPassword = password;
		String raw = Hashing.sha256().hashString(rawPassword, StandardCharsets.UTF_8).toString();
		String hashPassword = getPassword();
		if (hashPassword.equals(raw)) {
			System.out.println("Passwords match!");
			return "Passwords match!";
		} else {
			System.out.println("Passwords do not match!");
			return "Passwords do not match!";
		}
	}

}
