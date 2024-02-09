package com.dsa.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ImmutableExample {

	final List<Integer> list;
	final String name;
	final ModelDTO model;

	public ImmutableExample(List<Integer> list, String name, ModelDTO model) {
		this.list = list;
		this.name = name;
		this.model = model;
	}

	public void printList() {
		System.out.println("Name : " + name);
		System.out.println("Model Name : " + model.getModelName());
	}

	public ModelDTO getModel() {
		return model;
	}

	public static void main(String args[]) {

		List<Integer> mainList = new LinkedList<Integer>();
		String name = "tejas";
		ModelDTO model = new ModelDTO(name);
		ImmutableExample obj = new ImmutableExample(mainList, name,model);
		mainList.add(12);
		mainList.add(122);
		mainList.add(1222);
		mainList.add(12222);
		mainList.add(122222);
		obj.printList();
		System.out.println("--------------------------------");
		name = "Hello world";
		model.setModelName(name);
		mainList.add(1222222);
		obj.printList();

	}

}
