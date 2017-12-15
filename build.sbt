import Dependencies._

organization := "com.gabechurch"

scalaVersion := "2.11.8"

version      := "0.1.0"

name := "ParserTest"

//useGpg := true

libraryDependencies += "com.vladsch.flexmark" % "flexmark-all" % "0.28.16"

pomIncludeRepository := { _ => false }

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("http://example.com"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/your-account/your-project"),
    "scm:https://github.com/GabeChurch/ParseMarkdownScala.git"
  )
)

developers := List(
  Developer(
    id    = "com.gabechurch",
    name  = "Gabe Church",
    email = "gabe1church@gmail.com",
    url   = url("http://gabechurch.com")
  )
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pgpReadOnly := false




