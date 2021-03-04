package no.hvl.dat102.adt;

import org.junit.jupiter.api.BeforeEach;
import no.hvl.dat102.mengde.adt.MengdeADT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MengdeADTTest {
	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> unionMengde;
	private MengdeADT<Integer> snittMengde;
	private MengdeADT<Integer> diffMengde;
	private MengdeADT<Integer> fasit;

	protected abstract MengdeADT<Integer> reset();

	@BeforeEach
	public void setup() {
		mengde1 = reset();
		mengde2 = reset();
		unionMengde = reset();
		snittMengde = reset();
		diffMengde = reset();
		fasit = reset();
	}

	@Test
	public void funkerUnionFelles() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 1, 3, 5, 8, 10 };
		Integer[] unionFasit = { 1, 3, 5, 7, 9, 8, 10 };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}

		for (Integer e : m2) {
			mengde2.leggTil(e);
		}

		for (Integer e : unionFasit) {
			fasit.leggTil(e);
		}
		unionMengde = mengde1.union(mengde2);
		
		assertEquals(fasit, unionMengde);
	}
	
	@Test
	public void funkerUnionDisjunkte() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 2, 4, 6, 8, 10 };
		Integer[] unionFasit = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}

		for (Integer e : m2) {
			mengde2.leggTil(e);
		}

		for (Integer e : unionFasit) {
			fasit.leggTil(e);
		}
		unionMengde = mengde1.union(mengde2);
		
		assertEquals(fasit, unionMengde);
	}

	@Test
	public void funkerSnittFelles() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 1, 3, 5, 8, 10 };
		Integer[] snittFasit = { 1, 3, 5 };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}
		
		for (Integer e : m2) {
			mengde2.leggTil(e);
		}
		for (Integer e : snittFasit) {
			fasit.leggTil(e);
		}
		snittMengde = mengde1.snitt(mengde2);
		
		assertEquals(fasit, snittMengde);
	}
	
	@Test
	public void funkerSnittDisjunkte() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 2, 4, 6, 8, 10 };
		Integer[] snittFasit = {  };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}
		
		for (Integer e : m2) {
			mengde2.leggTil(e);
		}
		for (Integer e : snittFasit) {
			fasit.leggTil(e);
		}
		snittMengde = mengde1.snitt(mengde2);
		
		assertEquals(fasit, snittMengde);
	}

	@Test
	public void funkerDifferensFelles() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 1, 3, 5, 8, 10 };
		Integer[] diffFasit = { 7, 9 };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}

		for (Integer e : m2) {
			mengde2.leggTil(e);
		}
		for (Integer e : diffFasit) {
			fasit.leggTil(e);
		}
		diffMengde = mengde1.differens(mengde2);
		
		assertEquals(fasit, diffMengde);
	}
	
	@Test
	public void funkerDifferensDisjunkte() {
		Integer[] m1 = { 1, 3, 5, 7, 9 };
		Integer[] m2 = { 2, 4, 6, 8, 10 };
		Integer[] diffFasit = { 1, 3, 5, 7, 9 };
		for (Integer e : m1) {
			mengde1.leggTil(e);
		}

		for (Integer e : m2) {
			mengde2.leggTil(e);
		}
		for (Integer e : diffFasit) {
			fasit.leggTil(e);
		}
		diffMengde = mengde1.differens(mengde2);
		
		assertEquals(fasit, diffMengde);
	}
}
