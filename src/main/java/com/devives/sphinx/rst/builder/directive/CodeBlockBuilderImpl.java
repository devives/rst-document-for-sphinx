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
import com.devives.rst.builder.directive.CompoundDirectiveBuilderAbst;
import com.devives.rst.document.directive.Directive;
import com.devives.sphinx.rst.document.directive.Directives;

import java.util.Collections;


public class CodeBlockBuilderImpl<PARENT extends RstNodeBuilder<?, ?, ?, ?>>
        extends CompoundDirectiveBuilderAbst<PARENT, Directive, CodeBlockBuilder<PARENT>>
        implements CodeBlockBuilder<PARENT> {

    public CodeBlockBuilderImpl() {
        this(LANGUAGE_UNKNOWN);
    }

    public CodeBlockBuilderImpl(String language) {
        super(Directives.CodeBlock);
        getRstElement().getArguments().add(Rst.elements().text(language));
    }

    public CodeBlockBuilder<PARENT> setLineNos(boolean lineNos) {
        if (lineNos)
            getRstElement().getOptions().put("linenos", null);
        else
            getRstElement().getOptions().remove("linenos");
        return this;
    }

    public CodeBlockBuilder<PARENT> setForce(boolean force) {
        if (force)
            getRstElement().getOptions().put("force", null);
        else
            getRstElement().getOptions().remove("force");
        return this;
    }

    public CodeBlockBuilder<PARENT> setLineNoStart(Integer lineNoStart) {
        getRstElement().getOptions().put("linenostart", lineNoStart);
        return this;
    }

    public CodeBlockBuilder<PARENT> setEmphasizeLines(Object[] emphasizeLines) {
        getRstElement().getOptions().put("emphasizelines", emphasizeLines);
        return this;
    }

    public CodeBlockBuilder<PARENT> setName(String name) {
        getRstElement().getOptions().put("name", name);
        return this;
    }

    public CodeBlockBuilder<PARENT> setCaption(String caption) {
        getRstElement().getOptions().put("caption", caption);
        return this;
    }

    public CodeBlockBuilder<PARENT> setClass(String clazz) {
        getRstElement().getOptions().put("class", clazz);
        return this;
    }

    public CodeBlockBuilder setDedent(Integer dedent) {
        getRstElement().getOptions().put("dedent", dedent);
        return this;
    }

    public CodeBlockBuilder<PARENT> setLanguage(String language) {
        getRstElement().setArguments(Collections.singletonList(Rst.elements().text(language)));
        return this;
    }

    //
//    @Override
//    public QuoteBuilder beginQuote() {
//        return new QuoteBuilder(this, 0);
//    }
}
