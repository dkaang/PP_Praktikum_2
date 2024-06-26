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
    if (a != null) Left(a) else Right(b) // wenn wir ein 'a' haben, dann gib das a zurück, ansonsten gib 'b' zurück


fun main(){
    println(to { 500000 }) // kotlin.Unit
//    println(from {Nothing}) // geht nicht!

//    val resA = makeEither(50) { null }
//    val resB = makeEither(null) { 50 }
//    val resAB = makeEither(50) { 20 }
//    println(resA)
//    println(resB)
//    println(resAB)
}
