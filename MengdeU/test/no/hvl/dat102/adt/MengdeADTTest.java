package no.hvl.dat102.adt;

import org.junit.jupiter.api.BeforeEach;
import no.hvl.dat102.mengde.adt.MengdeADT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

		for (Integer e : m1) {
			mengde1.leggTil(e);
		}

		for (Integer e : m2) {
			mengde2.leggTil(e);
		}

		for (Integer e : m3) {
			unionMengde.leggTil(e);
		}

		snittMengde.leggTil(1);
		snittMengde.leggTil(3);
		snittMengde.leggTil(5);
		diffMengde.leggTil(7);
		diffMengde.leggTil(9);
	}

	@Test
	public void funkerUnion() {
		assertEquals(unionMengde, mengde1.union(mengde2));
	}

	@Test
	public void funkerSnitt() {
		assertEquals(snittMengde, mengde1.snitt(mengde2));
	}

	@Test
	public void funkerDifferens() {
		assertEquals(diffMengde, mengde1.differens(mengde2));
	}
}
