# Uruchomienie aplikacji (Linux - terminal + vscode)

## Wymagania

* **Java (maksymalnie wersja 17)**

> Projekt używa **Maven Wrapper (`mvnw`)**, więc nie trzeba instalować Mavena ręcznie, odpowiednia wersja zostanie pobrana automatycznie.

---

## 1. Pobranie i wejście do projektu

Sklonuj repozytorium:

```bash
git clone <URL_DO_REPO>
cd seminar-CDI
```
lub pobierz pliki z upela.
---

## 🔐 2. Nadanie uprawnień

Nadaj uprawnienia dla Maven Wrappera,  znajdującemu się w głównym katalogu projektu:

```bash
chmod +x mvnw
```

---

## 3. Budowanie projektu

Zbuduj aplikację:

```bash
./mvnw clean package
```

Po zakończeniu w katalogu:

```
target/
```

pojawi się plik:

```
seminar-CDI.war
```

---

##  4. Instalacja i przygotowanie TomEE

Pobierz TomEE, przykładowo:

```bash
wget https://archive.apache.org/dist/tomee/tomee-9.1.2/apache-tomee-9.1.2-webprofile.tar.gz
```

Rozpakuj i przygotuj:

```bash
tar -xzf apache-tomee-9.1.2-webprofile.tar.gz
mv apache-tomee-9.1.2-webprofile tomee
cd tomee
```

---

##  5. Deployment aplikacji

Skopiuj plik `seminar-CDI.war` do katalogu `webapps`:

```bash
cp ../target/seminar-CDI.war webapps/
```

---

## 6. Uruchomienie serwera

Przejdź do katalogu `bin` i uruchom TomEE:

```bash
cd bin
./startup.sh
```

---

##  7. Podgląd logów (na żywo)

Możesz na bieżąco śledzić działanie aplikacji oraz logi:

```bash
tail -f ../logs/catalina.out
```

---

## 8. Otworzenie aplikacji

Otwórz w przeglądarce:

```
http://localhost:8080/seminar-CDI
```

---

## 9. Zatrzymanie serwera

Aby zatrzymać TomEE:

```bash
./shutdown.sh
```

---

## (Opcjonalnie) VS Code

Możesz otworzyć projekt w VS Code:

```bash
code .
```

Zalecane rozszerzenia:

* Extension Pack for Java
* Maven for Java

---

Gotowe
