package aufgabe2

sealed interface Either <out A, out B>
data class Left<A> (val a: A) : Either<A, Nothing >
data class Right<B> (val b: B) : Either<Nothing, B>
