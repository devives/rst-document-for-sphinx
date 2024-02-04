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

import com.devives.rst.builder.BodyBuilders;
import com.devives.rst.builder.RstNodeBuilder;
import com.devives.rst.document.RstElement;
import com.devives.rst.document.directive.Directive;


public interface TocTreeBuilder<PARENT extends RstNodeBuilder<?, ?, ?, ?>>
        extends BodyBuilders<PARENT, RstElement, Directive, TocTreeBuilder<PARENT>> {

    TocTreeBuilder<PARENT> setName(String name);

    TocTreeBuilder<PARENT> setCaption(String caption);

    TocTreeBuilder<PARENT> setMaxDepth(Integer maxDepth);

    TocTreeBuilder<PARENT> setNumbered(Boolean numbered);

    TocTreeBuilder<PARENT> setTitlesOnly(Boolean titlesOnly);

    TocTreeBuilder<PARENT> setGlob(Boolean glob);

    TocTreeBuilder<PARENT> setReversed(Boolean reversed);

    TocTreeBuilder<PARENT> setHidden(Boolean hidden);

    TocTreeBuilder<PARENT> setIncludeHidden(Boolean includeHidden);

}
