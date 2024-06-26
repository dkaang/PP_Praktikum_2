# Aufgabe 2
> a) Welcher Typ in Kotlin ist äquivalent zur 1 in der Algebra?
- Unit

> b) Zeigen Sie, ob Either<A?, B> äquivalent bzw. isomorph zu Either<A, B>? ist. 
>> Achtung: die "?" deuten auf nullfähige Typen hin! Überführen Sie dazu die Typen in Algebra
- A? -> Either<A, Unit> => A + 1
- B -> B
- Either = "+"
- → A + B => "A+1+B"
- __--__--__--__--__--__-__-__-__-__
- A -> A
- B -> B
- Either = "+"
- → A + B => "A+B"

- ? -> +1, weil:
- Either<Either<A,B>, Unit>
- A+B + 1 => A+B+1

- __--__--__--__--__--__-__-__-__-__
- Antwort: Ja, die Terme sind äquivalent, weil: A+B+1 <=> A+1+B

> c)
-  ---> a^0 = 1 <---
-  a <-- 0
-  0 --> a
-  → Nothing -> A
- (für Implementation der Methoden, siehe aufgabe2/Main.kt)

> d) Warum kann die from-Funktion implementiert werden, obwohl nur ein Nothing zur Verfügung steht, aber ein Wert vom Typ A zurückgegeben werden muss? 
>> Hinweis: Die Antwort liegt im Subtyping-System von Kotlin.
- "The unified supertype type for all types in Kotlin is "kotlin.Any?", a nullable version of "kotlin.Any". The unified subtype type for all types in Kotlin is "kotlin.Nothing".

> f) Warum ist die Implementierung von makeEither nicht 100 %ig valide? Begründe Sie ihre Antwort entweder mit der Verwendung von Algebra oder durch logische Argumente.
- Online nachgelesen:
- In Kotlin sind "null"-Checks zur Laufzeit nicht unterstützt, wenn der Typ 'A' nicht selbst Nullable ist 
