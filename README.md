Projekt je izrađen u sklopu kolegija **Programiranje na Java virtualnom stroju.**


**FarmTrackDB** je web aplikacija za upravljanje podacima na farmi. Sustav omogućuje evidenciju životinja, praćenje osnovnih informacija te unos i pregled medicinskih zapisa.

Aplikacija omogućuje jednostavno upravljanje farmom kroz web sučelje koristeći CRUD operacije (pregled, dodavanje, uređivanje i brisanje podataka).

Projekt je izrađen korištenjem Spring Boota, MySQL baze podataka i Thymeleaf predložaka.

#Funkcionalnosti:
-Pregled svih životinja
-Dodavanje nove životinje
-Uređivanje postojeće životinje
-Brisanje životinje
-Prikaz detalja životinje (karton životinje)
-Pretraga životinja po imenu
-Evidencija medicinskih zapisa po životinji
-Validacija unosa podataka

#**Tehnologije:**
##**Backend:**
Java
Spring Boot
Spring Data JPA
MySQL

##**Frontend:**
Thymeleaf
HTML
Bootstrap 5
CSS


Aplikacija koristi **MySQL** bazu podataka.

##Primjer baze:

**CREATE DATABASE farmtrackdb;**

 Konfiguracija baze

**U application.properties:**

spring.datasource.url=jdbc:mysql://localhost:3306/farmtrackdb
spring.datasource.username=root
spring.datasource.password=lozinka

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

##_Pokretanje aplikacije_
Kreirati MySQL bazu farmtrackdb
Pokrenuti projekt u IntelliJ IDEA
**Pokrenuti glavnu klasu:**
FarmTrackApplication
**Otvoriti u pregledniku:**
http://localhost:8080
