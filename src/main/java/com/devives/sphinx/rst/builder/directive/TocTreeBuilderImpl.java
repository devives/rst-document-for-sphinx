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

import com.devives.rst.Rst;
import com.devives.rst.builder.RstNodeBuilder;
import com.devives.rst.builder.RstNodeBuilderAbst;
import com.devives.rst.document.RstElement;
import com.devives.rst.document.directive.Directive;
import com.devives.sphinx.rst.document.directive.Directives;


public class TocTreeBuilderImpl<PARENT extends RstNodeBuilder<?, ?, ?, ?>>
        extends RstNodeBuilderAbst<PARENT, RstElement, Directive, TocTreeBuilder<PARENT>>
        implements TocTreeBuilder<PARENT> {

    @Override
    protected Directive createRstElement() {
        return Rst.elements().directive(Directives.TocTree);
    }

    public TocTreeBuilder<PARENT> setName(String name) {
        getRstElement().getOptions().put("name", name);
        return this;
    }

    public TocTreeBuilder<PARENT> setCaption(String caption) {
        getRstElement().getOptions().put("caption", caption);
        return this;
    }

    public TocTreeBuilder<PARENT> setMaxDepth(Integer maxDepth) {
        getRstElement().getOptions().put("maxdepth", maxDepth);
        return this;
    }

    public TocTreeBuilder<PARENT> setNumbered(Boolean numbered) {
        if (numbered)
            getRstElement().getOptions().put("numbered", null);
        else
            getRstElement().getOptions().remove("numbered");
        return this;
    }

    public TocTreeBuilder<PARENT> setTitlesOnly(Boolean titlesOnly) {
        if (titlesOnly)
            getRstElement().getOptions().put("titlesonly", null);
        else
            getRstElement().getOptions().remove("titlesonly");
        return this;
    }

    public TocTreeBuilder<PARENT> setGlob(Boolean glob) {
        if (glob)
            getRstElement().getOptions().put("glob", null);
        else
            getRstElement().getOptions().remove("glob");
        return this;
    }

    public TocTreeBuilder<PARENT> setReversed(Boolean reversed) {
        if (reversed)
            getRstElement().getOptions().put("reversed", null);
        else
            getRstElement().getOptions().remove("reversed");
        return this;
    }

    public TocTreeBuilder<PARENT> setHidden(Boolean hidden) {
        if (hidden)
            getRstElement().getOptions().put("hidden", null);
        else
            getRstElement().getOptions().remove("hidden");
        return this;
    }

    public TocTreeBuilder<PARENT> setIncludeHidden(Boolean includeHidden) {
        if (includeHidden)
            getRstElement().getOptions().put("includehidden", null);
        else
            getRstElement().getOptions().remove("includehidden");
        return this;
    }

}
