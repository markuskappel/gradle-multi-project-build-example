# Example of Multi-Project Build using buildSrc

The `app` module contains a Spring Boot application. It depends on another module called
`some-external-api`.

The `app` module declares a dependency on `some-external-api`. See `app/build.gradle`:

```
  implementation project(':some-external-api')
```

- `some-external-api` uses Kotlin's `internal` keyword to annotate types or methods etc. internal
  to this module. This hides private and internal code from the `app` module.
- `some-external-api` cannot use anything from `app` since it doesn't declare a dependency on `app`

## The buildSrc subproject

The `buildSrc` subproject isn't required for a multi-module project.
Each module can define dependencies in their `build.gradle`. Many modules may share the dependency
on some libraries. `buildSrc` helps to organize common build logic and dependencies.

For example, the `common-conventions.gradle` defines the Java language version and adds Kotlin
language support. It can be used by all modules. It also declares dependencies that most or all
modules rely on.

The `application-conventions.gradle` configures the `org.jetbrains.kotlin.plugin.spring` plugin.
It is intended to be used in modules that depend on Spring Boot, like the `app` module. 
