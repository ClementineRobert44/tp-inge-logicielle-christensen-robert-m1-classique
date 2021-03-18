package com.acme.todolist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;


public class TodoItemTest {
	
	@Test
	void isLate_itemCreationDate20Minutes_returnsFalse() {
		TodoItem item = new TodoItem("1", Instant.now().minus(20,ChronoUnit.MINUTES), "mycontent");
		assertThat(item.isLate(), is(false));
	}
	
	// Ce test renvoie faux
	@Test
	void isLate_itemCreationDate50Minutes_returnsTrue() {
		TodoItem item = new TodoItem("2", Instant.now().minus(50,ChronoUnit.MINUTES), "mycontent");
		assertThat(item.isLate(), is(true));
	}
	
	@Test
	void is_Faire_Les_Courses() {
		TodoItem item = new TodoItem("3", Instant.now().minus(50,ChronoUnit.MINUTES), "Faire les courses");
		assertThat(item.compareContent("Faire les courses"), is(true));
	}
	
	// Ce test renvoie faux
	@Test
	void contentLessThan15Characters() {
		TodoItem item = new TodoItem("4", Instant.now().minus(50,ChronoUnit.MINUTES), "Faire les courses");
		assertThat(item.isLessThan15Characters(), is(true));
	}
	
	
	
	
	
	
	

}
