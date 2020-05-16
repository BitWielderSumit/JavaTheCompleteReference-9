# Data Types, Variables, and Arrays

## Java Is a Strongly Typed Language
It is important to state at the outset that Java is a strongly typed language. Indeed, part of Java’s safety and robustness comes from this fact. Let’s see what this means. First, every variable has a type, every expression has a type, and every type is strictly defined. Second, all assignments, whether explicit or via parameter passing in method calls, are checked for type compatibility. There are no automatic coercions or conversions of conflicting types as in some languages. The Java compiler checks all expressions and parameters to ensure that the types are compatible. Any type mismatches are errors that must be corrected before the compiler will finish compiling the class.

1. Integers
	byte(8 bit), short(16 bit), int(31 bit), and long(64 bit)
2. Floating-point numbers
	float, double
3. Characters
	char
4. Boolean
	boolean


## How to calcualte range of Integer.

for Byte = 2^(n-1) =  2^(8-1) = 2^(7) = 128, So -128 to +127 (0 is considered positive integer) hence this range.


## The Scope and Lifetime of Variables

As a general rule, variables declared inside a scope are not visible (that is, accessible) to code that is defined outside that scope. Thus, when you declare a variable within a scope, you are localizing that variable and protecting it from unauthorized access and/or modification. Indeed, the scope rules provide the foundation for encapsulation.

Scopes can be nested. For example, each time you create a block of code, you are creating a new, nested scope. When this occurs, the outer scope encloses the inner scope. This means that objects declared in the outer scope will be visible to code within the inner scope. However, the reverse is not true. Objects declared within the inner scope will not be visible outside it.

## Type Conversion and Casting

### Java’s Automatic Conversions

#### The two types are compatible.
The destination type is larger than the source type.

#### Casting Incompatible Types
(target-type) value

#### Automatic Type Promotion in Expressions

```
byte a = 40
byte b = 50
byte c = 100
int d = a * b / c
```

```
The result of the intermediate term a * b easily exceeds the range of either of its byte operands. To handle this kind of problem, Java automatically promotes each byte, short, or char operand to int when evaluating an expression. This means that the subexpression a*b is performed using integers—not bytes. Thus, 2,000, the result of the intermediate expression, 50 * 40, is legal even though a and b are both specified as type byte.
```

String is class, its not primitive Type.









