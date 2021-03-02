package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import no.hvl.dat102.mengde.adt.MengdeADT;


public abstract class MengdeADTTest {

	private Integer[] m1 = { 1, 3, 5, 7, 9 };
	private Integer[] m2 = { 1, 3, 5, 8, 10 };
	private Integer[] m3 = { 1, 3, 5, 7, 9, 8, 10 };
	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> unionMengde;
	private MengdeADT<Integer> snittMengde;
	private MengdeADT<Integer> diffMengde;

	protected abstract MengdeADT<Integer> reset();

	@BeforeEach
	public void setup() {
		mengde1 = reset();
		mengde2 = reset();
		unionMengde = reset();
		snittMengde = reset();
		diffMengde = reset();

		mengde1.leggTil(1);
		mengde1.leggTil(3);
		mengde1.leggTil(5);
		mengde1.leggTil(7);
		mengde1.leggTil(9);
		mengde2.leggTil(1);
		mengde2.leggTil(3);
		mengde2.leggTil(5);
		mengde2.leggTil(8);
		mengde2.leggTil(10);
		unionMengde.leggTil(1);
		unionMengde.leggTil(3);
		unionMengde.leggTil(5);
		unionMengde.leggTil(7);
		unionMengde.leggTil(9);
		unionMengde.leggTil(8);
		unionMengde.leggTil(10);
		snittMengde.leggTil(1);
		snittMengde.leggTil(3);
		snittMengde.leggTil(5);
		diffMengde.leggTil(7);
		diffMengde.leggTil(9);
	}

	@Test
	public void funkerUnion() {
//		for(Integer e: m1) {
//			mengde1.leggTil(e);
//		}
//		
//		for(Integer e: m2) {
//			mengde2.leggTil(e);
//		}
//		
//		for(Integer e: m3) {
//			begge.leggTil(e);
//		}

//		TabellMengde testing = (TabellMengde) mengde1.union(mengde2);
//		System.out.println(testing.toString());
		assertEquals(unionMengde, mengde1.union(mengde2));
//			assertTrue(begge.equals(mengde1.union(mengde2)));

	}
	
	@Test
	public void funkerSnitt() {
		System.out.println(mengde1 == null);
		System.out.println(mengde2 == null);
		System.out.println(mengde1.snitt(mengde2) == null);
		assertEquals(snittMengde, mengde1.snitt(mengde2));
	}
	
	@Test
	public void funkerDifferens() {
		assertEquals(diffMengde, mengde1.differens(mengde2));
	}
}
