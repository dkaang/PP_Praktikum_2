# Aufgabe 3
> a) Inwiefern werden die typischen Merkmale der funktionalen Programmierung erfüllt? 
>> Nennen Sie auch hier ein paar Codestellen, das jeweilige Merkmal und ihre Begründung.

Merkmale:
---
- Ein typisches Merkmal ist, dass das Programm (fast) zu 100% deklarativer Natur ist. → Beispiel: 
- fun <A, B> contraMap(ordering: Ordering<A\>, transform: (B) -> A) : Ordering<B> =
  { left, right -> ordering(transform(left), transform(right)) }
---
- Funktionen sind Werte (können überall definiert und verwendet werden). → Beispiel:
- val stringOrd : Ordering <String> = {
  left, right ->
  if ( left < right ) OrderResult.Lower
  else if ( left > right ) OrderResult.Higher
  else OrderResult.Equal
  }
---
- Programm wird mit besonderer Betonung von Funktionen programmiert.
- val intOrd : Ordering <Int> = { }
- fun <A, B> contraMap(ordering: Ordering<A\>, transform: (B) -> A) : Ordering<B> = { }
- fun <A, B> Ordering<A\>.zip(ordering2: Ordering<B>) : Ordering<Pair<A,B>> = { }
---
- Funktionen können Funktionen akzeptieren oder zurückgeben (FHO).
- fun <A, B> Ordering<A\>.zip(ordering2: Ordering<B>) : Ordering<Pair<A,B>> = { }
---
> b) Überlegen Sie für sich, welche Techniken und Denkweisen Sie aus der Bearbeitung des Praktikumsblattes mitnehmen.
- Ich glaube, ich finde es am interessantesten, dass man sich jede Methode mathematisch herleiten kann.
- Am nützlichsten ist es aber denke ich, dass man Funktionen in Variablen abspeichern kann und diese weiterverwenden kann.
- FHO können sehr sehr hilfreich sein. 
