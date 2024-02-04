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
package com.devives.sphinx.rst.document.directive;

import com.devives.rst.document.directive.Directive.Type;

/**
 * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html">Sphinx Directives</a>
 */
public abstract class Directives extends com.devives.rst.document.directive.Directives {

    /**
     * Table of contents.
     *
     * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#directive-toctree">toctree</a>
     */
    public static final Type TocTree = new Type("toctree");
    // Paragraph-level markup
    public static final Type SeeAlso = new Type("seealso");
    public static final Type Centered = new Type("centered");
    public static final Type Deprecated = new Type("deprecated");
    public static final Type HList = new Type("hlist");
    public static final Type VersionAdded = new Type("versionadded");
    public static final Type VersionChanged = new Type("versionchanged");
    // Showing code examples
    public static final Type Highlight = new Type("highlight");
    public static final Type CodeBlock = new Type("code-block");
    public static final Type SourceCode = new Type("sourcecode");
    public static final Type LiteralInclude = new Type("literalinclude");
    // Glossary
    public static final Type Glossary = new Type("glossary");
    // Meta-information markup
    public static final Type SectionAuthor = new Type("sectionauthor");
    public static final Type CodeAuthor = new Type("codeauthor");
    // Index-generating markup
    public static final Type Index = new Type("index");
    // Tables
    /**
     * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#directive-tabularcolumns">tabularcolumns</a>
     */
    public static final Type TabularColumns = new Type("tabularcolumns");
    // Including content based on tags.
    /*
     * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#including-content-based-on-tags">only</a>
     */
    public static final Type Only = new Type("only");
    // Grammar production displays.
    /**
     * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/directives.html#directive-productionlist">productionlist</a>
     */
    public static final Type ProductionList = new Type("productionlist");

}
