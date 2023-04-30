# proyek-grafkom
Repo untuk proyek grafkom
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Louis Arthur - C14210048 [KELAS B] -> Membuat Magnemite
Ryan David - C14210262 [KELAS B] -> Membuat Oshawott
Timutius Alvin - C14210172 [KELAS B] -> Membuat Marill
Adi Christian - C14210091 [KELAS A] -> Membuat Regice
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
- Main.java hanya berisi pokemon Regice
- Main2.java hanya berisi pokemon Magnemite
- Main3.java hanya berisi pokemon Oshawott
- Main4.java hanya berisi pokemon Marill
- MainGabung.java (case 0, case 1, case 2, case 3) berisi Regice, Magnemite, Oshawott, dan Marill secara terpisah
- MainGabung.java (case 4 / battle state) berisi semua pokemon dalam 1 layar

* Saat record video, kami menggunakan MainGabung sesuai ketentuan, bukan menggunakan Main sendiri-sendiri.

.

Di MainGabungan, kami menggunakan switch case. Terdapat 5 case, mulai dari case 0 sampai case 4.
Saat MainGabungan di run, defaultnya adalah case 0. Untuk berganti ke case lain, bisa klik trigger yang akan disebutkan di bawah.

- Pada case 0, hanya terdapat pokemon regice. Untuk trigger case 0, bisa klik "Z".
- Pada case 1, hanya terdapat pokemon magnemite. Untuk trigger case 1, bisa klik "X".
- Pada case 2, hanya terdapat pokemon Oshawott. Untuk trigger case 2, bisa klik "C".
- Pada case 3, hanya terdapat pokemon Marill. Untuk trigger case 3, bisa klik "V".
- Pada case 4, terdapat semua pokemon. Environmentnya juga sedikit berbeda. Case 4 ini kami sebut battle state, karena itu saat case 4 dijalankan, kami men-spawn sphere untuk menjadi arena bertarung pokemon. Untuk trigger case 4, bisa klik "B".


Berikut merupakan key apa saja yang bisa ditekan di MainGabung:

1. Switch Mode (Case) Trigger
- B: battle state (gabungan)
- Z: adi solo
- X: louis solo
- C: ryan solo
- V: timotius solo

*solo berarti pokemonnya sendirian

2. Gerakan Bersama
- W: translate atas
- A: translate kiri
- S: translate bawah
- D: translate kanan
- I: rotate atas
- J: rotate kiri
- K: rotate bawah
- L: rotate kanan
- T: scale up
- G: scale down
- R: reset to default position

3. Gerakan Regice
- Q: attack animation Regice

4. Gerakan Magnemite
- LEFT ARROW: rotate offset Z (kiri)
- RIGHT ARROW: rotate offset Z (kanan)
- 9: attack animation Magnemite
- 0: eye animation

5. Gerakan Oshawott
- 1: hand animation
- 2: feet animation
- 3: tail animation
- 4: 180 degree rotation
- 5: masuk pokeball
- 6: keluar pokeball
- 7: bubble beam animation

Catatan:
- Di case 0, yang bisa ditekan adalah switch mode trigger, gerakan bersama, dan gerakan Regice.
- Di case 1, yang bisa ditekan adalah switch mode trigger, gerakan bersama, dan gerakan Magnemite.
- Di case 2, yang bisa ditekan adalah switch mode trigger, gerakan bersama, dan gerakan Oshawott.
- Di case 3, yang bisa ditekan adalah switch mode trigger dan gerakan bersama.
- Di case 4, semua key yang disebutkan diatas bisa ditekan.

*saat attack animation sedang berjalan, semua gerakan akan di-disable sampai animasi selesai.
