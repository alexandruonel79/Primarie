Onel Alexandru 322CB

Am inceput tema cu dorinta de a avea mai putine clase statice si am ajuns doar cu una pentru scrierea in fisier.
Pentru alegerea colectilor m am folosit de acest site https://www.baeldung.com/java-choose-list-set-queue-map.
    In ManagementPrimarie am inceput prin a declara un arraylist de Utilizatori(am ales arraylist din usurinta avand o
complexitate O(n), pentru celelalte am ales structuri mai eficiente). Cererile din clasa Utilizatori
sunt implementate folosind treeSet si au o complexitate pentru toate operatiile de log(n) daca sunt
sortate, ceea ce si sunt. Am folosit o colectie mai eficienta pentru cererile din Utilizator deoarece sunt mai des
adaugate. Pentru cererile din birouri am folosit un PriorityQueue deoarece enuntul temei mentiona cuvantul coada(a fost
un mic hint) si mentin cererile sortate si le elimin in ordinea corecta.Totodata PriorityQueue este foarte eficient
O(log n) adaugare si eliminare si O(1) pentru obtinerea primului element.
    In plus, mi am facut o clasa WrapperCerere care contine Cerere si Utilizator. Am facut o deoarece aveam nevoie de
utilizator in clasa Birouri in coada pentru usurinta.
    In ManagementPrimarie am facut parsarea comenzilor unde am tratat toate cazurile. Clasele CereriUtilizatori si
CereriComparator le am folosit drept Comparator pentru TreeSet respectiv PriorityQueue. Clasa Utilizator abstracta
extinde celelalte clase Angajat,Elev,EntitateJuridica,Persoana si Pensionar unde am dat override la scrierea de text si
extinde Stringul nume. Constructorul este individual in fiecare clasa extinsa din Utilizator. Clasa Utilizator contine
toate functiile legate de acestia (creearea, retragerea, rezolvarea, afisarea). Clasa Birou este o clasa ce se foloseste
de genericitate, astfel am declarat in ManagementPrimarie Birouri de mai multe tipuri. Totodata contine o functie ce
se foloseste de genericitate(parametrul utilizator in functia de adaugare cerere). Clasa FunctionarPublic este generica
dar nu contine nicio functie ce contine genericitatea.
    Am facut pentru bonus un director nou ce contine o clasa main Primarie, ce salveaza evenimente intr un arraylist
si le poate afisa incluzand toti artistii. Acestia sunt implementati printr o clasa abstracta Artist si sunt de diverse
tipuri. Totodata un eveniment contine si data. Sistemul este asemanator cu cel de la tema in miniatura. Am creat doar 3
teste, care trateaza toate cazurile. Pentru a rula testele trebuie modificata aceasta linie din Primarie:
"File myObj = new File("src/main/java/org/example/Bonus/inp/inx.txt")"" cu x de la 1-3.
    Tema a fost interesanta, putin mai greu de inteles ideea principala dar odata inteleasa relativ usor de implementat
folosind principiile OOP.