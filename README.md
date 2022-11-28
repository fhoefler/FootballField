### Entity Klassen
- Teams
- Termine
- Field


Die Datenbank Teams besteht aus Id und Name. Ein Team kann mehrere Termine haben. 
Ein Termin kann aber nur einem Team zugeordnet werden. Ein Termin besteht aus einer Id und einem Datum mit Zeit.
Weiters hat der Termin einen boolean, ob der Termin reserviert ist und zwei Fremdschlüssel von den Tabellen
Teams und Field. Ein Termin kann nur einen Field haben. Eine Field kann mehrere Termine haben.
Ein Field besteht aus Id und Name.

Es sollen Termine reserviert werden können. Dafür muss, aber überprüft werden ob dieser nicht schon belegt ist.
Ein reservierter Termin soll wieder freigegeben werden können. Es sollen auch neue Teams und Fields hinzugefügt oder
gelöscht werden können.

