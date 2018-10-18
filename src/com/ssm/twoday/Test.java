package com.ssm.twoday;

class Test {
	private String name;
	public void print() {
		System.out.println("hello word");
	}
	public void print(int a, int b) {
		System.out.println(a + "		" + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + b.toUpperCase());
	}
	@Deprecated
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}