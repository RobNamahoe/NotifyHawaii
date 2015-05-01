import play.PlayJava

name := """NotifyHawaii"""

scalaVersion := "2.11.1"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4"
)

val appDependencies = Seq(
  "be.objectify"  %% "deadbolt-java"     % "2.3.2",
  // Comment the next line for local development of the Play Authentication core:
  //"com.feth"      %% "play-authenticate" % "0.6.8",
  "postgresql"    %  "postgresql"        % "9.1-901-1.jdbc4",
  javaCore,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.2.0"
)

//  Uncomment the next line for local development of the Play Authenticate core:
lazy val playAuthenticate = project.in(file("modules/play-authenticate")).enablePlugins(PlayJava)

lazy val root = project.in(file("."))
  .enablePlugins(PlayJava)
  .settings(
    libraryDependencies ++= appDependencies
  )
/* Uncomment the next lines for local development of the Play Authenticate core: */
.dependsOn(playAuthenticate)
.aggregate(playAuthenticate)