package com.adarsh.BookMyShowProject.Config;

import java.util.List;

import lombok.Data;

@Data
public class ResponseStucture<T> {

	private int status;
	private String message;
	private T data;
	private List<T> dataAll;

}
