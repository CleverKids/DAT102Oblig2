package no.hvl.dat102.adt;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public abstract class MengdeADTTest {

	private Integer[] m1 = {1, 3, 5, 7, 9};
	private Integer[] m2 = {1, 3, 5, 8, 10};
	private Integer[] m3 = {1, 3, 5, 7, 9, 8, 10};
	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> begge;
	
	protected abstract MengdeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		mengde1 = reset();
		mengde2 = reset();
		begge = reset();
		
		for(Integer e: m1) {
			mengde1.leggTil(e);
		}
		
		for(Integer e: m2) {
			mengde2.leggTil(e);
		}
		
		for(Integer e: m3) {
			begge.leggTil(e);
		}
	}
	
	@Test
	public void funkerUnion() {
		
		try {
//			begge = ((TabellMengde) begge).trimmeTab(begge, 7);
			assertEquals(begge, mengde1.union(mengde2));
		} catch(EmptyCollectionException e){
			fail("Union feilet uventet " + e.getMessage());
		} catch(NullPointerException e) {
			fail("Union feilet uventet " + e.getMessage());
		}
	}
	
	
}
