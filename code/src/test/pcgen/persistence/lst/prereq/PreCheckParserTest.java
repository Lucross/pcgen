/*
 * PreCheckParserTest.java
 *
 * Copyright 2003 (C) Chris Ward <frugal@purplewombat.co.uk>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.       See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *
 *
 *
 *
 */
package pcgen.persistence.lst.prereq;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pcgen.EnUsLocaleDependentTestCase;
import pcgen.core.prereq.Prerequisite;
import plugin.pretokens.parser.PreCheckParser;

/**
 */
@SuppressWarnings("nls")
public class PreCheckParserTest extends EnUsLocaleDependentTestCase
{
	/**
	 * @throws Exception
	 */
	@Test
	public void testBaseFort4Will7() throws Exception
	{
		PreCheckParser parser = new PreCheckParser();

		Prerequisite prereq =
				parser.parse("CHECKBASE", "1,Fortitude=4,Will=7", false, false);

		assertEquals(
			"<prereq operator=\"GTEQ\" operand=\"1\" >\n"
				+ "<prereq kind=\"checkbase\" count-multiples=\"true\" key=\"Fortitude\" operator=\"GTEQ\" operand=\"4\" >\n"
				+ "</prereq>\n"
				+ "<prereq kind=\"checkbase\" count-multiples=\"true\" key=\"Will\" operator=\"GTEQ\" operand=\"7\" >\n"
				+ "</prereq>\n" + "</prereq>\n", prereq.toString());
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testBaseWill7() throws Exception
	{
		PreCheckParser parser = new PreCheckParser();

		Prerequisite prereq =
				parser.parse("CHECKBASE", "1,Will=7", false, false);

		assertEquals(
			"<prereq kind=\"checkbase\" key=\"Will\" operator=\"GTEQ\" operand=\"7\" >\n"
				+ "</prereq>\n", prereq.toString());
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testFort3() throws Exception
	{
		PreCheckParser parser = new PreCheckParser();

		Prerequisite prereq =
				parser.parse("CHECK", "1,Fortitude=3", false, false);

		assertEquals(
			"<prereq kind=\"check\" key=\"Fortitude\" operator=\"GTEQ\" operand=\"3\" >\n"
				+ "</prereq>\n", prereq.toString());
	}
}
