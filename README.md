### Entity Klassen
- Teams
- Termine
- Field


Die Datenbank Teams besteht aus Id und Name. Ein Team kann mehrere Termine haben. 
Ein Termin kann aber nur einem Team zugeordnet werden. Ein Termin besteht aus einer Id und einem Datum mit Zeit.
Weiters hat der Termin einen boolean, ob der Termin reserviert ist und zwei Fremdschlüssel von den Tabellen
Teams und Field. Ein Termin kann nur einen Field haben. Eine Field kann mehrere Termine haben.
Ein Field besteht aus Id und Name.

Man kann Termine in die Datenbank eintragen. Dabei muss man das Datum, die Uhrzeit und das Feld eingeben auf welchem 
dieser Termin stattfinden soll. Diese Termine können dann reserviert werden. Dafür gibt es eine Listview mit 
freien Terminen, welche man für ein bestimmtes Team reservieren kann. Eine weitere Listview mit bereits reservierte,
dort kann man seine Reservierung wieder löschen. 

