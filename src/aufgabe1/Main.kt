package aufgabe1

typealias Ordering<A> = (A, A) -> OrderResult

val intOrd : Ordering <Int> = {
    left, right ->
        if ( left < right ) OrderResult.Lower
        else if ( left > right ) OrderResult.Higher
        else OrderResult.Equal
}

// ----- 1.1a) -----
val strOrd : Ordering <String> = {
    left, right ->
        if ( left < right ) OrderResult.Lower
        else if ( left > right ) OrderResult.Higher
        else OrderResult.Equal
}
val doubleOrd : Ordering <Double> = {
    left, right ->
        if ( left < right ) OrderResult.Lower
        else if ( left > right ) OrderResult.Higher
        else OrderResult.Equal
}

val boolOrd : Ordering <Boolean> = {
    /*  false < true | => true
        true < false | => false
        therefore true = 1, false = 0   */
    left, right ->
        if ( left < right ) OrderResult.Lower
        else if ( left > right ) OrderResult.Higher
        else OrderResult.Equal
}

// ----- 1.2a) -----
//fun reversed(ordering: Ordering<A>)
fun <A> reversed(ordering: Ordering<A>) : Ordering<A> =
    { x, y -> ordering(y, x) }

fun <A> debug(ordering: Ordering<A>) : Ordering<A> =
    { left, right ->
        val result = ordering(left, right)
        println("'$left' is ${result.toString().uppercase()} than '$right'")
        result
    }

fun <A> none(ordering: Ordering<A>) : Ordering<A> =
    { _, _ -> OrderResult.Equal }


// ----- 1.3 -----
// -- 1.3a) --
// Map wendet die angegebene Funktion auf jedes Element einer Liste an
//fun <A, B> mapList(list: List<A>, transform: (A) -> B) : List<B> {
//    val bs = mutableListOf <B >()
//    for (a in list ) bs += transform (a)
//    return bs
//}

fun <A, B> contraMap(ordering: Ordering<A>, transform: (B) -> A) : Ordering<B> =
    { left, right -> ordering(transform(left), transform(right)) }



// -- 1.3b) --
// siehe Person Datei in Package
val personNameOrd : Ordering <Person> = {
    left, right ->
        if ( left.name < right.name ) OrderResult.Lower
        else if ( left.name > right.name ) OrderResult.Higher
        else OrderResult.Equal
}
val personAgeOrd : Ordering <Person> = {
    left, right ->
        if ( left.age < right.age ) OrderResult.Lower
        else if ( left.age > right.age ) OrderResult.Higher
        else OrderResult.Equal
}


// ----- 1.4a) -----
// wenn 2 Werte beim ersten Ordering gleich sind, dann das Zweite auf die beiden benutzen
// "Stefan":32, "Stefan":25 => "Stefan": 25, "Stefan":32
fun <A, B> zip(ordering1: Ordering<A>, ordering2: Ordering<B>) : Ordering<Pair<A,B>> =
    { left, right ->
        val result = ordering1(left.first, right.first)
        if (result == OrderResult.Equal)
            ordering2(left.second, right.second)
        else
            result
    }


//val ord : Ordering <Pair < String , Int >> = zip ( strOrd , intOrd )
val ord: Ordering<Pair<Person, Person>> = zip(personNameOrd, personAgeOrd) // nicht wirklich gecheckt tbh





fun main(){
    val intDesc = reversed ( intOrd )
    val strDebug = debug ( strOrd )
    val intDebug = debug ( intOrd )
    val doubleDesc = debug ( reversed ( doubleOrd ))
    val noOrd = none ( strOrd )


    val stringLengthOrd: Ordering<String> = contraMap(
        ordering = intOrd,
        transform = { string -> string.length }
    )

    // -- 1.3c) --
    val personNameOrdering: Ordering<Person> = contraMap(
        ordering = personNameOrd,
        transform = { person: Person -> person }
    )
    val personAgeOrdering: Ordering<Person> = contraMap(
        ordering = personAgeOrd,
        transform = { person: Person -> person }
    )

    // -- 1.3d) --
    val kaan = Person("Kaan", 21)
    val yousef = Person("Yousef", 20)
    val ardagueler = Person("Arda Güler", 19) // besser als ronaldo prime 🇹🇷 🇹🇷 🇹🇷 🇹🇷 🇹🇷 🇹🇷 🇹🇷

    // strDebug("Kaan", "Yousef") // 'Kaan' is LOWER than 'Yousef'
    // intDebug(kaan.age, ardagueler.age) // '21'(=> Kaan) is HIGHER than '19'(=> Arda Güler)
    personNameOrdering(kaan, yousef)
    personAgeOrdering(kaan, ardagueler)

    // -- 1.4b) -- ich checke tbh nix davon atm
//    val sorting = Sorting()
//    val people = listOf(
//                        Person("Nathalie", 25),
//                        Person("Alex", 33),
//                        Person("Zah", 28),
//                        Person("Alex", 18),
//                        Person("Jens", 33)
//    )
//    val ord: Ordering<Person> = contraMap(
//        ordering = zip(personNameOrd, personAgeOrd),
//        transform = { person1: Person, person2: Person -> Pair<Person, Person>(person1, person2) }
//    )
//    println(sorting.sort(people, ord))



}





//    strDebug("A", "a") // "A" kommt nach "a" in der Reihenfolge (so wie "1", "2")
//    val testStrList: MutableList<String> = mutableListOf("a", "c", "b", "z", "q", "w", "r", "k", "l", "p", "c", "b")
//    val testIntList: MutableList<Int> = mutableListOf(1,5,2,1,5,6,7,2,6712,612412,661,2231,661,17,8322,4,21,12,13,5,7)