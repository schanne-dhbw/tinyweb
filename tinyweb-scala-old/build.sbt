lazy val tinyweb = (project in file(".")).
  settings(
    name := "tinyweb-scala"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.1" % "test"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)