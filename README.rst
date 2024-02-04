==============================================
ReStructuredText Document & Builder for Sphinx
==============================================

This project is the library which extends `ReStructuredText Document and Builder library <https://github.com/devives/rst-document>`_.

The library is part of the project `RstDoclet for JavaDoc Tool, generating reStructuredText for Sphinx <https://github.com/devives/rst-doclet>`_.

.. contents:: Overview
   :depth: 2

Quick Start
-----------

1. Add ``mavencentral()`` repository to your root ``build.gradle``:

   .. code:: gradle

      repositories {
          mavenCentral()
      }
#. Add library to dependencies:

   .. code:: gradle

      dependencies {
          implementation 'com.devives:devive-rst-doc4sphinx:0.2.0'
      }

Sample code
-----------

.. code:: java

   private String codeSample() {
       return Rst4Sphinx.builders().document()
           .title("Document title", true)
           .paragraph("Simple text without any emphasis or enhancements.")
           .subTitle("Section title")
           .beginParagraph().text("Text can contains emphasis like ").bold("bold")
           .text(" or ").italic("italic").text(" text.").end()
           .build()
           .serialize();
   }

will return

::

   ==============
   Document title
   ==============

   Simple text without any emphasis or enhancements.

   Section title
   -------------

   Text can contains emphasis like **bold** or *italic* text.


License
-------

The code of project distributed under the GNU General Public License version 2 or 
any later version. The source code is available on `GitHub <https://github.com/devives/rst-doc4sphinx>`_.

Links
-----

* `Documentation » Using Sphinx » reStructuredText <https://www.sphinx-doc.org/en/master/usage/restructuredtext/index.html>`_

.. footer::

   This document generated using `this code <https://github.com/devives/rst-document-for-sphinx/blob/main/src/test/java/com/devives/sphinx/rst/ReadMeGenerator.java>`_.
