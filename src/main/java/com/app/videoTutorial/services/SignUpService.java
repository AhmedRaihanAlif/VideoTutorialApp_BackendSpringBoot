/**
 * 
 */
package com.app.videoTutorial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.videoTutorial.dao.SignUpDao;
import com.app.videoTutorial.model.ResponseInfo;
import com.app.videoTutorial.model.SignUp;

/**
 * author: Ahmed Raihan Alif
 * date: 5/06/2024
 */
/**
 * this is the service class for the API to perform crud operation for signup
 * table all the data processing according to request will be performed in this
 * class is responsible for return response this service class will act like
 * template for all APIs
 */

@Component
public class SignUpService {

	@Autowired
	SignUpDao signUpDao;

	public ResponseInfo<List<SignUp>> getAllInfos() {
		ResponseInfo<List<SignUp>> responseInfo = new ResponseInfo<>();

		try {
			List<SignUp> response = signUpDao.findAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(new ArrayList<>());

		return null;
	}

	public ResponseInfo<Optional<SignUp>> getInfo(Integer id) {

		ResponseInfo<Optional<SignUp>> responseInfo = new ResponseInfo<>();

		try {
			Optional<SignUp> response = signUpDao.findById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(Optional.empty());

		return null;

	}

	public ResponseInfo<String> saveInfo(SignUp signUpInfo) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			signUpDao.save(signUpInfo);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteInfo(Integer userId) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			signUpDao.deleteById(userId);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully deleted id: " + userId);
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteAllInfos() {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			signUpDao.deleteAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully truncated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	/**
	 * using @Transactional annotation Spring will automatically start and manage a
	 * transaction for the duration of the method execution. This will resolve the
	 * TransactionRequiredException when executing modifying queries.
	 */
	@Transactional
	public ResponseInfo<String> updateInfo(SignUp signUpInfo) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			signUpDao.updateInfoById(signUpInfo.getUserName(), signUpInfo.getEmail(), signUpInfo.getPhone(),
					signUpInfo.getPassword(), signUpInfo.getProfilePic(), signUpInfo.getUserId());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully updated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}
}
