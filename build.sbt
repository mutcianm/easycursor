ThisBuild / ideaPluginName := "easycursor"
ThisBuild / ideaEdition := IdeaEdition.Community
ThisBuild / ideaBuild := "183.4284.93"

lazy val easycursor = (project in file("."))
  .enablePlugins(SbtIdeaPlugin)
  .settings(
    organization := "net.uzimith",
    scalaVersion := "2.12.7",
    Global / onLoad ~= { _.andThen("updateIdea" :: _) },
  )

lazy val ideaRunner = createRunnerProject(easycursor, "ideaRunner")
  .settings(
    run / fork := true,
    run / javaOptions += s"-Didea.home=${ideaBaseDirectory.value.getPath}",
  )
