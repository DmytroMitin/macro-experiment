ThisBuild / scalaVersion := "2.12.8"

ThisBuild / scalacOptions += "-Ypartial-unification"

lazy val macroImpl = project
  .settings(libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.typelevel" %% "cats-core" % "1.6.0"
  ))
lazy val use = project
  .dependsOn(macroImpl)
  .settings(scalacOptions += "-Ymacro-debug-lite")

lazy val core = project
  .dependsOn(use)
  .settings(scalacOptions += "-Ymacro-debug-lite")

