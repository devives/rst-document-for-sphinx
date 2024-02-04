/**
 * RST Document and Builder library for Sphinx.
 * Copyright (C) 2023-2024 Vladimir Ivanov <ivvlev@devives.com>.
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.devives.sphinx.rst.builder.directive;

import com.devives.sphinx.rst.AbstractTest;
import com.devives.sphinx.rst.Rst4Sphinx;
import com.devives.sphinx.rst.document.directive.Directives;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeeAlsoBuilderTest extends AbstractTest {

    @Test
    public void serialize_SingleLine() throws Exception {
        String result = Rst4Sphinx.builders().document().seeAlso("SomeClass").build().serialize();
        System.out.print(result);
        String expected = ".. seealso:: SomeClass" + NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_MultiLine() throws Exception {
        String result = Rst4Sphinx.builders().document().directive(Directives.SeeAlso, directiveBuilder ->
                        directiveBuilder
                                .lineBlock(lineBlockBuilder ->
                                        lineBlockBuilder
                                                .item("Some")
                                                .item("Some2")
                                )
                )
                .build().serialize();
        System.out.print(result);
        String expected = ".. seealso::" + NL +
                NL +
                AbstractTest.TAB + "| Some" + NL +
                AbstractTest.TAB + "| Some2" + NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_OneBehindAnother() throws Exception {
        String result = Rst4Sphinx.builders().document()
                .directive(Directives.SeeAlso, directiveBuilder -> {
                    directiveBuilder.paragraph("SomeClass");
                })
                .directive(Directives.SeeAlso, directiveBuilder -> {
                    directiveBuilder.paragraph("SomeClass");
                })
                .build().serialize();
        System.out.print(result);
        String expected = ".. seealso::" + NL +
                NL +
                AbstractTest.TAB + "SomeClass" + NL +
                NL +
                ".. seealso::" + NL +
                NL +
                AbstractTest.TAB + "SomeClass" + NL;
        Assertions.assertEquals(expected, result);
    }

}
