package service;

import domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {
	private List<User> listOfUsers = new ArrayList<>();
	private static UserService userService;

	private UserService() {}

	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void saveUser(User user) {
		listOfUsers.add(user);
	}

	public User getUser(String login) {
		return listOfUsers.stream().filter(user -> user.getUserLogin().equals(login)).findAny().orElse(null);
	}
}
