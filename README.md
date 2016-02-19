# grumm
Grumm is a statically typed programming language for the JVM. Grumm tries to combine the succinctness you love of dynamically typed languages and the safety you love of statically typed languages. Grumm is inspired by Scala, Java, and Ruby.

Here are a few cool features of Grumm:

- statically typed
- variables are declared in a Pascal-style (e.g.  message : String = "hello world!")
- compiles to JVM bytecode, so it can run anywhere
- Strings, Lists, Arrays, and Maps are first-class citizens of Grumm, so you don't need a bunch of imports to use these types
- there is no "new" statement. Instead, every object is instantiated the first time that it's used.- you can import any Java package you need into Grumm code and use the Java packages you're familiar with
- semi-colons at the end of statements are optional, use them if you want or leave them off
- if a function doesn't have a return type (i.e. void), you can omit the return type. in other words, void is the default
- Grumm uses the Ruby-like syntax of '<' for inheritance instead of the 'extends' keyword