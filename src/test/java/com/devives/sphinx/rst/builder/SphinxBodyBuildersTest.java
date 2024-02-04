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
package com.devives.sphinx.rst.builder;

import com.devives.rst.document.RstDocument;
import com.devives.rst.document.directive.Directive;
import com.devives.sphinx.rst.AbstractTest;
import com.devives.sphinx.rst.Rst4Sphinx;
import com.devives.sphinx.rst.builder.directive.CodeBlockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SphinxBodyBuildersTest extends AbstractTest {


    @Test
    public void beginCodeBlock__instanceOfCodeBlockBuilder() throws Exception {
        Assertions.assertInstanceOf(CodeBlockBuilder.class, Rst4Sphinx.builders().document().beginCodeBlock());
    }

    @Test
    public void blockQuote__instanceOfCodeBlock() throws Exception {
        RstDocument rstDocument = Rst4Sphinx.builders().document().codeBlock(b -> b.toString()).build();
        Assertions.assertInstanceOf(Directive.class, rstDocument.getChildren().get(0));
    }

    @Test
    public void beginCodeBlock__expected() throws Exception {
        String result = Rst4Sphinx.builders().document()
                .codeBlock(JAVA_CODE_SAMPLE)
                .paragraph(paragraphBuilder -> paragraphBuilder.text("Code sample."))
                .beginCodeBlock("java")
                .text(JAVA_CODE_SAMPLE)
                .end()
                .build().serialize();
        System.out.print(result);
        String expected = EMPTY +
                ".. code-block::" + NL +
                NL +
                "   for (int i = 0; i < 10; i++) {" + NL +
                "       System.out.println(i);" + NL +
                "   }" + NL +
                NL +
                "Code sample." + NL +
                NL +
                ".. code-block:: java" + NL +
                NL +
                "   for (int i = 0; i < 10; i++) {" + NL +
                "       System.out.println(i);" + NL +
                "   }" + NL;
        Assertions.assertEquals(expected, result);
    }

}
