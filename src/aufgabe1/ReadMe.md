# Aufgabe 1
### b)
> Warum sind reversed, debug und none Funktionen höherer Ordnung?
- Funktionen höherer Ordnung nehmen andere Funktionen als Parameter. Dies machen wir hier, da jedes Ordering eine eigene Funktion ist.

> Welches Entwurfsmuster wurde durch die Verwendung von Funktionen höherer Ordnung realisiert?
- Dekorierer

> Warum kann das Entwurfsmuster dadurch implementiert werden? 
- Weil man ein Ordering<A/> als Parameter erhält, aber ebenfalls ein Ordering<A/> zurückgibt/eins ist.

> Was ist die grundlegende Struktur des Entwurfsmusters und inwiefern korreliert diese Struktur mit der von Funktionen höherer Ordnung?
- Die Struktur des Dekorierers ist "fun (xyz: XYZ) : XYZ = ... xyz ..."
- Die Struktur von Funktionen höherer Ordnung ist: fun (func: fun) = ... func() ...
- Was gleich ist: wir bekommen etwas übergeben als Parameter und benutzen dies in der Funktionalität der neuen Funktion

