package aufgabe2

// -- 2c) --
/*
    ---> a^0 = 1 <---
    a <-- 0
    0 --> a
    → Nothing -> A
*/
fun <A> to(f: (Nothing) -> A): Unit = Unit // gibt Unit (1) zurück

fun <A> from(unit: Unit): (Nothing) -> A = { // gibt nichts zurück, weil Nothing
    nothing: Nothing -> nothing
}

// -- 2e) --
fun <A, B> makeEither (a: A, b: B) : Either <A, B> =
    if (a != null) Left(a) else Right(b)


fun main(){
    println(to { 50 }) // kotlin.Unit
//    println(from {Nothing}) // geht nicht!
}
