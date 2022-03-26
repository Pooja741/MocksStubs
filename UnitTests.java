
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UnitTests{

	@Mock
	List list;

	@InjectMocks
	UnitTestingApplication unitTestingApplication;

	@Test
	void contextLoads() {
	}

	@Test
	void returnMultipleValues() {
		when(list.size()).thenReturn(2).thenReturn(5).thenReturn(10);
		assertEquals(2,list.size());
		assertEquals(5,list.size());
		assertEquals(10,list.size());
		assertEquals(10,list.size());
		assertEquals(10,list.size());
	}
	@Test
	void returnWithParam() {
		when(list.get(0)).thenReturn(2);
		assertEquals(2,list.get(0));
		assertEquals(null,list.get(4));
	}
	@Test
	void returnWithParams() {
		when(list.get(5)).thenReturn(true);
		assertEquals(true,list.get(5));
		assertEquals(null,list.get(8));
	}
	@Test
	void returnWithParamsWithGenericInt() {
		when(list.get(anyInt())).thenReturn(true);
		assertEquals(true,list.get(5));
		assertEquals(true,list.get(8));
	}

	@Test
	void verifyMethodCalls() {
		list.get(0);
		list.get(1);
		list.get(2);
		verify(list).get(0);
		verify(list,times(1)).get(0);
		verify(list,times(3)).get(anyInt());
		verify(list,atLeast(2)).get(anyInt());
		verify(list,atMost(3)).get(anyInt());
		verify(list,never()).get(4);
	}

	@Test
	void captureAndVerifyTheParameterPassedDuringMockMethodCall() {
		Float val = 123.44f;
		list.add(123.44f);
		ArgumentCaptor<Float> captor = ArgumentCaptor.forClass(Float.class);

		verify(list).add(captor.capture());

		assertEquals(val,captor.getValue());
	}
	@Test
	void captureAndVerifyMultipleParameters() {
		Double val = 123.44;
		Double val2 = 123.55;
		list.add(123.44);
		list.add(123.55);
		ArgumentCaptor<Float> captor = ArgumentCaptor.forClass(Float.class);

		verify(list,times(2)).add(captor.capture());

		List<Float> values = captor.getAllValues();
		assertEquals(val,values.get(0));
		assertEquals(val2,values.get(1));
	}
}
