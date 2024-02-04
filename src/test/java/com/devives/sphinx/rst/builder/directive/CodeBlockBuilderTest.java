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

import com.devives.rst.util.StringUtils;
import com.devives.sphinx.rst.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodeBlockBuilderTest extends AbstractTest {

    @Test
    public void serialize_noOptionsNoValue() throws Exception {
        String result = new CodeBlockBuilderImpl<>().build().serialize();
        System.out.print(result);
        String expected = ".. code-block::" + AbstractTest.NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_noOptionsValue() throws Exception {
        String result = new CodeBlockBuilderImpl<>()
                .setLanguage(CodeBlockBuilderImpl.LANGUAGE_JAVA)
                .text(AbstractTest.JAVA_CODE_SAMPLE)
                .build()
                .serialize();
        System.out.print(result);
        String expected = ".. code-block:: java" + AbstractTest.NL +
                AbstractTest.NL +
                StringUtils.shiftLeftEdge(AbstractTest.JAVA_CODE_SAMPLE, 3) + AbstractTest.NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_AllOptionsNoValue() throws Exception {
        String result = new CodeBlockBuilderImpl<>()
                .setName("Some name")
                .setCaption("Some caption")
                .setClass("Some class")
                .setDedent(4)
                .setForce(true)
                .setEmphasizeLines(new Object[]{1, 2, "5-7", 10})
                .setLineNos(true)
                .setLineNoStart(10)
                .build()
                .serialize();
        System.out.print(result);
        String expected = ".. code-block::" + AbstractTest.NL +
                "   :name: Some name" + AbstractTest.NL +
                "   :caption: Some caption" + AbstractTest.NL +
                "   :class: Some class" + AbstractTest.NL +
                "   :dedent: 4" + AbstractTest.NL +
                "   :force:" + AbstractTest.NL +
                "   :emphasizelines: 1,2,5-7,10" + AbstractTest.NL +
                "   :linenos:" + AbstractTest.NL +
                "   :linenostart: 10" + AbstractTest.NL;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void serialize_AllOptionsValue() throws Exception {
        String result = new CodeBlockBuilderImpl<>("java")
                .setName("Some name")
                .setCaption("Some caption")
                .setClass("Some class")
                .setDedent(4)
                .setForce(true)
                .setEmphasizeLines(new Object[]{1, 2, "5-7", 10})
                .setLineNos(true)
                .setLineNoStart(10)
                .text(AbstractTest.JAVA_CODE_SAMPLE)
                .build().serialize();
        System.out.print(result);
        String expected = ".. code-block:: java" + AbstractTest.NL +
                "   :name: Some name" + AbstractTest.NL +
                "   :caption: Some caption" + AbstractTest.NL +
                "   :class: Some class" + AbstractTest.NL +
                "   :dedent: 4" + AbstractTest.NL +
                "   :force:" + AbstractTest.NL +
                "   :emphasizelines: 1,2,5-7,10" + AbstractTest.NL +
                "   :linenos:" + AbstractTest.NL +
                "   :linenostart: 10" + AbstractTest.NL +
                AbstractTest.NL +
                StringUtils.shiftLeftEdge(AbstractTest.JAVA_CODE_SAMPLE, 3) + AbstractTest.NL;
        Assertions.assertEquals(expected, result);
    }


}
