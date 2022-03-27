class JsonPathTest{
	@Test
	void learning() {
		String responseString = "[\n" +
				"  {\"id\": 1001,\"name\": \"sketch pencil\",\"price\": 20},\n" +
				"  {\"id\": 1002,\"name\": \"pencil\",\"price\": 15},\n" +
				"  {\"id\": 1003,\"name\": \"pen\",\"price\": 30}\n" +
				"]";
		DocumentContext context = JsonPath.parse(responseString);

		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);

		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(1001,1002,1003);
		assertThat(ids).contains(1002,1003,1001);

		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='pencil')]").toString());
		System.out.println(context.read("$.[?(@.price==30)]").toString());
	}
}
