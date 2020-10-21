package questao02;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class questao02 {

	@Test // 1 -> 4
	void MsgNull() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = null;
		
		assertEquals("INVALID", ac.cifrar(msg));
	}
	
	@Test // 1 -> 2 -> 4
	void MsgSize0() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		
		assertEquals(0, msg.size());
		assertEquals("INVALID", ac.cifrar(msg));
	}
	
	@Test // 1 -> 2 -> 3 -> 4
	void MsgStop() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("STOP");
		
		assertEquals("INVALID", ac.cifrar(msg));
	}
	
	@Test // 1 -> 2 -> 3 -> 5 -> 6 -> 7
	void CodersTrue() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("FILLER");
		
		when(c1.m1(msg)).thenReturn(true);
		when(c2.m2(msg)).thenReturn(true);
		
		assertEquals("C1-C2", ac.cifrar(msg));
	}
	
	/**
	 * 1 -> 2 -> 3 -> 5 -> 8 -> 9 -> 10 ->
	 * 8 -> 9 -> 10 -> 11 -> 12
	 */
	@Test
	void C1False() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("HI");
		msg.add("HI");
		
		when(c1.m1(msg)).thenReturn(false);
		
		assertEquals("2 OR MORE HIs", ac.cifrar(msg));
	}
	
	/**
	 * 1 -> 2 -> 3 -> 5 -> 6 ->  8 -> 9 -> 10 ->
	 * 8 -> 9 -> 10 -> 8 -> 9 -> 11 -> 12
	 */
	@Test
	void C2False() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("HI");
		msg.add("HI");
		msg.add("NOT HI");
		
		when(c1.m1(msg)).thenReturn(true);
		when(c2.m2(msg)).thenReturn(false);
		
		assertEquals("2 OR MORE HIs", ac.cifrar(msg));
	}
	
	/**
	 * 1 -> 2 -> 3 -> 5 -> 6 -> 8 -> 9 -> 10 ->
	 * 11 -> 13 -> 17
	 */
	@Test
	void NumLessThan1() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("HI");
		when(c3.m3()).thenReturn(0);
		
		when(c1.m1(msg)).thenReturn(true);
		when(c2.m2(msg)).thenReturn(false);
		
		assertEquals("HI", ac.cifrar(msg));
	}
	
	/**
	 * 1 -> 2 -> 3 -> 5 -> 6 -> 8 -> 9 -> 10 ->
	 * 11 -> 13 -> 14 -> 15 -> 14 -> 15 -> 16
	 */
	@Test
	void NumMoreThan1() {
		Coder1 c1 = mock(Coder1.class);
		Coder2 c2 = mock(Coder2.class);
		Coder3 c3 = mock(Coder3.class);
		AClass ac = new AClass(c1, c2, c3);
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("HI");
		when(c3.m3()).thenReturn(2);
		
		when(c1.m1(msg)).thenReturn(true);
		when(c2.m2(msg)).thenReturn(false);
		
		assertEquals("-HI-HI", ac.cifrar(msg));
	}

}
