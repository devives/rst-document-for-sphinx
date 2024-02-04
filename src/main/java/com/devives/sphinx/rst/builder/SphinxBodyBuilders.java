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

import com.devives.rst.builder.RstNodeBuilder;
import com.devives.rst.document.RstElement;
import com.devives.rst.document.RstNode;
import com.devives.rst.document.directive.Directive;
import com.devives.sphinx.rst.builder.directive.*;

import java.util.function.Consumer;

/**
 * Base class that every Rst builder extends. Basically capable of
 * appending stuff to a root {@link RstElement}.
 */
public interface SphinxBodyBuilders<
        PARENT extends RstNodeBuilder<?, ?, ?, ?>,
        CHILD extends RstElement,
        RESULT extends RstNode<CHILD>,
        SELF extends RstNodeBuilder<?, ?, ?, ?>>
        extends com.devives.rst.builder.BodyBuilders<PARENT, CHILD, RESULT, SELF>,
        DirectiveBuilders<PARENT, CHILD, RESULT, SELF> {

    /**
     * Creates a new {@link CodeBlockBuilder} instance and sets the language.
     *
     * @param language the code language for syntax highlighting
     * @return a new child builder instance
     */
    default CodeBlockBuilder<SELF> beginCodeBlock(String language) {
        return new CodeBlockBuilderImpl<SELF>(language).setParentBuilder((SELF) this);
    }

    /**
     * Creates a new {@link CodeBlockBuilder} instance.
     *
     * @return a new child builder instance
     */
    default CodeBlockBuilder<SELF> beginCodeBlock() {
        return beginCodeBlock(CodeBlockBuilder.LANGUAGE_UNKNOWN);
    }

    /**
     * Creates a new {@link CodeBlockBuilder} instance, and pass to the consumer.
     *
     * @param consumer consumer
     * @return this instance
     */
    default SELF codeBlock(Consumer<CodeBlockBuilder<SELF>> consumer) {
        CodeBlockBuilder<SELF> builder = beginCodeBlock();
        consumer.accept(builder);
        return builder.end();
    }

    /**
     * Creates a new `.. code-block::` {@link Directive} instance with passed language and text.
     *
     * @param language the code language for syntax highlighting
     * @param text     code sample
     * @return this instance
     */
    default SELF codeBlock(String language, String text) {
        CodeBlockBuilder<SELF> builder = beginCodeBlock(language);
        builder.text(text);
        return builder.end();
    }

    /**
     * Creates a new `.. code-block::` {@link  Directive} instance with passed text.
     *
     * @param text code sample
     * @return this instance
     */
    default SELF codeBlock(String text) {
        CodeBlockBuilder<SELF> builder = beginCodeBlock();
        builder.text(text);
        return builder.end();
    }


    /**
     * Creates a new {@link TocTreeBuilder} instance.
     *
     * @return a new child builder instance
     */
    default TocTreeBuilder<SELF> beginTocTree() {
        return new TocTreeBuilderImpl<SELF>().setParentBuilder((SELF) this);
    }

    /**
     * Creates a new {@link TocTreeBuilder} instance, and pass to the consumer.
     *
     * @param consumer consumer
     * @return this instance
     */
    default SELF tocTree(Consumer<TocTreeBuilder<SELF>> consumer) {
        TocTreeBuilder<SELF> builder = beginTocTree();
        consumer.accept(builder);
        return builder.end();
    }


    /**
     * Creates a new {@link IndexBuilder} instance.
     *
     * @return a new child builder instance
     */
    default IndexBuilder<SELF> beginIndex() {
        return new IndexBuilderImpl<SELF>().setParentBuilder((SELF) this);
    }

    /**
     * Creates a new {@link IndexBuilder} instance, and pass to the consumer.
     *
     * @param consumer consumer
     * @return this instance
     */
    default SELF index(Consumer<IndexBuilder<SELF>> consumer) {
        IndexBuilder<SELF> builder = beginIndex();
        consumer.accept(builder);
        return builder.end();
    }


}
