# Matheguru ![Matheguru](http://matheguru.ga/matheguru_logo.png) <!-- 1613 Zeilen Code!!! -->
A desktop application created in order to assist fith-graders to learn the basics of algebra.
Mit momentan 333 Aufgaben! Beliebig erweiterbar!

Official Website: [Matheguru](http://matheguru.ga/)

## Log
- [x] Wahl der Entwicklungsumgebung
  - Setup des Projekts in Eclipse
- [x] Hinzufügen des Projekts zu Github <!-- 2 Stunden -->
  - einfacher zu verwalten (immer überall auf aktuellstem Stand)
  - mehrere Versionen möglich (damit die Applikation portabel ist)
  - Zugriff und Bearbeitung des Projekts erleichtert
  - Einfügen eines Protokolls und eines Zeitplans
  - Upload verschiedener Releases
- [x] Erstellung der Website <!-- 3 Stunden -->
  - Wahl des Webhosters -> [bplaced](http://www.bplaced.net/) (kostenloser Webspace) <!-- 0,5 Stunden -->
  - Registrierung der Domain [matheguru.ga](http://matheguru.ga/) bei Freenom (kostenloser DNS Service) <!-- 0,5 Stunden -->
  - Eigenständige Erstellung der Website mithilfe von HTML und CSS (ohne jegliche Frameworks) <!-- 1 Stunden -->
  - Upload der Seite als auch des Programms auf matheguru.tk <!-- 0 Stunden -->
  - Änderung des Designs und Behebung kleinerer Fehler <!-- 0,5 Stunden -->
  - Hinzufügen der Website zu Google <!-- 0,45 Stunden -->
  - Website vollkommen responsive machen
- [x] Erstellung eines Protopyen <!-- 6 Stunden -->
  - Programmierung eines generischen Aufgabenerstellers
  - Funktionsweise der GUI im Aufgabenmodus
  - Speicherung und Laden von Aufgaben
  - Berechnung von Spielstatistiken
  - grundlegende KI, die den Nutzer gezielt fördert :+1:
- [x] Erstellung eines Aufgabenmanagers <!-- 2 Stunden -->
  - macht möglich, neben den generisch erzeugten Aufgaben eigene Aufgabendateien zu erzeugen
  - Mithilfe des Aufgabenmanagers können beliebige Arten von Aufgaben gespeichert werden, so dass eine Fokussierung auf Schwächen oder sogar ein Einsatz von Matheguru für weitere Jahrgangsstufen ermöglicht wird
  - auch direkte Editierung der Aufgabendatei gut möglich, da der Aufgabenmanager ordnet die Aufgaben vor dem Speicher mithilfe eines Sortieralgorithmus des Laufzeitverhaltens O(n \* log n), so dass die Aufgabendatei übersichtlich ist
  - Zeitaufwand zur Programmierung: ca. 2 Stunden
- [x] Eingabe von über 330 Aufgaben mit Lösungen und Schwierigkeitsgrad als Standardausstattung des Programms (beliebig nach Anforderungen erweiterbar)<!-- 3 Stunden -->
- [x] Entwicklung eines Corporate Designs -> Einheitliche Schriftarten, Farben, Logos etc. auf Website, im Programm, auf Github, in 
- [x] Erweiterung der Website um Anleitungen 
- [x] Erweiterung der Website um eine Online Highscoredatenbank, von der mit PHP die besten 10 User per Livewebsite aufgerufen werden können
- [x] Erstellung einer fünfseitigen, kleinschrittigen Anleitung für Matheguru und den Aufgabenmanager und Hinzufügen zur Website + PDF <!-- 3 Stunden -->
Anleitungen
- #### Features <!-- des aktuellen Programms: 40 Stunden -->
  - portabel für Windows, Linux und Mac OSX 
  - Entwurf der grafischen Oberfläche (GUI) <!-- animierter Hintergrund, verschiedenen Screens mit Management-->
  - Programmierung einer Klasse zur Speicherung der Aufgaben
  - Programmierung einer KI, die den Nutzer gezielt fördert :+1:
  - Ladescreen
  - Eingangsdialog
  - Anleitung zum Spielen
  - Anzeige der von den Fünftklässlern bekannten Zeichen für Multiplikation und Division (anstatt * & /)
  - Anzeige von Statistiken nach Absolvieren einer Runde
  - Zeitbeschränkung beim Spielen
  - Punktesystem zur Motivation der Schüler: je nach Schwierigkeit der Aufgaben
  - Hishscoreliste mit den Top 10 Spielern: 2. verbesserte Version über php-Schnittstelle + Möglichkeit, beliebig viele Spieler anzuzeigen
  - Highscoreliste ist auch online zum Anfeuern erreichbar -> aktualisiert sich automatisch
  - Einstellungen
    - Einstellungsmöglichkeit der Spielzeit
    - Wahl einer Aufgabendatei
    - Möglichkeit, bei falscher Eingabe Lösung angezeigt zu bekommen
  - automatische Speicherung der Einstellungen
  - automatisches Laden der neusten Aufgaben über das Internet -> jedoch auch Offline möglich
  - UNENDLICH viele Aufgaben: Termgenerator, der Aufgaben beliebiger Schwierigkeitsstufe erstellt (in Einstellungen aktivierbar)
  - Auto-Updates: Das Programm sucht (falls Internet vorhanden) nach Updates und aktualisiert sich selber -> Software immer auf neustem Stand, ohne sich darum kümmern zu müssen
  - Zugriff auf Liveanzeige der Onlinehighscores vom Programm aus + Aussehen der Highscoreszenen an Website angeglichen
  - 333 von Hand ins Spiel eingefügte Aufgaben (Korrektheit der Lösungen mit eigenem Programm überprüft)
  - Verschiedene visuelle Themes / Hintergründe: Feste Farbe (auswählbar), Regenbogenanimation, Partikel, Animierter Farbeverlauf, "Chameleon" -> können über Einstellungen ausgewählt werden
  - MatheguruIcon wird nun in der Programmleiste + der TitleBar des Programms angezeigt (anstatt des Java-Logos)
  
  - Großes Uploadupdate: 
    - Möglichkeit, auf Website eigene Aufgabendateien hochzuladen (http://matheguru.ga/upload_form.php)
    - Diese hochgeladenen Aufgaben werden in Matheguru angezeigt, sie können heruntergeladen werden und werden offline gepseichert
    - Übersicht der offline gespeicherten Aufgaben (können geladen und gelöscht werden)
- #### TODO
  - [x] Termgenerator
  - [x] Visuelle darstellung highscore szenen verbessern
  - [ ] Check ob er bei .mg file im startordner diese ausführt
  - [x] Highscorescene Link zu /best
  - [x] Zeit bei Schülerversion nicht veränderbar

  ##### ==> Für eine komplette und aktuelle Liste der geplanten Arbeitsschritte siehe [To-do-Liste auf Trello](https://trello.com/b/rFxNzqG5)
