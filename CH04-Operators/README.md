# Operators

## Arithmetic Operators

||Operator||Result||
|+|Addition (also unary plus)|
|–|Subtraction (also unary minus)|
|*|Multiplication|
|/|Division|
|%|Modulus|
|++|Increment|
|+=|Addition assignment|
|– =|Subtraction assignment|
|*=|Multiplication assignment|
|/=|Division assignment|
|%=|Modulus assignment|
|– –|Decrement|


### Relational Operators

||Operator||Result||
|==|Equal to|
|!=|Not equal to|
|>|Greater than|
|<|Less than|
|>=|Greater than or equal to|
|<=|Less than or equal to|


### Boolean Logical Operators

|Operator|Result|
|&|Logical AND|
|||Logical OR|
|^|Logical XOR (exclusive OR)|
||||Short-circuit OR|
|&&|Short-circuit AND|
|!|Logical unary NOT|
|&=|AND assignment|
||=|OR assignment|
|^=|XOR assignment|
|==|Equal to|
|!=|Not equal to|
|?:|Ternary if-then-else|


### Short-Circuit Logical Operators

```
if(denom != 0  && num / denom > 10 )
```

Since the short-circuit form of AND (&&) is used, there is no risk of causing a run-time exception when denom is zero. If this line of code were written using the single & version of AND, both sides would be evaluated, causing a run-time exception when denom is zero.

### The Assignment Operator

var = expression;

### The ? Operator

expression1 ? expression2 : expression3



--------------------- TODO Questions ------

what is &= or |= used for , functioning of it.












