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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TocTreeBuilderTest extends AbstractTest {

    @Test
    public void serialize_noOptionsNoValue() throws Exception {
        String result = new TocTreeBuilderImpl<>()
                .build()
                .serialize();
        System.out.print(result);
        String expected = ".. toctree::" + NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_noOptionsValue() throws Exception {
        String result = new TocTreeBuilderImpl<>()
                .paragraph(pb -> pb.text("Some" + NL + "Some2"))
                .build()
                .serialize();
        System.out.print(result);
        String expected = ".. toctree::" + NL +
                NL +
                AbstractTest.TAB + "Some" + NL +
                AbstractTest.TAB + "Some2" + NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_AllOptionsNoValue() throws Exception {
        String result = new TocTreeBuilderImpl<>()
                .setName("Some name")
                .setCaption("Some caption")
                .setGlob(true)
                .setHidden(true)
                .setIncludeHidden(true)
                .setMaxDepth(2)
                .setNumbered(true)
                .setReversed(true)
                .setTitlesOnly(true)
                .build()
                .serialize();
        System.out.print(result);
        String expected = ".. toctree::" + NL +
                "   :name: Some name" + NL +
                "   :caption: Some caption" + NL +
                "   :glob:" + NL +
                "   :hidden:" + NL +
                "   :includehidden:" + NL +
                "   :maxdepth: 2" + NL +
                "   :numbered:" + NL +
                "   :reversed:" + NL +
                "   :titlesonly:" + NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_AllOptionsValue() throws Exception {
        String result = new TocTreeBuilderImpl<>()
                .setName("Some name")
                .setCaption("Some caption")
                .setGlob(true)
                .setHidden(true)
                .setIncludeHidden(true)
                .setMaxDepth(2)
                .setNumbered(true)
                .setReversed(true)
                .setTitlesOnly(true)
                .paragraph(pb -> pb.text("Some").lineBreak().text("Some2"))
                .build().serialize();
        System.out.print(result);
        String expected = ".. toctree::" + NL +
                "   :name: Some name" + NL +
                "   :caption: Some caption" + NL +
                "   :glob:" + NL +
                "   :hidden:" + NL +
                "   :includehidden:" + NL +
                "   :maxdepth: 2" + NL +
                "   :numbered:" + NL +
                "   :reversed:" + NL +
                "   :titlesonly:" + NL +
                NL +
                AbstractTest.TAB + "Some" + NL +
                AbstractTest.TAB + "Some2" + NL;
        Assertions.assertEquals(expected, result);
    }


}
