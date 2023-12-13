package demo.demoGraphqlResolver.utils;

import java.util.Comparator;

import demo.demoGraphqlResolver.model.User;

public class UserComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
//	if(o1.getFirstName().equals(o2.getFirstName()))
//		return 1;
//		else
//		return -1;
//	}

	return Integer.compare(o1.getAge(), o2.getAge());
	}
}
