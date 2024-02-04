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


import com.devives.rst.builder.RstNodeBuilder;
import com.devives.rst.builder.inline.InlineBuilders;
import com.devives.rst.document.RstElement;
import com.devives.rst.document.directive.Directive;

/**
 * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#directive-code-block">Sphinx Directives: code-block</a>
 */
public interface CodeBlockBuilder<PARENT extends RstNodeBuilder<?, ?, ?, ?>>
        extends InlineBuilders<PARENT, RstElement, Directive, CodeBlockBuilder<PARENT>> {

    String LANGUAGE_UNKNOWN = "";
    String LANGUAGE_JAVA = "java";
    String LANGUAGE_XML = "xml";
    String LANGUAGE_JSON = "json";
    String LANGUAGE_SCALA = "scala";
    String LANGUAGE_RST = "rst";

    /**
     * The language of code sample.
     *
     * @param language value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setLanguage(String language);

    /**
     * Enable to generate line numbers for the code block.
     *
     * @param lineNos value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setLineNos(boolean lineNos);

    /**
     * If given, minor errors on highlighting are ignored.
     *
     * @param force value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setForce(boolean force);

    /**
     * Set the first line number of the code block. If present, linenos option is also automatically activated.
     *
     * @param lineNoStart value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setLineNoStart(Integer lineNoStart);

    /**
     * Emphasize particular lines of the code block.
     *
     * @param emphasizeLines value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setEmphasizeLines(Object[] emphasizeLines);

    /**
     * Define implicit target name that can be referenced by using <a href="https://www.sphinx-doc.org/en/master/usage/referencing.html#role-ref">ref</a>.
     *
     * @param name value
     * @return this instance
     * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#directive-option-code-block-name">name</a>
     */
    CodeBlockBuilder<PARENT> setName(String name);

    /**
     * Set a caption to the code block.
     *
     * @param caption value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setCaption(String caption);

    /**
     * The class name of the graph.
     *
     * @param clazz value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setClass(String clazz);

    /**
     * Strip indentation characters from the code block. When number given, leading N characters are removed.
     * When no argument given, leading spaces are removed via <tt>textwrap.dedent()</tt>.
     *
     * @param dedent value
     * @return this instance
     */
    CodeBlockBuilder<PARENT> setDedent(Integer dedent);

}
