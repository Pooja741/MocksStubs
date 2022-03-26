
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UnitTestingApplicationTests {

	String actualResponse = "{ id:1, name:pencil, price:10, quantity : 50}";
	@Test
	void contextLoads() {
	}

	@Test
	void jsonAssert_with_strict_true() throws JSONException {
		String expectedResponse = "{ id:1, name:pencil, price:10, quantity : 50}";
		JSONAssert.assertEquals(expectedResponse,actualResponse,true);
	}
	@Test
	void jsonAssert_with_strict_true_when_some_keys_are_missing() throws JSONException {
		String expectedResponse = "{ id:1, name:pencil, price:10}";
		JSONAssert.assertNotEquals(expectedResponse,actualResponse,true);
	}
	@Test
	void jsonAssert_with_strict_true_when_format_is_different_but_all_keys_are_present() throws JSONException {
		String expectedResponse = "{ id:   1  , name:pencil, price  :   10, quantity : 50}";
		JSONAssert.assertEquals(expectedResponse,actualResponse,true);
	}
	@Test
	void jsonAssert_with_strict_false() throws JSONException {
		String expectedResponse = "{ id:1, name:pencil, price:10, quantity : 50}";
		JSONAssert.assertEquals(expectedResponse,actualResponse,false);
	}
	@Test
	void jsonAssert_with_strict_false_when_some_keys_are_missing() throws JSONException {
		String expectedResponse = "{ id:1, name:pencil, price:10}";
		JSONAssert.assertEquals(expectedResponse,actualResponse,false);
	}
	@Test
	void jsonAssert_with_strict_false_when_format_is_different_but_all_keys_are_present() throws JSONException {
		String expectedResponse = "{ id:   1  , name:pencil, price  :   10, quantity : 50}";
		JSONAssert.assertEquals(expectedResponse,actualResponse,false);
	}
}
