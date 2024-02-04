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

import com.devives.rst.Rst;
import com.devives.rst.builder.RstNodeBuilder;
import com.devives.rst.builder.RstNodeBuilderAbst;
import com.devives.rst.document.RstDocument;
import com.devives.rst.document.RstElement;

/**
 * Base class that every Rst builder extends. Basically capable of
 * appending stuff to a root {@link RstElement}.
 */
public class SphinxDocumentBuilderImpl<PARENT extends RstNodeBuilder<?, ?, ?, ?>>
        extends RstNodeBuilderAbst<PARENT, RstElement, RstDocument, SphinxDocumentBuilder<PARENT>>
        implements SphinxDocumentBuilder<PARENT> {

    @Override
    protected RstDocument createRstElement() {
        return Rst.elements().document();
    }


}