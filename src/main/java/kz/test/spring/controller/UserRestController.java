package kz.test.spring.controller;

import kz.test.spring.model.Status;
import kz.test.spring.model.StatusEnum;
import kz.test.spring.model.User;
import kz.test.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

	
	@Autowired
	IUserService userService;

	/**
	 * Returns list of users DB
	 *
	 * @return list of users
	 */
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.list();
	}

	/**
	 * Returns user by unique ID
	 *
	 * @return user
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity getUsers(@PathVariable("id") Long id) {

		User user = userService.get(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	/**
	 * Create new user in DB.
	 *
	 * @param user
	 *            User object
	 * @return new user object
	 */
	@PostMapping(value = "/users")
	public ResponseEntity createUser(@RequestBody @Validated User user) {

		user = userService.create(user);

		return new ResponseEntity(user.getId(), HttpStatus.OK);
	}

	/**
	 * Delete the user object from DB. If user not found for given id, returns null.
	 * @param id
	 *            the user id
	 * @return id of deleted user object
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {

		if (null == userService.get(id)) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		else
			userService.delete(id);

		return new ResponseEntity(id, HttpStatus.OK);

	}

	/**
	 * Update the user object for given id
	 *
	 * @param id
	 * @param user
	 * @return user object with id
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody @Validated User user) {

		user = userService.update(user, id);

		if (null == user) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PutMapping("/users/{id}/{status}")
	public ResponseEntity changeStatus(@PathVariable Long id, @PathVariable String status) {

		User user = userService.get(id);

		if (null == user) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		Status s = new Status();
		s.setId(user.getId());
		s.setOldStatus(user.getUserStatus());
		for(StatusEnum statusEnum : StatusEnum.values()){
			if(status.equals(statusEnum.getStatusEnum())){
				user.setUserStatus(status);
			}
		}
		userService.update(user,id);
		s.setStatus(user.getUserStatus());

		return new ResponseEntity(s, HttpStatus.OK);
	}

	@GetMapping("/users/statistic/{status}")
	public List getUsersStatisticsByStatus(@PathVariable("status") String status) {
		return userService.statistic(status);
	}

	@GetMapping("/users/statistic/{status}/{requestId}")
	public List getUsersStatistics(@PathVariable("status") String status, @PathVariable("requestId") String requestId) {
		return userService.statistic(status, requestId);
	}





}