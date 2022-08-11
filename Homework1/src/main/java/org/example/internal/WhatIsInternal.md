# What is Internal Modifier?
Internal Modifier
Internal is a new modifier available in Kotlin that’s not there in Java. Setting a declaration as internal means that it’ll be available in the same module only. By module in Kotlin, we mean a group of files that are compiled together.

```
internal class A {
}

internal val x = 0
```
These won’t be visible outside the current module. Internal Modifiers is useful when you need to hide specific library implementations from the users. This wasn’t possible using the package-private visibility in Java.