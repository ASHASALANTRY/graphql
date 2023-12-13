package demo.demoGraphqlResolver.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.demoGraphqlResolver.model.User;
import demo.demoGraphqlResolver.service.ReactiveService;
import demo.demoGraphqlResolver.utils.UserComparator;
//import reactor.core.publisher.Flux;
import reactor.core.publisher.Flux;

@RestController
public class DefaultController {
	@GetMapping("/test")
	public void test() {
		//Wrapper object(Thread safe)
		var wraper =new Object() {
			Integer ab=2;
		};
		/*The AtomicReference class provides an object reference variable which can be read and written atomically.
		 *  By atomic is meant that multiple threads attempting to change the same AtomicReference
		 *   (e.g. with a compare-and-swap operation) will not make the AtomicReference end up in an inconsistent state.*/
		//atomicReference
		AtomicReference<Integer> atom =new AtomicReference<>(111);
		Integer i=11;
		ArrayList<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.forEach(x->{// a.add(atom.get()+1);
		atom.getAndSet(1);
		//a.add(i+1);
		wraper.ab=wraper.ab+1;
		});
		//Reactive Programming (populating mono streams)
		ReactiveService.intNumberMono().subscribe(e->System.out.println(e));
		//comparable Comparator
		ArrayList<User> userList=new ArrayList<>();
		userList.add(new User(1,"asha","xyz",20));
		userList.add(new User(2,"asha1","xyz",40));
		userList.add(new User(3,"asha2","xyz",10));
		userList.add(new User(4,"asha3","xyz",30));
		Collections.sort(userList);
		System.out.println("Sorted orders list");
		Flux.just(userList).subscribe(e->System.out.println(e));
		Collections.sort(userList, new UserComparator());
		ArrayList<User> arr=(ArrayList<User>)userList.stream().sorted((s1,s2)->s2.getAge().compareTo(s1.getAge())).collect(Collectors.toList());
		Flux.just(arr).subscribe(e->System.out.println(e));

		//Comparator comp=(userlist.get(1),userlist.get(2))->
	}
}
