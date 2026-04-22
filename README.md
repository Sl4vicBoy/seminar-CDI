# Uruchomienie aplikacji

## Wymagania wspólne

### Java

* Java (maksymalnie wersja 17)

Projekt używa Maven Wrapper (`mvnw`), więc nie ma potrzeby instalowania Mavena ręcznie - odpowiednia wersja zostanie pobrana automatycznie podczas budowania projektu.

### TomEE

Do uruchomienia aplikacji wymagany jest serwer aplikacyjny Apache TomEE.

Wersja kompatybilna: TomEE 10.x (Java 17+ / Jakarta EE 10)

```bash
wget https://archive.apache.org/dist/tomee/tomee-10.1.4/apache-tomee-10.1.4-webprofile.tar.gz
```

Rozpakowanie:

```bash
tar -xzf apache-tomee-10.1.4-webprofile.tar.gz
mv apache-tomee-10.1.4-webprofile tomee
```

### Pobranie projektu

Repozytorium:

```bash
git clone https://github.com/Sl4vicBoy/seminar-CDI
```

lub pobranie plików z UPEL.

# Uruchomienie - Linux (terminal + VS Code)

## 1. Wejście do projektu

```bash
cd seminar-CDI
```

## 2. Nadanie uprawnień

```bash
chmod +x mvnw
```

## 3. Budowanie projektu

```bash
./mvnw clean package
```

Po zakończeniu builda w katalogu:

```
target/
```

powstaje plik:

```
seminar-CDI.war
```

## 4. Deployment do TomEE

Skopiuj plik `.war`:

```bash
cp target/seminar-CDI.war ../tomee/webapps/
```

## 5. Uruchomienie serwera

```bash
cd ../tomee/bin
./startup.sh
```

## 6. Logi aplikacji

Logi można śledzić na bieżąco:

```bash
tail -f ../logs/catalina.out
```

## 7. Otworzenie aplikacji

```
http://localhost:8080/seminar-CDI
```

## 8. Zatrzymanie serwera

```bash
./shutdown.sh
```

# Uruchomienie – IntelliJ IDEA

## 1. Wymagania

* IntelliJ IDEA Community lub Ultimate
* Java 17 (może być skonfigurowana w IntelliJ)

## 2. Otworzenie projektu

* Uruchom IntelliJ
* Wybierz Open
* Wskaż folder:

```
seminar-CDI
```

IntelliJ automatycznie wykryje projekt Maven i zaproponuje jego import.

## 3. Ustawienie JDK

```
File → Project Structure → Project
```

Ustaw:

* Project SDK → Java 17

## 4. Maven w IntelliJ

Zakładka Maven powinna pojawić się po prawej stronie.

Jeśli jej nie ma:

```
View → Tool Windows → Maven
```

## 5. Budowanie projektu

W Maven:

```
Lifecycle → clean
Lifecycle → package
```

Po buildzie powstaje:

```
target/seminar-CDI.war
```

## 6. Konfiguracja uruchamiania TomEE

Kliknij Current File → Edit Configurations, obok, obok Run (▶)

Dodaj:

* TomEE Server (Local)

### Application Server

Wskaż katalog TomEE:

```
.../tomee
```

### Deployment

W zakładce Deployment:

* usuń domyślny artefakt

* dodaj:

```
seminar-CDI:war exploded
```

* ustaw Application context:

```
/seminar-CDI
```

Uwaga: Application context to adres URL aplikacji.

## 7. Uruchomienie aplikacji

Kliknij Run (▶) w IntelliJ.

Aplikacja zostanie zbudowana, wdrożona i uruchomiona automatycznie.

## 8. Logi aplikacji

Logi dostępne są:

* w konsoli Run konfiguracji TomEE w IntelliJ
* oraz w pliku:

```
tomee/logs/catalina.out
```

## 9. Zatrzymanie aplikacji

Kliknij Stop (■) w IntelliJ.
