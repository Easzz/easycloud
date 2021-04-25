package com.findshen.corejava.utils.convert;

/**
 * Created by findshen on 2021/1/19 10:54
 */
public class UserConvert extends AbstractConvert<User, UserDTO> {
	@Override
	public UserDTO doForward(User user) {
		return null;
	}

	@Override
	public User doBackup(UserDTO userDTO) {
		return null;
	}

}
