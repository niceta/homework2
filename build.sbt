name := "qa_fintech_scala"

version := "1.0"

scalaVersion := "2.12.4"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4"

val testThreads = 64

concurrentRestrictions in Global := Seq(
  Tags.limit(Tags.Test, testThreads)
)

parallelExecution in Test := true