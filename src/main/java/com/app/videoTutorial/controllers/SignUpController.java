package com.app.videoTutorial.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.videoTutorial.model.ResponseInfo;
import com.app.videoTutorial.model.SignUp;

import com.app.videoTutorial.services.SignUpService;

@RestController
@RequestMapping("signup")
public class SignUpController {
	@Autowired
	SignUpService signUpService;

	@GetMapping("all")
	public ResponseInfo<List<SignUp>> getAllMethod() {
		return signUpService.getAllInfos();
	}

	@GetMapping("/{userId}")
	public ResponseInfo<Optional<SignUp>> getMethod(@PathVariable Integer userId) {
		return signUpService.getInfo(userId);
	}

	@GetMapping("/{userPassword}")
	public ResponseInfo<Optional<SignUp>> getPassword(@PathVariable Integer userId) {
		return signUpService.getInfo(userId);
	}

	@PostMapping("add")
	public ResponseInfo<String> postMethod(@RequestBody SignUp signUpCrud) {
		return signUpService.saveInfo(signUpCrud);
	}

	@DeleteMapping("delete/{userId}")
	public ResponseInfo<String> deleteMethod(@PathVariable Integer userId) {
		return signUpService.deleteInfo(userId);
	}

	@DeleteMapping("delete/all")
	public ResponseInfo<String> deleteAllMethod() {
		return signUpService.deleteAllInfos();
	}

	@PutMapping("update")
	public ResponseInfo<String> updateMethod(@RequestBody SignUp signUpUpdate) {
		return signUpService.updateInfo(signUpUpdate);
	}

}
