import Dependencies._

organization := "com.Gabe.Church"

scalaVersion := "2.11.8"

version      := "0.1.0"

name := "ParserTest"

//publishTo := Some(Resolver.file("file", new File("/root/.ivy2/jars")))

publishTo := Some(Resolver.file("local", file("/root/.ivy2"))(Resolver.ivyStylePatterns))


libraryDependencies += "com.vladsch.flexmark" % "flexmark-all" % "0.28.16"


