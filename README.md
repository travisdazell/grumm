# grumm
Grumm is a statically typed programming language for the JVM. Grumm tries to combine the succinctness you love of dynamically typed languages and the safety you love of statically typed languages. Grumm is inspired by Scala, Java, and Ruby.

Here are a few cool features of Grumm:

- statically typed, so you don't have to trust the compiler to figure it out for you
- compiles to JVM bytecode, so it can run anywhere
- strings, lists, and arrays are first-class citizens of Grumm, so you don't need a bunch of imports to do operations on these types
- if you need java.lang.String, you can use it since Grumm is case-sensitive
- semi-colons at the end of statements are optional, use them if you're used to doing it or leave them off
- if a function doesn't have a return type (i.e. void), you can omit the return type. in other words, void is the default
- syntax is very concise and not bloated. for example, to create a list of strings:   myList : <string>
- Grumm uses the Ruby-like syntax of '<' for inheritance instead of the 'extends' keyword
