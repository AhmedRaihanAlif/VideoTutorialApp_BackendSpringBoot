/**
 * 
 */
package com.app.videoTutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.videoTutorial.model.SignUp;

/**
 * author: Ahmed Raihan
 * date: 5/06/2024
 */
/**
 * this is the dao for signup table this is an interface that inherit
 * JpaRepository<dto, data type of primary key> is responsible to create
 * connection with db automatic this interface will act like template for all
 * APIs
 */
public interface SignUpDao extends JpaRepository<SignUp, Integer> {

	@Modifying
	@Query("update SignUp s set s.userName = ?1, s.email = ?2, s.phone = ?3, s.password=?4, s.profilePic=?5  where s.userId = ?6")
	void updateInfoById(String userName, String email, Integer phone, String password, String profilePic,
			Integer userId);

}
