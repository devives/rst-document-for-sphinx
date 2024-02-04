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

import com.devives.rst.builder.*;

public interface SphinxRstBuilderFactory {

    /**
     * Return the new instance of {@link RstDocumentBuilder}.
     *
     * @param <PARENT> Class of parent builder.
     * @return {@link RstDocumentBuilder} instance
     */
    default <PARENT extends RstNodeBuilder<?, ?, ?, ?>> SphinxDocumentBuilder<PARENT> document() {
        return new SphinxDocumentBuilderImpl<PARENT>();
    }

    /**
     * Return the new instance of {@link ParagraphBuilder}.
     *
     * @param <PARENT> Class of parent builder.
     * @return {@link ParagraphBuilder} instance
     */
    default <PARENT extends RstNodeBuilder<?, ?, ?, ?>> ParagraphBuilder<PARENT> paragraph() {
        return new ParagraphBuilderImpl<PARENT>();
    }

    /**
     * Return the new instance of {@link SectionBuilder}.
     *
     * @param <PARENT> Class of parent builder.
     * @return {@link SectionBuilder} instance
     */
    default <PARENT extends RstNodeBuilder<?, ?, ?, ?>> SectionBuilder<PARENT> section() {
        return new SectionBuilderImpl<PARENT>();
    }
}
