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
import com.devives.rst.builder.directive.DirectiveBuilder;
import com.devives.rst.builder.table.GridTableBuilder;
import com.devives.rst.document.RstElement;
import com.devives.rst.document.RstNode;
import com.devives.sphinx.rst.document.directive.Directives;

import java.util.function.Consumer;

public interface DirectiveBuilders<PARENT extends RstNodeBuilder<?, ?, ?, ?>,
        E extends RstElement,
        T extends RstNode<E>,
        SELF extends RstNodeBuilder<?, ?, ?, ?>>
        extends RstNodeBuilder<PARENT, E, T, SELF>,
        com.devives.rst.builder.directive.DirectiveBuilders<PARENT, E, T, SELF> {


    /**
     * Creates a new {@link GridTableBuilder} instance, and pass to the consumer.
     *
     * @param consumer consumer
     * @return this instance
     */
    default SELF seeAlso(Consumer<DirectiveBuilder<SELF>> consumer) {
        return directive(Directives.SeeAlso, consumer);
    }

    /**
     * Creates a new {@link GridTableBuilder} instance, and pass to the consumer.
     *
     * @param value text
     * @return this instance
     */
    default SELF seeAlso(String value) {
        return directive(Directives.SeeAlso, value);
    }

}
