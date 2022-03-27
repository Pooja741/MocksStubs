class AssertJTest {
	@Test
	void assertJLearningList() {
		List<Integer> list = Arrays.asList(12,45,30);
		assertThat(list).hasSize(3)
				.contains(12,30)
				.allMatch(x -> x >10)
				.allMatch(x -> x < 100)
				.noneMatch(x -> x < 0);
//		assertThat(list, hasSize(3));
//		assertThat(list, hasItems(12,30));
//		assertThat(list, hasItems(12,30));
//		assertThat(list, everyItem(greaterThan(10)));
//		assertThat(list, everyItem(lessThan(50)));
	}

	@Test
	void hamcrestLearningString() {

		assertThat("").isEmpty();
		assertThat("abcde").startsWith("ab")
				.endsWith("de")
				.contains("cd");
//		assertThat("", isEmptyString());
//		assertThat("abcd", containsString("abc"));
//		assertThat("abcde", startsWith("ab"));
//		assertThat("abcdr", endsWith("dr"));
	}
}

