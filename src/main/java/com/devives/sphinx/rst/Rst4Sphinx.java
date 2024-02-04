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
package com.devives.sphinx.rst;

import com.devives.rst.builder.RstBuilderFactory;
import com.devives.rst.document.RstElementFactory;
import com.devives.sphinx.rst.builder.SphinxRstBuilderFactory;
import com.devives.sphinx.rst.builder.SphinxRstBuilderFactoryImpl;
import com.devives.sphinx.rst.document.SphinxRstElementFactory;
import com.devives.sphinx.rst.document.SphinxRstElementFactoryImpl;

import java.util.Objects;

/**
 * This class is a static entrypoint to the RST document building for Sphinx.
 *
 * @see <a href="https://www.sphinx-doc.org/en/master/usage/restructuredtext/basics.html">Sphinx reStructuredText Primer</a>
 */
public final class Rst4Sphinx {

    private Rst4Sphinx() {
    }

    private static SphinxRstElementFactory ELEMENTS_FACTORY = new SphinxRstElementFactoryImpl();
    private static SphinxRstBuilderFactory BUILDERS_FACTORY = new SphinxRstBuilderFactoryImpl();

    /**
     * Sets the instance of Rst-factory, witch will be used by RstDocumentBuilder instances.
     *
     * @param factory Instance of Rst-factory.
     */
    public static void setElementFactory(SphinxRstElementFactory factory) {
        ELEMENTS_FACTORY = Objects.requireNonNull(factory, "factory");
    }

    /**
     * Sets the instance of RstBuilder factory.
     *
     * @param factory Instance of Rst-factory.
     */
    public static void setBuilderFactory(SphinxRstBuilderFactory factory) {
        BUILDERS_FACTORY = Objects.requireNonNull(factory, "factory");
    }

    /**
     * Return the instance of {@link RstElementFactory}, witch will be used by SphinxDocumentBuilder instances.
     *
     * @return {@link RstElementFactory} instance.
     */
    public static SphinxRstElementFactory elements() {
        return ELEMENTS_FACTORY;
    }

    /**
     * Return the instance of {@link  RstBuilderFactory}.
     *
     * @return {@link  RstBuilderFactory} instance.
     */
    public static SphinxRstBuilderFactory builders() {
        return BUILDERS_FACTORY;
    }

}
