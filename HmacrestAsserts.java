class HamcrestTesting {
	
	@Test
	void hamcrestLearningList() {
		List<Integer> list = Arrays.asList(12,45,30);
		assertThat(list, hasSize(3));
		assertThat(list, hasItems(12,30));
		assertThat(list, hasItem(30));
		assertThat(list, everyItem(greaterThan(10)));
		assertThat(list, everyItem(lessThan(50)));
	}

	@Test
	void hamcrestLearningString() {
		assertThat("", isEmptyString());
		assertThat("abcd", containsString("abc"));
		assertThat("abcde", startsWith("ab"));
		assertThat("abcdr", endsWith("dr"));
	}
}

