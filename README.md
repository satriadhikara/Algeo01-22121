# Tugas Besar Aljabar Linier dan Geometri 1 - Kelompok JOJIKA

## Anggota

1. 13522121 Jonathan Emmanuel Saragih
2. 13522125 Satriadhikara Panji Yudhistira
3. 13522128 Mohammad Andhika Fadillah

## Deskripsi Program

Program kalkulator matriks untuk menyelesaikan permasalahan dalam bentuk matriks dengan metode yang diajarkan dalam mata kuliah Aljabar Linier dan Geometri.

## Struktur Program

```bash
src
|  README.md
|
|__program
   |  Main.java
   |
   |__ADT
   |  |  Matrix.java
   |  |
   |  |__IO
   |  |    InputFile.java
   |  |    InputTerminal.java
   |  |    Output.java
   |  |
   |  |
   |  |__primitives
   |       OperasiAritmatika.java
   |       OperasiIdentitas.java
   |       OperasiRelasional.java
   |       Determinan.java
   |
   |
   |__SPL
   |    Cramer.java
   |    Gauss.java
   |    Gauss-Jordan.java
   |    Invers.java
   |
   |
   |__Interpolasi
   |    Polinom.java
   |    Bicubic.java
   |
   |
   |__Util
        Menu.java
        Settings.java

```

## Cara Menjalankan Program

Dalam terminal directory utama:

```bash
cd src ; javac -d ../bin ./program/*.java ; cd .. ; java -cp bin program.Main
```
