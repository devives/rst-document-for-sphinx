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

import com.devives.rst.Rst;
import com.devives.rst.document.RstDocument;
import com.devives.rst.document.directive.Directives;
import com.devives.rst.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ReadMeGenerator implements Constants {

    private final Path rootPath = Paths.get("").toAbsolutePath().endsWith("RstProjectGroup")
            ? Paths.get("rst-document-for-sphinx").toAbsolutePath()
            : Paths.get("").toAbsolutePath();
    private final Path resultPath = rootPath.resolve("README.rst");
    
    public static void main(String[] args) throws IOException {
        new ReadMeGenerator().run();
    }

    private void run() throws IOException {
        RstDocument document = Rst.builders().document()
                .title("ReStructuredText Document & Builder for Sphinx", true)
                .paragraph(p -> p
                        .text("This project is the library which extends ")
                        .link("https://github.com/devives/rst-document", "ReStructuredText Document and Builder library")
                        .text("."))
                .paragraph("The library is part of the project `RstDoclet for JavaDoc Tool, generating reStructuredText for Sphinx <https://github.com/devives/rst-doclet>`_.")
                .beginDirective(Directives.Contents).setArguments("Overview").options(opts -> opts.item("depth", 2))
                .end()
                .subTitle("Quick Start")
                .numberedList(list -> list
                        .item(itm -> itm
                                .paragraph(p -> p.text("Add ").literal("mavencentral()").text(" repository to your root ").literal("build.gradle").text(":"))
                                .code("gradle", "repositories {\n" +
                                        "    mavenCentral()\n" +
                                        "}"))
                        .item(itm -> itm
                                .paragraph("Add library to dependencies:")
                                .code("gradle", "dependencies {\n" +
                                        "    implementation 'com.devives:devive-rst-doc4sphinx:0.2.0'\n" +
                                        "}"))
                )
                .subTitle("Sample code")
                .code("java", "private String codeSample() {\n" +
                        "    return Rst4Sphinx.builders().document()\n" +
                        "        .title(\"Document title\", true)\n" +
                        "        .paragraph(\"Simple text without any emphasis or enhancements.\")\n" +
                        "        .subTitle(\"Section title\")\n" +
                        "        .beginParagraph().text(\"Text can contains emphasis like \").bold(\"bold\")\n" +
                        "        .text(\" or \").italic(\"italic\").text(\" text.\").end()\n" +
                        "        .build()\n" +
                        "        .serialize();\n" +
                        "}\n")
                .paragraph("will return")
                .literalBlock(codeSample())
                .subTitle("License")
                .paragraph(p -> p.text("The code of project distributed under the GNU General Public License version 2 or \n" +
                        "any later version. The source code is available on ").link("https://github.com/devives/rst-doc4sphinx", "GitHub").text("."))
                .subTitle("Links")
                .beginBulletList()
                .item(itm -> itm.paragraph(p -> p.link("https://www.sphinx-doc.org/en/master/usage/restructuredtext/index.html", "Documentation » Using Sphinx » reStructuredText")))
                .end()
                .directive(Directives.Footer, a -> a.paragraph(p -> p
                        .text("This document generated using ")
                        .link("https://github.com/devives/rst-document-for-sphinx/blob/main/src/test/java/com/devives/sphinx/rst/ReadMeGenerator.java", "this code")
                        .text(".")))
                .build();

        String rstText = document.serialize();
        Files.createDirectories(resultPath.getParent());
        Files.write(resultPath, Arrays.asList(rstText.split(NL)), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private String codeSample() {
        return Rst.builders().document()
                .title("Document title", true)
                .paragraph("Simple text without any emphasis or enhancements.")
                .subTitle("Section title")
                .beginParagraph().text("Text can contains emphasis like ").bold("bold")
                .text(" or ").italic("italic").text(" text.")
                .end()
                .build()
                .serialize();
    }
}
