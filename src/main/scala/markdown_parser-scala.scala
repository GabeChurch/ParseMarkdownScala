package com.Gabe.Church.ParseMarkdown

import java.util.Arrays
import com.vladsch.flexmark._
import com.vladsch.flexmark.ast._
import com.vladsch.flexmark.ast.Node
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.parser.Parser._
import com.vladsch.flexmark.parser.ParserEmulationProfile
import com.vladsch.flexmark.parser.ParserEmulationProfile._
import com.vladsch.flexmark.util.options.MutableDataHolder
import com.vladsch.flexmark.util.options.MutableDataSet
import com.vladsch.flexmark.util.options.MutableDataSetter
import com.vladsch.flexmark.ext.footnotes
import com.vladsch.flexmark.ext.tables
import com.vladsch.flexmark.ext.abbreviation
import com.vladsch.flexmark.ext.definition


object parsemarkdown extends App{

//CommonMark Parser
def commonMark(input_markdown: String): String = {
  com.vladsch.flexmark.html.HtmlRenderer.builder().build().render(
    com.vladsch.flexmark.parser.Parser.builder().build().parse(input_markdown))
}

//Kramdown Parser
def kramdown(input_markdown: String): String = {
  val options = new MutableDataSet()
  options.setFrom(ParserEmulationProfile.KRAMDOWN)
  options.set(Parser.EXTENSIONS, Arrays.asList(
    com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension.create(),
    com.vladsch.flexmark.ext.definition.DefinitionExtension.create(),
    com.vladsch.flexmark.ext.footnotes.FootnoteExtension.create(),
    com.vladsch.flexmark.ext.tables.TablesExtension.create(),
    com.vladsch.flexmark.ext.typographic.TypographicExtension.create()
  ))
  com.vladsch.flexmark.html.HtmlRenderer.builder(options).build().render(
    com.vladsch.flexmark.parser.Parser.builder(options).build().parse(input_markdown))
}


//Multi-Markdown Parser
def multiMarkdown(input_markdown: String): String = {
  val options = new MutableDataSet()
  options.setFrom(ParserEmulationProfile.MULTI_MARKDOWN)
  
  com.vladsch.flexmark.html.HtmlRenderer.builder(options).build().render(
    com.vladsch.flexmark.parser.Parser.builder(options).build().parse(input_markdown)) 
}

//Classic Markdown Parser
  
def markdown(input_markdown: String): String = {
  val options = new MutableDataSet()
  options.setFrom(ParserEmulationProfile.MARKDOWN)
    com.vladsch.flexmark.html.HtmlRenderer.builder(options).build().render(
      com.vladsch.flexmark.parser.Parser.builder(options).build().parse(input_markdown))
}

}

