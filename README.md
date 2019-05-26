A small example of a Quarkus application in Kotlin, using Gradle (with Kotlin DSL).

This isn't documented in this combination.  
See documentation for [Quarkus with Gradle](https://quarkus.io/guides/gradle-tooling) and
[Quarkus with Kotlin](https://quarkus.io/guides/kotlin).

# Build commands

```bash
gradle clean
gradle quarkusDev
gradle build
gradle buildNative
```

## Failed to build a runnable JAR

If you see this error, run `gradle build --stacktrace`. The result might look like this:

```
Caused by: java.nio.file.NoSuchFileException: /somedir/quarkus-kotlin-gradle-test/build/resources/main
        at io.quarkus.creator.phase.augment.AugmentPhase.provideOutcome(AugmentPhase.java:208)
        ... 84 more
```

Solution: Create a file `test.txt` in `./src/resources`.
There seems to be the need of at least a single file.

# Run the native app

The output was a 19MB file. It started very quickly, as Quarkus promised.

```
$ ./build/quarkus-kotlin-gradle-test-runner
2019-05-26 12:58:53,783 INFO  [io.quarkus] (main) Quarkus 0.15.0 started in 0.009s. Listening on: http://0.0.0.0:8080
2019-05-26 12:58:53,784 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy]
^C
2019-05-26 12:58:54,176 INFO  [io.quarkus] (main) Quarkus stopped in 0.001s
```

And the prove a curl works while the server is running:

```
$ curl http://0.0.0.0:8080/greeting
hello⏎
```
